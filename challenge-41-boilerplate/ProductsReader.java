import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductsReader {
    private ArrayList<Product> productList = new ArrayList<>();
    
    public ProductsReader(String fileName) {
        try(FileReader f = new FileReader(fileName); BufferedReader br = new BufferedReader(f)){
            String line;
            boolean flag = false;
            while((line = br.readLine())!=null){
                if(flag == false){
                    flag = true;
                }
                else{
                    Product p = new Product(line);
                    productList.add(p);
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
    
}
