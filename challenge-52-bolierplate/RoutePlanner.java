import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RoutePlanner {
    static void showDirectFlights(List<RouteData> rd, String fromCity){
        System.out.println("Flights from "+fromCity+" are:");
        System.out.println("From City\tTo City\t\tDistance(KM)\tTravel Time\tFare");
        rd.stream().filter(p -> p.getFromLocation().equalsIgnoreCase(fromCity)).forEach(i -> System.out.println(i.getFromLocation()+"\t\t"+i.getToLocation()+"\t\t"+i.getDistanceInKM()+"\t\t"+i.getTravelTime()+"\t\t"+i.getTypicalFare()));
        System.out.println();
    }

    static void sortByDestination(List<RouteData> rd){
        System.out.println("Routes data sorted by the destination city:");
        System.out.println("From City\tTo City\t\tDistance(KM)\tTravel Time\tFare");
        rd.stream().sorted((o1,o2) -> o1.getToLocation().compareTo(o2.getToLocation())).forEach(i -> System.out.println(i.getFromLocation()+"\t\t"+i.getToLocation()+"\t\t"+i.getDistanceInKM()+"\t\t"+i.getTravelTime()+"\t\t"+i.getTypicalFare()));
        System.out.println();
    }

    static void showAllConnections(List<RouteData> rd, String fromCity, String toCity){
        System.out.println("From City\tTo City\t\tDistance(KM)\tTravel Time\tFare");
        rd.stream().filter(p -> p.getFromLocation().equalsIgnoreCase(fromCity) && p.getToLocation().equalsIgnoreCase(toCity)).forEach(i -> System.out.println(i.getFromLocation()+"\t\t"+i.getToLocation()+"\t\t"+i.getDistanceInKM()+"\t\t"+i.getTravelTime()+"\t\t"+i.getTypicalFare()));
        rd.stream().filter(p -> p.getFromLocation().equalsIgnoreCase(fromCity) || p.getToLocation().equalsIgnoreCase(toCity));
    }

    public static void main(String[] args) {
        Path fileReader = Paths.get("routes.csv");
        List<RouteData> routeDataList = new ArrayList<>();
        List<String> fileReaderList;
        try{
            fileReaderList = Files.readAllLines(fileReader);
            for(String s:fileReaderList){
                String[] str = s.split(", ");
                RouteData r = new RouteData(str[0], str[1], Integer.parseInt(str[2]), str[3], str[4]);
                routeDataList.add(r);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        routeDataList.forEach(System.out::println);
        showDirectFlights(routeDataList, "Delhi");
        sortByDestination(routeDataList);
    }
}
