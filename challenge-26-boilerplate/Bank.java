import java.util.Scanner;

public class Bank {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Customer custObj = new Customer();
        CustomerAnalyzer analyzer = new CustomerAnalyzer();
        Customer[] customer = custObj.acceptCustomerDetails();

        System.out.println();
        System.out.println("Enter the last name of the customer whose details are needed:");
        String lName = sc.next();
        analyzer.searchByLastName(lName, customer);

        System.out.println();
        System.out.println("Enter the village name of the customer whose details are needed:");
        String vName = sc.next();
        analyzer.searchByVillageName(vName, customer);

        sc.close();
    }
}