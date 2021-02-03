import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinarySearchTreeImpl {
    public static BinarySearchTree readFromFile(String fileName) throws IOException
    {
        String line=null;
        BinarySearchTree bst = new BinarySearchTree();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            while((line = br.readLine())!=null)
            {
                String st[] = line.split(", ");
                Student stud = null;
                for(int i=0;i<st.length;i++)
                {
                    stud = new Student(st[0],Integer.parseInt(st[1]));
                }
                bst.insert(bst.root,stud);
            }
           
        }
       
        return bst;
    }
    public static void showTree(BinarySearchTree bt)
    {
        bt.traversal(bt.root, Direction.INORDER);
       
    }

    public static void main(String[] args) {
        BinarySearchTree bst = null;
        try {
            bst = readFromFile("E:\\JavaCodeWave2\\Week3\\Day4\\studentMarks.txt");
        } catch (IOException e) {
           
            e.printStackTrace();
        }
        showTree(bst);
        bst.delete(45);
        System.out.println("*************After deletion****************");
        showTree(bst);
    }
}
