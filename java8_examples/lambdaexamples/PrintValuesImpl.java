import java.util.Scanner;

public class PrintValuesImpl {

    public void display(int c)
    {
       ReturnNumber r = () ->{
           while(c>0)
           {
               c--;
           }
           return 10;
       };
    }
    public static void main(String[] args) {
        //printValues(int x, String y )
        final int b =30; //final
        
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        PrintValues pr = (x,y) -> {
            if(x>10)
                return a+y;
            else 
                return " x is not greater than 10";

        };
    }
}
