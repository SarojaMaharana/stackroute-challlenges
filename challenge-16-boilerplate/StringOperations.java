import java.util.Arrays;
import java.util.Scanner;

public class StringOperations {
    public void shortestWord(String[] str){
        String shortest = str[0];
        for(String i:str){
            if(i.length() < shortest.length())
                shortest = i;
        }
        System.out.println("The shortest word is : " +shortest);
    }

    public void searchWord(String[] str, String key){
        for(String i:str){
            if(i == key)
                System.out.println("The word is present in the list");
            else
                System.out.println("The word is not present in the list");
        }
    }

    public void sortStringArray(String[] str){
        String temp = "";

        for(int i=0;i<str.length; i++) {
            for(int j=i+1;j<str.length;j++){
                if(str[i].compareTo(str[j]) > 0){
                    temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        System.out.println("The sorted array is:");
        for(String i:str){
            System.out.println(i);
        }
    }

    public void stringPalindrome(String[] str){
        int count = 0;
        String[] toPrint = new String[str.length];
        for(int i=0;i<str.length;i++){
            char[] myArray = (str[i].toLowerCase()).toCharArray();
            int size = myArray.length;
            char [] original = Arrays.copyOf(myArray,myArray.length);

            for(int j=0;j<size/2;j++){
                char temp = myArray[j];
                myArray[j] = myArray[size-j-1];
                myArray[size-j-1] = temp;
            }

            if(Arrays.equals(myArray, original)){
                toPrint[count] = str[i];
                count ++;
            }
        }

        if(count>0){
            System.out.println("The number of palindromes in the list : " +count);
            for(int i=0;i<count;i++){
                System.out.println(toPrint[i]);
            }    
        }
        else{
            System.out.println("There are no palindromes in the list.");
        }
        
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringOperations obj = new StringOperations();

        System.out.println("Enter the number of words");
        int size = sc.nextInt();
        String[] str = new String[size];
        System.out.println("Enter the words: ");

        for(int i=0;i<size;i++){
            str[i] = sc.next();
        }

        obj.shortestWord(str);

        System.out.println("");
        System.out.println("");

        System.out.println("Enter a word to search: ");
        String key = sc.next();
        obj.searchWord(str, key);
        System.out.println("");
        System.out.println("");

        obj.sortStringArray(str);
        System.out.println("");
        System.out.println("");

        obj.stringPalindrome(str);

        sc.close();;
    }
}