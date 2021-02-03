import java.util.Arrays;
import java.util.List;

public class ArrayToList {
    public static void main(String[] args) {
        //convert array to list
        String strArr [] = new String[]{"Good","Morning","it's","a","Monday"};
        List<String>  messages = Arrays.asList(strArr);
        System.out.println(messages);

        //convert list to an array
        System.out.println("Converted back to Array");
        String arr[] = messages.toArray(new String[0]);
        System.out.printf("%s %15s","Name","TotalMarks\n");
        for(String str:arr)
        {
           
            System.out.printf("%s %20d",str,324);
            System.out.println();
        }




    }
}
