import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InsuranceDataReader {
    List<InsuranceData> insuranceDataList = new ArrayList<>();

    public List<InsuranceData> getInsuranceDataList() {
        return insuranceDataList;
    }

    public InsuranceDataReader(String fileName) {
        try(FileReader f = new FileReader(fileName); BufferedReader br = new BufferedReader(f)){
            String line;
            boolean flag = false;
            while((line = br.readLine()) != null){
                if(flag == false){
                    flag = true;
                }
                else{
                    String[] str = line.split(",");
                    String tempRegion;
                    if(str[5].equals(""))
                        tempRegion = null;
                    else
                        tempRegion = str[5]
;                    InsuranceData i = new InsuranceData(Integer.parseInt(str[0]), str[1], Float.parseFloat(str[2]), Integer.parseInt(str[3]), str[4], tempRegion, Double.parseDouble(str[6]));
                    insuranceDataList.add(i);
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
