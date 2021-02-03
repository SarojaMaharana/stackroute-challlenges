import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDetailsReader {
    private List<PurchaseDetails> purchaseDetailsList = new ArrayList<>();

    public List<PurchaseDetails> getPurchaseDetailsList() {
        return purchaseDetailsList;
    }

    public PurchaseDetailsReader(String fileName) {
        try(FileReader f = new FileReader(fileName); BufferedReader br = new BufferedReader(f)){
            String line;
            boolean flag = false;
            while((line = br.readLine()) != null){
                if(flag == false){
                    flag = true;
                }
                else{
                    String[] str = line.split(",");
                    PurchaseDetails p = new PurchaseDetails(str[0], Long.parseLong(str[1]), Integer.parseInt(str[2]), str[3], Float.parseFloat(str[4]), Float.parseFloat(str[5]), Integer.parseInt(str[6]));
                    purchaseDetailsList.add(p);
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
