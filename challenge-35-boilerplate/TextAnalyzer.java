import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextAnalyzer {

    public static SingleLinkedList readFile(String fileName){
        SingleLinkedList sl = new SingleLinkedList();

        try(FileReader f = new FileReader(fileName); BufferedReader br = new BufferedReader(f)){
            String line;
            String[] words = null;
            while((line = br.readLine())!=null){
                // line = line.replaceAll("[^a-zA-Z0-9]", " ").replaceAll("[\\s+]", "");
                line = line.replaceAll("[^A-Za-z0-9]", " ").toLowerCase();
                words = line.split(" ");
                for(String word:words){
                    if(!word.equals(" ")){
                        Word w = new Word(word,1);
                        sl.insert(w);
                    }
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return sl;
    }

    public static void displayList(SingleLinkedList sl){
        sl.traverse();
    }

    public static void callRemoveDuplicates(SingleLinkedList sl){
        sl.removeDuplicates();
    }

    public static void callSort(SingleLinkedList sl){
        sl.sort();
        System.out.println();
        System.out.println();
        System.out.println("Sorted data");
        displayList(sl);
    }

    public static void callReverseSort(SingleLinkedList sl){
        sl.sortReverse();
        System.out.println();
        System.out.println();
        System.out.println("Sorted data in reverse order");
        displayList(sl);
    }

    public static void callsortWithOccurences(SingleLinkedList sl){
        sl.showFrequentWords();
        System.out.println();
        System.out.println();
        System.out.println("Sorted data by the occurance");
        displayList(sl);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SingleLinkedList originalData = readFile("data/daffodils.txt");
        
        long startTime=0, endTime = 0;
        System.out.println("The data with its occurences is:");
        startTime = System.currentTimeMillis();
        displayList(originalData);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to complete this operation is: " +(endTime-startTime)+ "ms");
        System.out.println();
        char ch = 'n';

        do{
            System.out.println("Enter your choice of operations: \n1. Remove Duplicates\n2. Sort in Ascending Order\n3. Sort in Descending Order\n4. Show words by Occurence");
            int choice = sc.nextInt();

            switch(choice){
                case 1: startTime = System.currentTimeMillis();
                        callRemoveDuplicates(originalData);
                        endTime = System.currentTimeMillis();
                        displayList(originalData);
                        System.out.println("Time taken to complete this operation is: " +(endTime-startTime)+ "ms");
                        System.out.println();
                        break;

                case 2: startTime = System.currentTimeMillis();
                        callSort(originalData);
                        endTime = System.currentTimeMillis();
                        displayList(originalData);
                        System.out.println("Time taken to complete this operation is: " +(endTime-startTime)+ "ms");
                        System.out.println();
                        break;

                case 3: startTime = System.currentTimeMillis();
                        callReverseSort(originalData);
                        endTime = System.currentTimeMillis();
                        displayList(originalData);
                        System.out.println("Time taken to complete this operation is: " +(endTime-startTime)+ "ms");
                        System.out.println();
                        break;

                case 4: startTime = System.currentTimeMillis();
                        callsortWithOccurences(originalData);
                        endTime = System.currentTimeMillis();
                        displayList(originalData);
                        System.out.println("Time taken to complete this operation is: " +(endTime-startTime)+ "ms");
                        System.out.println();
                        break;
                default: System.out.println("Wrong choice:");
            }

            System.out.println("Do you wish to continue (y/n):");
            ch = sc.next().charAt(0);
        } while(ch == 'y');
        sc.close();
    }
}
