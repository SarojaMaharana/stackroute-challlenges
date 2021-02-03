import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class WordsReader {
    private TreeMap<String, Integer> wordsMap = new TreeMap<>();
    public WordsReader(String fileName) {
        long startTime=0, endTime = 0;
        startTime = System.currentTimeMillis();
        try(FileReader f = new FileReader(fileName); BufferedReader br = new BufferedReader(f)){
            String line;
            String[] words = null;
            while((line = br.readLine())!=null){
                line = line.replaceAll("[^A-Za-z0-9]", " ").toLowerCase();
                words = line.split(" ");
                for(String word:words){
                    if(word.length()>0){
                        if(wordsMap.containsKey(word)){
                            int temp = wordsMap.get(new String(word));
                            wordsMap.put(word, temp+1);
                        }
                        else{
                            wordsMap.put(word, 1);
                        }
                    }
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        endTime = System.currentTimeMillis();
        System.out.println("The time taken to create the list is: " +(endTime-startTime)+ "ms");
    }

    public TreeMap<String, Integer> getWordsMap() {
        return wordsMap;
    }
    
}
