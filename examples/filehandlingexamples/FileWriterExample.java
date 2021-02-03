import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    static void writeToAFile(String fileName) throws IOException
   {
       File file = new File(fileName);
       try(BufferedWriter bw = new BufferedWriter(new FileWriter(file)))
       {
           bw.write("Have a good day");
           bw.append("A file writer example....Hello");
       }
   } 
   public static void main(String[] args) {
       try {
           writeToAFile("./write1.txt");
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
