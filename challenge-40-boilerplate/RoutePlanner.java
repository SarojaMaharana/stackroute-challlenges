import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RoutePlanner {

    private static String calculateTime(String str1, String str2){
        String[] s1 = str1.split(":");
        String[] s2 = str2.split(":");
        int minutes = Integer.parseInt(s1[1]) + Integer.parseInt(s2[1]);
        int hours = Integer.parseInt(s1[0]) + Integer.parseInt(s2[0]);
        if(minutes > 59){
            minutes = minutes - 60;
            hours = hours + 1;
        }
        String toReturn = Integer.toString(hours)+":"+Integer.toString(minutes);
        return toReturn;
    }

    private static float otherToINR(float value, String desired){
        float toReturn = 0f;
        switch(desired){
            case "USD": toReturn = (value*74.3f);
                        break;
            case "GBP": toReturn = (value*94.5f);
                        break;
            case "JPY": toReturn = (value*0.67f);
                        break;
            case "EUR": toReturn = (value*85.37f);
                        break;
            case "AED": toReturn = (value*20.25f);
                        break;
            default: System.out.println("Wrong source currency");
        }
        return toReturn;
    }

    private static String calculateCurrency(String str1, String str2){
        String currency1 = str1.substring(0, 3);
        String currency2 = str2.substring(0, 3);
        int money1 = Integer.parseInt(str1.substring(3));
        int money2 = Integer.parseInt(str2.substring(3));
        float total = 0f;
        if(currency1.compareTo(currency2) == 0)
            total = money1 + money2;
        else{
            String soruceCurrency = currency2;
            String desiredCurrency = currency1;
            float toConvert = money2;
            float temp = 0f;
            if(soruceCurrency == "INR"){
                temp = toConvert;
            }    
            else {
                temp = otherToINR(toConvert, soruceCurrency);
            }
            switch(desiredCurrency){
                case "INR": total = money1 + temp;
                            break;
                case "USD": total = money1 + (temp/74.3f);
                            break;
                case "GBP": total = money1 + (temp/94.5f);
                            break;
                case "JPY": total = money1 + (temp/0.67f);
                            break;
                case "EUR": total = money1 + (temp/85.37f);
                            break;
                case "AED": total = money1 + (temp/20.25f);
                            break;
                default: System.out.println("Wrong desired currency");
            }    
        }
        String toReturn = currency1 + Integer.toString((int) total);
        return toReturn;
    }

    public static ArrayList<Routes> showDirectFlights(ArrayList<Routes> routes, String fromCity){
        ArrayList<Routes> toReturn = new ArrayList<>();

        for(Routes r: routes){
            if(r.getSourceCity().compareTo(fromCity) == 0){
                toReturn.add(r);
            }
        }   
        return toReturn;
    }

    public static void showAllConnections(ArrayList<Routes> routes, String fromCity, String toCity){
        int counter = 1;
        System.out.println("SNo.\tFrom\t\tTo\t\tDistance in Kms\t\tTravel Time\t\tTypical Airfare");
        for(Routes r: routes){
            if(r.getSourceCity().compareTo(fromCity) == 0 && r.getDestinationCity().compareTo(toCity) == 0){
                System.out.println(counter+"\t"+r.getSourceCity()+"\t\t"+r.getDestinationCity()+"\t\t"+r.getDistance()+"\t\t"+r.getFlightTime()+"\t\t"+r.getCost());
                counter++;
            }
            else if(r.getSourceCity().compareTo(fromCity) == 0){
                for(Routes r1:routes){
                    if(r.getDestinationCity().compareTo(r1.getSourceCity()) == 0 && r1.getDestinationCity().compareTo(toCity) == 0){
                        System.out.println(counter+"\t"+r.getSourceCity()+"\t\t"+r.getDestinationCity()+"\t\t"+r.getDistance()+"\t\t"+r.getFlightTime()+"\t\t"+r.getCost());
                        System.out.println("\t"+r1.getSourceCity()+"\t\t"+r1.getDestinationCity()+"\t\t"+r1.getDistance()+"\t\t"+r1.getFlightTime()+"\t\t"+r1.getCost());
                        System.out.println("\t\t\tTotal\t\t" +(r.getDistance()+r1.getDistance())+ "\t\t" +calculateTime(r.getFlightTime(), r1.getFlightTime())+ "\t\t" +calculateCurrency(r.getCost(), r1.getCost()));
                        counter++;
                    }
                }
            }
        }
    }

    private static void printRoutes(ArrayList<Routes> routes){
        int counter = 0;
        if(routes.isEmpty()){
            System.out.println("We are sorry. At this point in time we do not have any information on flights in the specified route");
        }
        else{
            System.out.println("SNo.\tFrom\t\tTo\t\tDistance in Kms\t\tTravel Time\t\tTypical Airfare");
            for(Routes r: routes){
                System.out.println(counter+"\t"+r.getSourceCity()+"\t\t"+r.getDestinationCity()+"\t\t"+r.getDistance()+"\t\t"+r.getFlightTime()+"\t\t"+r.getCost());
                counter++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Routes> arrList = new ArrayList<>();
        try(FileReader f = new FileReader("./sample-inputs.txt"); BufferedReader br = new BufferedReader(f)){
            String line;
            while((line = br.readLine())!=null){
                Routes r = new Routes(line);
                arrList.add(r);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        int option = 0;

        do{
            System.out.println("Press 1 to show all the routes.");
            System.out.println("Press 2 to show all the direct planes avaliable from a city.");
            System.out.println("Press 3 to show all the connections between from Source city and Destination city.");
            System.out.println("Press 4 to exit");
            option = sc.nextInt();

            switch(option){
                case 1: System.out.println();
                        System.out.println("Displaying all the routes");
                        System.out.println();
                        printRoutes(arrList);
                        System.out.println();
                        break;

                case 2: System.out.println();
                        System.out.println("Enter the Source city:");
                        String fromCity = sc.next();
                        ArrayList<Routes> directPlanes = showDirectFlights(arrList, fromCity);
                        Collections.sort(directPlanes, new DestinationCityComparator());
                        System.out.println();
                        System.out.println("Displaying the direct flights from " +fromCity);
                        printRoutes(directPlanes);
                        System.out.println();
                        break;

                case 3: System.out.println();
                        System.out.println("Enter the source city:");
                        String source = sc.next();
                        System.out.println("Enter the destination city:");
                        String destination = sc.next();
                        System.out.println();
                        System.out.println("Displaying all the connections between " +source+ " to " +destination);
                        showAllConnections(arrList, source, destination);
                        System.out.println();
                        break;

                case 4: break;

                default: System.out.println("Wrong choice");
            }
        } while(option != 4);
        sc.close();
    }
}
