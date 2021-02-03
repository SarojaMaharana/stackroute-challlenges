import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
       List<Student> studentList = new ArrayList<>();
       studentList.add(new Student("Raj", 345));
        studentList.add(new Student("Tina", 444));
        studentList.add(new Student("Sam", 345));
        studentList.add(new Student("Tom", 312));
        studentList.add(new Student("Hari", 345));
        studentList.add(new Student("Yanni", 405));
        studentList.add(new Student("Tim", 345));
        studentList.add(new Student("Ria", 534));
        studentList.add(new Student("Uma", 123));
        studentList.add(new Student("Gary", 234));
        studentList.add(new Student("Polly", 300));
        studentList.add(new Student("Ravi", 400));
        System.out.println("Before sorting : ");
        System.out.println(studentList);
        System.out.println("After Sorting");
       Collections.sort(studentList,new NameComparator());
        System.out.println(studentList);



        
    //    strList.add("clean car");
    //    strList.add("buy grocery");
    //    strList.add("take thrash out");

    //    strList.sort(null);

    //    System.out.println(strList);
    //     // by default it implements Comparable interface -> compareTo method
    //     //natural order. - 
    }
}
