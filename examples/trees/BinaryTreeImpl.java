import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinaryTreeImpl {

    public static BinaryTree readFromFile(String fileName) throws IOException
    {
        String line=null;
        BinaryTree bt = new BinaryTree();
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
                bt.insert(bt.root,stud);
            }
        }
        return bt;
    }

    public static void showTree(BinaryTree bt)
    {
        bt.traversal(bt.root, Direction.PREORDER);
    }

    public static void main(String[] args) {
        BinaryTree bt = null;
        try {
            bt = readFromFile("E:\\JavaCodeWave2\\Week3\\Day4\\studentMarks.txt");
        } catch (IOException e) {
           
            e.printStackTrace();
        }
        showTree(bt);
    }
}
