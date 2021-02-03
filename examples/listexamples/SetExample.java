import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student("Dave",123));
        set.add(new Student("Dave",123));

        System.out.println(set);
    }
}
