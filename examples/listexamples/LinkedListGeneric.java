import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListGeneric {
    public static void main(String[] args) {
        LinkedList<Student> studentList = new LinkedList<>();
        studentList.add(new Student("Raj", 345));
        studentList.add(new Student("Tina", 405));
        studentList.add(new Student("Sam", 345));
        studentList.add(new Student("Tom", 405));
        studentList.add(new Student("Hari", 345));
        studentList.add(new Student("Yanni", 405));
        studentList.add(new Student("Tim", 345));
        studentList.add(new Student("Ria", 405));
        studentList.add(new Student("Uma", 345));
        studentList.add(new Student("Gary", 405));
        studentList.add(new Student("Polly", 345));
        studentList.add(new Student("Ravi", 405));
        studentList.addFirst(new Student("Inba",234));
        studentList.addLast(new Student("Lavanya", 432));
        System.out.println(studentList);
        Iterator<Student> itr = studentList.descendingIterator();
        while(itr.hasNext())
            System.out.println(itr.next());
        
 }   
}
