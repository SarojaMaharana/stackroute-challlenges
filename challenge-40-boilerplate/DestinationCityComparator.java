import java.util.Comparator;

public class DestinationCityComparator implements Comparator<Routes> {

    @Override
    public int compare(Routes o1, Routes o2) {
        // TODO Auto-generated method stub
        return (o1.getDestinationCity().compareTo(o2.getDestinationCity()));
    }
    
}
