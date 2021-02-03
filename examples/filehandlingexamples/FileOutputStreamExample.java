import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {

    public static void main(String[] args) {
        String str = "Thank God its Friday !!";
        byte[] bytes = str.getBytes();
        try(FileOutputStream fos = new FileOutputStream("./write.txt");)
        {
            fos.write(bytes);
            fos.write(98);
        }
        catch(IOException e)
        {

        }
        //Date java.util.Date
        // LocalDate
        
    }
}
