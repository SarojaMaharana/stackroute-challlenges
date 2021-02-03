import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import static java.time.temporal.ChronoUnit.HOURS;

public class DateTimeOperations{
    static String loginTimeToAdd;
    static String logoutTimeToAdd;

    static void writeToFile(String fileName, String toWrite){
        File file = new File(fileName);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            bw.append(toWrite);
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    static List<EmployeeData> readFromFile(String fileName){
        Path path = Paths.get(fileName);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d-MM-uuuu");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);
        List<EmployeeData> employeeDataList = new ArrayList<>();
        List<String> strList;
        boolean flag = false;
    
        try{
            strList = Files.readAllLines(path);
            for(String s:strList){
                if(flag == false){
                    flag = true;
                    continue;
                }
                loginTimeToAdd = "";
                logoutTimeToAdd = "";
                s = s.replace("\t", ",");
                String[] str = s.split(",");
                Stream.of(str[2].split(":")).forEach(i -> {
                    if(i.length() == 1){
                        loginTimeToAdd = loginTimeToAdd + String.valueOf(Integer.parseInt(i)+100).substring(1)+":";
                    }
                    else
                        loginTimeToAdd = loginTimeToAdd + i + ":";
                });
                Stream.of(str[3].split(":")).forEach(i -> {
                    if(i.length() == 1){
                        logoutTimeToAdd = logoutTimeToAdd + String.valueOf(Integer.parseInt(i)+100).substring(1)+":";
                    }
                    else
                        logoutTimeToAdd = logoutTimeToAdd + i + ":";
                });
                
                EmployeeData e = new EmployeeData(str[0], LocalDate.parse(str[1], dateFormatter), LocalTime.parse(loginTimeToAdd.substring(0, loginTimeToAdd.length()-1), timeFormatter), LocalTime.parse(logoutTimeToAdd.substring(0, logoutTimeToAdd.length()-1), timeFormatter), Integer.parseInt(str[4]));
                employeeDataList.add(e);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return employeeDataList;
    }

    static Set<String> getEmployeeNameSet(List<EmployeeData> ed){
        Set<String> ens = new HashSet<>();
        ed.forEach(i -> ens.add(i.getEmployeeName()));
        return ens;
    }

    static Map<String, Long> getEmployeeWorkHours(Set<String> ns, List<EmployeeData> ed){
        Map<String, Long> eawh = new HashMap<>();
        for(String str: ns){
            long workHours = 0;
            for(EmployeeData e: ed){
                if(str.equalsIgnoreCase(e.getEmployeeName())){
                    workHours = workHours + HOURS.between(e.getLoginTime(), e.getLogoutTime());
                }
            }
            eawh.put(str, workHours);
        }
        return eawh;
    }

    static void calculateCompensatoryOffDays(Map<String, Long> map){
        writeToFile("compensatoryOffDays.csv", "Employee Name,Compensatory Days\n");
        map.forEach((key, value) -> {
            if(value > 35){
                writeToFile("compensatoryOffDays.csv", key+","+String.valueOf((int)((value-35)/7))+"\n");
            }
        });
    }

    static void calculateHoursClockedPerDay(Set<String> ns, List<EmployeeData> ed){
        for(String s:ns){
            for(EmployeeData e:ed){
                if(s.equalsIgnoreCase(e.getEmployeeName())){
                    if(HOURS.between(e.getLoginTime(), e.getLogoutTime()) < 7){
                        writeToFile("dayWise.txt", s+" did not complete his/her 7 hrs on "+e.getWorkDate()+"\n");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<EmployeeData> employeeDataList  = readFromFile("employeetime.csv");
        Set<String> employeeNameSet = getEmployeeNameSet(employeeDataList);
        Map<String, Long> employeeAndWorkHours = getEmployeeWorkHours(employeeNameSet, employeeDataList);

        System.out.println("Employees who have clocked 35 hours per week:");
        employeeAndWorkHours.forEach((key, value) -> {
            if(value == 35)
                System.out.println(key); 
        });
        System.out.println();

        System.out.println("Employees who have clocked more than 35 hours in a week:");
        writeToFile("extraHoursClockedByEmployee.csv", "Employee Name,Extra hours\n");
        employeeAndWorkHours.forEach((key, value) -> {
            if(value > 35){
                System.out.println(key+" -> "+value+" hrs");
                writeToFile("extraHoursClockedByEmployee.csv", key + ","+(value-35)+"\n");
            }
        });
        System.out.println("Created a file extraHoursClockedByEmployee.csv");
        System.out.println();

        calculateCompensatoryOffDays(employeeAndWorkHours);
        System.out.println("Created a file compensatoryOffDays.csv");
        System.out.println();

        calculateHoursClockedPerDay(employeeNameSet, employeeDataList);
        System.out.println("Created a file dayWise.txt where employees who have not clocked 7 hours per day everyday");
        System.out.println();
    }
}