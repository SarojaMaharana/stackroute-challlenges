import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Doctor{
    private int personalID;
    private String empID;
    private String doctorName;
    private double salary;
    private int age;
    private boolean presence;

    public Doctor(int personalID, String empID, String doctorName, double salary, int age) {
        this.personalID = personalID;
        this.empID = empID;
        this.doctorName = doctorName;
        this.salary = salary;
        this.age = age;
    }

    public int getPersonalID() {
        return personalID;
    }

    public void setPersonalID(int personalID) {
        this.personalID = personalID;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public void checkIn(){
        setPresence(true);
    }

    public void checkOut(){
        setPresence(false);
    }

    public void checkAssignedPatients(){
        // List<String> assignedPatients = new ArrayList<>();
        Map<String, String> assignedPatients = new HashMap<>();
        Path pathClinic = Paths.get("clinic.csv");
        Path pathPatient = Paths.get("");
        List<String> fileReaderList;

        try{
            fileReaderList = Files.readAllLines(pathClinic);
            for(String s:fileReaderList){
                if(s.substring(0, 6).equals(getEmpID()))
                    assignedPatients.put(s.substring(7, 11),null);
            }
            fileReaderList = Files.readAllLines(pathPatient);
            System.out.println("ID\tPatient Name");
            Set<Map.Entry<String, String>> entrySet = assignedPatients.entrySet();
            for(Map.Entry<String, String> me:entrySet){
                for(String s:fileReaderList){
                    if(s.substring(0, 5).equals(me.getKey())){
                        me.setValue(s.substring(0, 5));
                    }
                }
                System.out.println("Patient ID: "+me.getKey()+"\tPatient Name: " +me.getValue());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeToAFile(){
        File file = new File("DoctorDetails.csv");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.append(getPersonalID()+","+getEmpID()+","+getDoctorName()+","+getSalary()+","+getAge()+","+isPresence()+"\n");
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
}