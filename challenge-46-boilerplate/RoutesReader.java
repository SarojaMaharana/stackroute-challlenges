import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoutesReader {
    private List<Route> routeList = new ArrayList<>();
    
    public RoutesReader(String fileName){
        try(FileReader f = new FileReader(fileName); BufferedReader br = new BufferedReader(f)){
            String line;
            boolean flag = false;
            while((line = br.readLine())!=null){
                String[] str = line.split(",");
                if(flag == false){
                    flag = true;
                }
                else{
                    Route r = new Route(str[0], str[1], Long.parseLong(str[2]), Integer.parseInt(str[3]), Long.parseLong(str[4]), Integer.parseInt(str[5]), str[6], str[7], Integer.parseInt(str[8]), Float.parseFloat(str[9]));
                    routeList.add(r);
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public List<Route> getRouteList() {
        return routeList;
    }
}