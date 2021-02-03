import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class WordsReader {
    private LinkedList<Word> wordList = new LinkedList<>();
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
                        Word w = new Word(word, 1);
                        boolean flag = false;
                        for(Word wo:wordList){
                            if(wo.getWord().equalsIgnoreCase(w.getWord())){
                                wo.setOccurance(wo.getOccurance() + 1);
                                flag = true;
                            }
                        }
                        if(flag != true)
                            wordList.add(w);
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

    public LinkedList<Word> getWordList() {
        return wordList;
    }
    
}
