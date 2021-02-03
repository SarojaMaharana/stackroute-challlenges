import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextAnalyzerImp {
    static TextAnalyzerBST original = new TextAnalyzerBST();

    public static TextAnalyzerBT readFile(String fileName){
        TextAnalyzerBT bt = new TextAnalyzerBT();
        TextAnalyzerBST bst = new TextAnalyzerBST();
        try(FileReader f = new FileReader(fileName); BufferedReader br = new BufferedReader(f)){
            String line;
            String[] words = null;
            while((line = br.readLine())!=null){
                line = line.replaceAll("[^A-Za-z0-9]", " ").toLowerCase();
                words = line.split(" ");
                for(String word:words){
                    if(!word.equals(" ")){
                        Word w = new Word(word,1);
                        bt.insert(bt.root,w);
                        
                        if(bst.search(w) == null){
                            bst.insert(bst.root, w);
                        }
                        else{
                            bst.search(w).data.setOccurance(bst.search(w).data.getOccurance() + 1);
                        }
                        System.out.println(bst.search(w)+ "\t" +bst.search(w).data.getWord());
                    }
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        original = bst;
        return bt;
    }

    public static void showTree(TextAnalyzerBT bt, TextAnalyzerBST bst){
        bt.traversal(bt.root);
        System.out.println();
        System.out.println();
        System.out.println("Binary Search tree");
        System.out.println();
        System.out.println();
        bst.traversal(bst.root);
    }

    public static void main(String[] args){
        TextAnalyzerBT bt = null;
        bt = readFile("data/daffodils.txt");
        showTree(bt, original);
        System.out.println(bt.size());
        // System.out.println(original.root.data.getWord());
        // System.out.println(original.root.left.data.getWord());
        // System.out.println(original.root.right.data.getWord());
    }
}
