import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileAnalyzer {
    private String filename;
    private String timeStamp;
    private int noOfWords;
    private int noOfCharacters;
    private int noOfLongwords;
    public wordSingleLinkedList wordList;

    public TextFileAnalyzer(String filename) {
        this.filename = filename;
        wordList = readFile(filename);
        setTimeStamp();
        noOfWords = wordList.noOfWords();
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    private void setTimeStamp() {
        this.timeStamp = java.time.LocalDateTime.now().toString();
    }

    public int getNoOfWords() {
        return noOfWords;
    }

    // public void setNoOfWords(int noOfWords) {
    //     this.noOfWords = noOfWords;
    // }

    public int getNoOfCharacters() {
        return noOfCharacters;
    }

    private void setNoOfCharacters(int noOfCharacters) {
        this.noOfCharacters = noOfCharacters;
    }

    public int getNoOfLongwords() {
        return noOfLongwords;
    }

    private void setNoOfLongwords(int noOfLongwords) {
        this.noOfLongwords = noOfLongwords;
    }

    private wordSingleLinkedList readFile(String fn){
        wordSingleLinkedList wsl = new wordSingleLinkedList();
        try(FileReader f = new FileReader(fn); BufferedReader br = new BufferedReader(f)){
            String line;
            int tempCount=0;
            int tempLongCount = 0;
            String[] words = null;
            while((line = br.readLine())!=null){
                tempCount = tempCount + line.length();
                line = line.replaceAll("[^A-Za-z0-9]", " ").toLowerCase();
                words = line.split(" ");
                for(String word:words){
                    if(!word.equals(" ")){
                        Word w = new Word(word,1);
                        wsl.insert(w);
                    }
                    if(word.length()>15)
                        tempLongCount++;
                }
                setNoOfCharacters(tempCount);
                setNoOfLongwords(tempLongCount);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return wsl;
    }

    public String getFilename() {
        return filename;
    }

    
}