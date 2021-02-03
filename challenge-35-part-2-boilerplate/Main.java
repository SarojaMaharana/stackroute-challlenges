import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char ch = 'n';
        int countOfFiles = 0;

        do{
            countOfFiles++;
            System.out.println("Enter the filename number: " +countOfFiles);
            String fileName = sc.next();
            TextFileAnalyzer file = new TextFileAnalyzer(fileName);
            fileLinkedList fll = new fileLinkedList();
            fll.insert(file);
            fll.traverse();
            System.out.println("Do you want to continue with entering the files: (y/n)");
            ch = sc.next().charAt(0);
        } while(ch == 'y');
        sc.close();
    }
}
