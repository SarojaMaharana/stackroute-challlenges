import java.math.BigInteger;
import java.util.Scanner;

public class Banking {
    private static void display(SavingAccount[] sa){
        System.out.println("Account Number\tFirst Name\t\tLast Name\t\tDOB\t\tMobile Number\t\tCategory\t\tAccount Status");
        for(int i=0; i<sa.length;i++){
            System.out.println(sa[i].getAccountNumber()+"\t"+sa[i].getFirstName()+"\t\t"+sa[i].getLastName()+"\t\t"+sa[i].getDOB()+"\t\t"+(sa[i].getCountryCode()+sa[i].getMobileNumber())+"\t\t"+sa[i].getCategory()+"\t\t"+sa[i].getAccountStatus());
        }
    }

    private static void getBalance(BigInteger no, SavingAccount[] sa){
        boolean flag = false;
        for(int i=0; i<sa.length;i++){
            if(sa[i].getAccountNumber().equals(no)){
                System.out.println("Amount present in the account is: Rs."+sa[i].getBalance());
                flag = true;
            }
        }
        if(flag == false){
            System.out.println("Wrong Account Number");
        }
    }

    private static void depositMoney(long toDeposit, BigInteger no, SavingAccount[] sa){
        boolean flag = false;
        for(int i=0; i<sa.length;i++){
            if(sa[i].getAccountNumber().equals(no)){
                sa[i].setBalance(sa[i].getBalance() + toDeposit);
                System.out.println("Money Deposited");
                flag = true;
            }
        }
        if(flag == false){
            System.out.println("Please check the details");
        }
    }

    private static void withdrawMoney(long toWithdraw, BigInteger no, SavingAccount[] sa){
        boolean flag = false;
        for(int i=0; i<sa.length;i++){
            if(sa[i].getAccountNumber().equals(no)){
                if(sa[i].getBalance()>=toWithdraw){
                    sa[i].setBalance(sa[i].getBalance()-toWithdraw);
                    System.out.println("Money Withdrawn");
                    System.out.println("Amount Left: "+sa[i].getBalance());
                }
                else{
                    System.out.println("Sufficient amount is not there in the account");
                }
                flag = true;
            }
        }
        if(flag == false){
            System.out.println("Please check the details");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Customer custObj = new Customer();
        SavingAccount savingAccountObj = new SavingAccount();

        Customer[] customer = custObj.acceptCustomerDetails();
        SavingAccount[] accounts = savingAccountObj.createAccount(customer);
        // System.out.println(accounts);
        int option = 0;
        BigInteger accNo = new BigInteger("0");
        do{
            System.out.println("Press 1 to get the details");
            System.out.println("Press 2 to get the balance.");
            System.out.println("Press 3 to deposit.");
            System.out.println("Press 4 to withdraw");
            System.out.println("Press 5 to exit.");
            option = sc.nextInt();
            switch(option){
                case 1: display(accounts);
                        break;

                case 2: System.out.println("Enter the account number:");
                        accNo = sc.nextBigInteger();
                        getBalance(accNo, accounts);
                        break;

                case 3: System.out.println("Enter the account nuber:");
                        accNo = sc.nextBigInteger();
                        System.out.println("Enter how much money to deposit:");
                        long toDeposit = sc.nextLong();
                        depositMoney(toDeposit, accNo, accounts);
                        break;

                case 4: System.out.println("Enter the account nuber:");
                        accNo = sc.nextBigInteger();
                        System.out.println("Enter how much money to withdraw:");
                        long toWithdraw = sc.nextLong();
                        withdrawMoney(toWithdraw, accNo, accounts);
                        break;

                case 5: break;

                default: System.out.println("Wrong Choice");
            }
        }while(option != 5);

        sc.close();
    }
}