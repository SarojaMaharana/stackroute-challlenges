import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MapExamples
{
    public static void main(String[] args) {
        //phone book -> name, phoneNo;
      
        Map<String,Integer> phoneMap = new HashMap<>();

        phoneMap.put("Harish",898767674);
        phoneMap.put("Ravi",898767675);
        phoneMap.put("Raj",868767674);
        phoneMap.put("Reshma",878767674);
        phoneMap.put("Tarun",888767674);
        phoneMap.put("Varun",898767674);
        phoneMap.put("Rohit",898767674);

        System.out.println(phoneMap);
        System.out.println(phoneMap.entrySet());
        System.out.println(phoneMap.keySet());
        System.out.println(phoneMap.size());
        System.out.println(phoneMap.containsKey("Ravi"));
        System.out.println(phoneMap.containsValue(898767674));

        phoneMap.remove(new String("Raj"));

        phoneMap.put("Tarun",1234);
        System.out.println(phoneMap);


        //Iteration

        //Iterator
        Set<Map.Entry<String,Integer>> set = phoneMap.entrySet();
       System.out.println("Using iterator");
        Iterator<Entry<String,Integer>> itr = set.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

        //for loop
        System.out.println("Using for loop");
        for(Map.Entry<String,Integer> me:set)
            System.out.println(me);




    }
}