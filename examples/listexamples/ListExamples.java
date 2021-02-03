import java.util.ArrayList;
import java.util.Iterator;

public class ListExamples {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add(10);
        list.add("hello");
        list.add('a');
        list.add(13.5);

        System.out.println(list);

        //methods of a list
        list.add(2,20);
        list.set(1,"hi");
        list.remove(3);
       // boolean b = list.remove('a');
        System.out.println("does list contain 10 : "+list.contains(10));
        System.out.println("Index of element : "+list.indexOf(13.5));
        System.out.println("is list empty : "+list.isEmpty());
        System.out.println(list);
        System.out.println(list.size());
        //Iteration
        for(int i = 0;i<list.size();i++)
            System.out.println(list.get(i));
        //Iterator to iterate
        Iterator itr = list.iterator();
        while(itr.hasNext())
        {
          System.out.println(itr.next());
        }

        list.clear();
        System.out.println("is list empty : "+list.isEmpty());

    }
}
