import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextAnalyzerImp {

    public static TextAnalyzerBST readFile(String fileName){
        TextAnalyzerBST bt = new TextAnalyzerBST();
        try(FileReader f = new FileReader(fileName); BufferedReader br = new BufferedReader(f)){
            String line;
            String[] words = null;
            while((line = br.readLine())!=null){
                line = line.replaceAll("[^A-Za-z0-9]", " ").toLowerCase();
                words = line.split(" ");
                for(String word:words){
                    if(word.length()>0){
                        if(bt.searchTree(bt.root, word) == false){
                            Word w = new Word(word, 1);
                            bt.insert(bt.root, w);
                        }
                    }
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return bt;
    }

    public static void showTree(TextAnalyzerBST bt){
        bt.traversal(bt.root);
    }

    public static void showReverseTree(TextAnalyzerBST bt){
        bt.reverseTraversal(bt.root);
    }

    public static void main(String[] args){
        TextAnalyzerBST bt = null;
        long startTime=0, endTime = 0;

        startTime = System.currentTimeMillis();
        bt = readFile("data/daffodils.txt");
        endTime = System.currentTimeMillis();
        System.out.println("The time taken to create the tree is: " +(endTime-startTime)+ "ms");
        startTime = System.currentTimeMillis();
        showTree(bt);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to traverse throught the tree is: " +(endTime-startTime)+ "ms");
        startTime = System.currentTimeMillis();
        showReverseTree(bt);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to traverse throught the tree is: " +(endTime-startTime)+ "ms");
        // System.out.println("Total number of words: " +bt.size());
        TextAnalyzerBST temp = null;
        temp = bt;
        temp.toFlat(temp.root);
        temp.flatSort();
        temp.traversal(temp.root);
    }
}
