import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DoublyLinkedListImpl {
    public static DoublyLinkedList readFromFile(String filename) {
        String line = null;
        DoublyLinkedList doubly = new DoublyLinkedList();
        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            while((line = br.readLine()) != null)
            {
                String numbers[] = line.split(",");
                for(int i = 0;i<numbers.length;i++)
                    doubly.insertEnd(Integer.parseInt(numbers[i]));
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return doubly;
    }

    public static void displayList(DoublyLinkedList dll)
    {
        dll.reverseTraversal();
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = readFromFile("E:\\JavaCodeWave2\\Week3\\Day4\\numbers.txt");
        System.out.println("Before deletion");
        displayList(dll);
        dll.delete(10);
        System.out.println("After deletion");
        displayList(dll);
    }
}
