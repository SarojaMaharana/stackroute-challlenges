import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamExample {
    static void readFile(String fileName) throws FileNotFoundException,IOException
    {//try-with-resources
        try(FileInputStream fs = new FileInputStream(fileName))
        {
            int aChar = 0;
            while((aChar = fs.read())!=-1)
            {
                System.out.println((char)aChar);
            }
        }
    }
    static void readFileBuffer(String fileName) throws FileNotFoundException,IOException
    {
        //File -> stream -> buffer
        try(BufferedInputStream br = new BufferedInputStream(new FileInputStream(fileName)))
        {
            int aChar = 0;
            while((aChar = br.read())!=-1)
            {
                System.out.println((char)aChar);
            }
        }
    }
    //read from a file byte by byte
    public static void main(String[] args) {
        
            try {
                readFileBuffer("./test.txt");
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
       
    }
}