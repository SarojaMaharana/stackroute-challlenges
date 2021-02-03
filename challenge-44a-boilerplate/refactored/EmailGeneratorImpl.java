import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmailGeneratorImpl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Recruits> recruitList = new ArrayList<>();
        int passwdLength = 8;

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
            System.out.println();
        }while(choice == 'y');

        System.out.println();

        EmailGenerator eg = (recruit) ->recruit.getFirstName().toLowerCase()+recruit.getLastName().toLowerCase()+"@"+recruit.getDepartmentName().toLowerCase()+"toycrates.com";
        PasswordGenerator pg = () ->{
            String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789"+ "abcdefghijklmnopqrstuvxyz";
            StringBuilder sb = new StringBuilder(passwdLength);
            for(int i=0;i<passwdLength;i++){
                int index = (int)(alphaNumericString.length()*Math.random());
                sb.append(alphaNumericString.charAt(index));
            }
            return sb.toString();
        };

        for(Recruits r:recruitList){
            r.setEmailId(eg.emailGenerator(r));
            r.setPassword(pg.passwordGenerator());

            System.out.println("First Name: "+r.getFirstName());
            System.out.println("Last Name: "+r.getLastName());
            System.out.println("Department: "+r.getDepartmentName());
            System.out.println("Email ID: "+r.getEmailId());
            System.out.println("Mail box capacity: "+r.getBoxCapacity()+"GB");
            System.out.println("Password: "+r.getPassword());
            System.out.println();
        }

        sc.close();
    }
}