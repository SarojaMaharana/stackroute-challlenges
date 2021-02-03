import java.util.Collections;
import java.util.LinkedList;

public class TextAnalyzer {
    private static void showWordList(LinkedList<Word> list){
        for(Word w:list){
            System.out.println(w.getWord()+"->"+w.getOccurance());
        }
    }
    private static void showFrequentWords(LinkedList<Word> list){
        Collections.sort(list, new OccurenceComparator());
        int maxOccurence = list.getLast().getOccurance();
        System.out.println("Frequent Words are:");
        for(Word w:list){
            if(w.getOccurance() == maxOccurence)
                System.out.println(w.getWord());
        }
    }
    public static void main(String[] args) {
        long startTime=0, endTime = 0;
        WordsReader wr = new WordsReader("data/daffodils.txt");
        LinkedList<Word> data = wr.getWordList();
        startTime = System.currentTimeMillis();
        System.out.println("The original data is:");
        showWordList(data);
        endTime = System.currentTimeMillis();
        System.out.println("The time taken to traverse is: " +(endTime-startTime)+ "ms");
        System.out.println();
        System.out.println();
        startTime = System.currentTimeMillis();
        Collections.sort(data, new WordComparator());
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to sort is: " +(endTime-startTime)+ "ms");
        System.out.println("The sorted data is:");
        showWordList(data);
        System.out.println();
        startTime = System.currentTimeMillis();
        showFrequentWords(data);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to show frequent words is: " +(endTime-startTime)+ "ms");
    }
}
