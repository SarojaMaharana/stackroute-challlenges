import java.util.Comparator;

public class RatingComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        // TODO Auto-generated method stub
        return (o1.getRating().compareTo(o2.getRating()));
    }
    
}
