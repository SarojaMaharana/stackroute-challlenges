import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        // TODO Auto-generated method stub
        return (o1.getRetailPrice() - o2.getRetailPrice());
    }
    
}
