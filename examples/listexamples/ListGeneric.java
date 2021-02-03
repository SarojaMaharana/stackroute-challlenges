import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListGeneric {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        
        studentList.add(new Student("Raj",345));
        studentList.add(new Student("Tina",405));
        studentList.add(new Student("Sam",345));
        studentList.add(new Student("Tom",405));
        studentList.add(new Student("Hari",345));
        studentList.add(new Student("Yanni",405));
        studentList.add(new Student("Tim",345));
        studentList.add(new Student("Ria",405));
        studentList.add(new Student("Uma",345));
        studentList.add(new Student("Gary",405));
        studentList.add(new Student("Polly",345));
        studentList.add(new Student("Ravi",405));

        //for loop, enchanced for loop
        for(Student s: studentList)
            System.out.print(s.getStudentName()+" ");
        System.out.println();
        // List -> forward/backward
        Iterator<Student> itr = studentList.iterator();
        while(itr.hasNext())
             System.out.print(itr.next().studentName+" ");
        System.out.println();
        //backward
        //Iterator<Student> itrb = studentList.desce();

        //ListIterator -> forward and backward for both ArrayList and LinkedList
        System.out.println("Forward Traversal");
        ListIterator<Student> listItr = studentList.listIterator();
        while(listItr.hasNext())
            System.out.print(listItr.next().studentName+" ");
        System.out.println();

        System.out.println("Reverse Traversal");
        while(listItr.hasPrevious())
            System.out.print(listItr.previous().studentName+" ");
        
        System.out.println();


    }
}
