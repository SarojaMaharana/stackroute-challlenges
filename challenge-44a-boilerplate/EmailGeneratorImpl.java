import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmailGeneratorImpl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmailGenerator emailGenerator = new Email();
        List<Recruits> recruitList = new ArrayList<>();

        char choice = 'y';
        do{
            System.out.println("Enter the first name: ");
            String firstName = sc.next();
            System.out.println("Enter the last name: ");
            String lastName = sc.next();
            System.out.println("Enter the department: ");
            String departmentName = sc.next();
            Recruits r = new Recruits(firstName, lastName, departmentName);
            recruitList.add(r);
            System.out.println("Do you still want to add the recruits: (y/n)");
            choice = sc.next().charAt(0);
        }while(choice == 'y');
        emailGenerator.generateEmailAddress(recruitList);
        emailGenerator.passwordGenerator(recruitList);
        System.out.println();
        emailGenerator.display(recruitList);
        sc.close();
    }
}