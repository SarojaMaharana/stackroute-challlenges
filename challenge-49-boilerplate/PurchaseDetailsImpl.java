import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PurchaseDetailsImpl {
    static void filterByPaymentMethod(List<PurchaseDetails> pd, Predicate<PurchaseDetails> pre){
        for(PurchaseDetails p:pd){
            if(pre.test(p))
                System.out.println("Customer id is: "+p.getCustomer_id()+" \tDate of purchase: "+p.getDate());
        }
    }

    static Consumer<PurchaseDetails> printByPurchasesOnDate(String date){
        return pd -> {
            if(pd.getDate().equals(date))
                System.out.println(pd);
        };
    }

    public static void main(String[] args) {
        PurchaseDetailsReader pdr = new PurchaseDetailsReader("sample.csv");
        List<PurchaseDetails> purchaseDetailsList = pdr.getPurchaseDetailsList();

        System.out.println("Displaying the date of purchase followed by the payment method.");
        purchaseDetailsList.forEach(i -> System.out.println("Purchase Date: "+i.getDate()+" \tPayment Method: "+i.getPayment_method()));
        System.out.println();

        Predicate<PurchaseDetails> paymentMethodPredicate = p -> p.getPayment_method().equalsIgnoreCase("credit");
        System.out.println("Displaying the customer_id, date of purchase for the customers who made purchase using credit cards only");
        filterByPaymentMethod(purchaseDetailsList, paymentMethodPredicate);
        System.out.println();

        Function<List<PurchaseDetails>, Integer> highestPurchaseProductCategory = (pd) -> {
            Set<Integer> categories = new HashSet<>();
            HashMap<Integer, Integer> categoriesCount = new HashMap<>();
            int max = 0;

            for(PurchaseDetails p:pd)
                categories.add(p.getProduct_category());
            for(Integer i:categories){
                int count = 0;
                for(PurchaseDetails p:pd){
                    if(i == p.getProduct_category())
                    count++;
                }
                if(max < count)
                    max = count;
                categoriesCount.put(i, count);
            }
            for(Integer key: categoriesCount.keySet()){
                if(max == categoriesCount.get(key))
                    max = key;
            }
            
            return max;
        };
        System.out.println("The product category for which the highest purchase made is: "+highestPurchaseProductCategory.apply(purchaseDetailsList));
        System.out.println();

        Supplier<Integer> totalClicksChange = () -> 1;
        for(PurchaseDetails p:purchaseDetailsList){
            if(p.getClicks_in_site() == 0)
                p.setClicks_in_site(totalClicksChange.get());
        }
        System.out.println("Replaced the total clicks to 1 if 0");
        System.out.println();

        System.out.println("Purchases made on 23/11/18");
        purchaseDetailsList.forEach(printByPurchasesOnDate("23/11/18"));
    }
}
