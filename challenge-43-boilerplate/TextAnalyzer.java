import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TextAnalyzer {
    static long startTime=0, endTime = 0;
    private static void showTree(TreeMap<String, Integer> tree){
        startTime = System.currentTimeMillis();
        Set<Map.Entry<String, Integer>> set = tree.entrySet();
        for(Map.Entry<String,Integer> me:set)
            System.out.println(me);
        endTime = System.currentTimeMillis();
        System.out.println("The time taken to show is: " +(endTime-startTime)+ "ms");
    }

    private static void showReverseTree(TreeMap<String, Integer> tree){
        startTime = System.currentTimeMillis();
        Set<Map.Entry<String, Integer>> set = tree.entrySet();
        List lst = new ArrayList<>();
        for(Map.Entry<String,Integer> me:set)
            lst.add(me);
        Collections.reverse(lst);
        System.out.println(lst);
        endTime = System.currentTimeMillis();
        System.out.println("The time taken for reverse print is: " +(endTime-startTime)+ "ms");
    }

    private static void showFrequentWords(TreeMap<String, Integer> tree){
        startTime = System.currentTimeMillis();
        int maxOccurence = tree.values().stream().max(Integer::compare).get();
        Set<Map.Entry<String, Integer>> set = tree.entrySet();
        for(Map.Entry<String,Integer> me:set){
            if(me.getValue() == maxOccurence)
                System.out.println(me);
        }
        endTime = System.currentTimeMillis();
        System.out.println("The time taken to show frequent words is: " +(endTime-startTime)+ "ms");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WordsReader wr = new WordsReader("data/daffodils.txt");
        TreeMap<String, Integer> data = wr.getWordsMap();
        int option = 0;
        do{
            System.out.println("Press 1 to show the words with occurence.");
            System.out.println("Press 2 to show the words in reverse order.");
            System.out.println("Press 3 to display the frequent words.");
            System.out.println("Press 4 to exit.");

            option = sc.nextInt();

            switch(option){
                case 1: System.out.println();
                        System.out.println("The words with occurence:");
                        showTree(data);
                        break;

                case 2: System.out.println();
                        System.out.println("The words in reverse order:");
                        showReverseTree(data);
                        break;

                case 3: System.out.println();
                        System.out.println("The frequent words:");
                        showFrequentWords(data);
                        break;
                
                case 4: break;
                default:System.out.println();
                        System.out.println("Wrong Choice");
            }
        }while(option != 4);

        sc.close();
    }
}
