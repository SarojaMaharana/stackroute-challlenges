import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {

    static void readFileReader(String fileName) throws FileNotFoundException,IOException
    {
        try(FileReader f = new FileReader(fileName);
            BufferedReader br = new BufferedReader(f))
        {//data files - comma seperated, /n line s
            String line;
            while((line = br.readLine())!=null)
            {
                System.out.println(line);
            }
        
        }
    }
    public static void main(String[] args) {
        try {
            readFileReader("./test.txt");
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
          
            e.printStackTrace();
        }
    }
}
