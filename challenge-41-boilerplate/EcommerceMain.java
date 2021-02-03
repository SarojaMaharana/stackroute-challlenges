import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class EcommerceMain {
    static void writeToAFile(String fileName, ArrayList<Product> arrList) throws IOException{
        File file = new File(fileName);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write("pid,product_name,brand,product_url,retail_price,discounted_price,product_rating\n");
            for(Product p:arrList){
                bw.append(p.getPid()+ "," +p.getProductName()+ "," +p.getBrand()+ "," +p.getProductUrl()+ "," +p.getRetailPrice()+ "," +p.getDiscountedPrice()+ "," +p.getRating()+ "\n");
            }
        }
    }
    public static void main(String[] args) {
        ProductsReader pdr = new ProductsReader("data/sample.csv");
        ArrayList<Product> data = pdr.getProductList();
        ArrayList<Product> dataSortPrice = data;
        ArrayList<Product> dataSortRating = data;
        Collections.sort(dataSortPrice, new PriceComparator());
        Collections.sort(dataSortRating, new RatingComparator());
        // for(Product p:dataSortRating)
        //     System.out.println(p.getPid()+ "\t" +p.getRating());
        try {
            writeToAFile("./ProductsSortedByPrice.txt", dataSortPrice);
            writeToAFile("./ProductsSortedByRating.txt", dataSortRating);
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
}
