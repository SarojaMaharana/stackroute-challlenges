import java.util.Date;
import enums.TransactionType;

public class Bank 
{
    //class members
    private int personalID;
    private String accountHolderName;
    private String accountNo;
    private double bankBalance;
    private boolean loanTaken;
    private Transaction[] transactions=new Transaction[100];

    //default constructor
    public Bank() 
    {}

    //parameterized constructor
    public Bank(int personalID, String accountHolderName) 
    {
        this.personalID = personalID;
        this.accountHolderName = accountHolderName;
        this.accountNo=generateAccountNumber();
    }

    public Bank(int personalID, String accountHolderName, double bankBalance) {
        this.personalID = personalID;
        this.accountHolderName = accountHolderName;
        this.bankBalance = bankBalance;
    }

    //settes and getters
    public int getPersonalID() {
        return personalID;
    }

    public void setPersonalID(int personalID) {
        this.personalID = personalID;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo() {
        this.accountNo = generateAccountNumber();
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public boolean isLoanTaken() {
        return loanTaken;
    }

    public void setLoanTaken(boolean loanTaken) {
        this.loanTaken = loanTaken;
    }

    @Override
    public String toString() {
        return "Bank [accountHolderName=" + accountHolderName + ", accountNo=" + accountNo + ", bankBalance="
                + bankBalance + ", loanTaken=" + loanTaken + ", personalID=" + personalID + "]";
    }

    public String generateAccountNumber() 
    {
        String NumericString = "0123456789";
        int n=13;
        StringBuilder sb = new StringBuilder(n); 
      
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index = (int)(NumericString.length() * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(NumericString.charAt(index)); 
        } 
  
        return sb.toString();
    }

    Transaction txn=new Transaction();
    //method to deposit the amount
    public boolean deposit(double amount) 
    {
        bankBalance = bankBalance+amount;
        Transaction transaction = new Transaction(txn.generateTransactionId(), new Date(), amount, TransactionType.DEPOSIT);
        for (int i=0;i<transactions.length;i++) 
        {
            if(transactions[i]==null) 
            {
                transactions[i] = transaction;
                break;
            }
        }
        return true;
    }

    //method to withdraw the amount
    public boolean withdraw(double amount) 
    {
        if(amount<bankBalance) 
        {
            bankBalance = bankBalance-amount;
            Transaction transaction = new Transaction(txn.generateTransactionId(), new Date(), amount, TransactionType.WITHDRAWAL);
            for (int i=0;i<transactions.length;i++) 
            {
                if(transactions[i]==null) 
                {
                    transactions[i] = transaction;
                    break;
                }
            }
            return true;
        }
            System.out.println("Invalid Transaction!!! Trying to withdraw more than available balance");
            return false;
    }

    public void takeOutLoan(double loanRequest)
    {   
        double loanGrantAmount=bankBalance*3.5;
        if(loanRequest>loanGrantAmount)
        {
            System.out.println("Loan cannot be granted as loan request at this moment");
        }
        else
        {
            Transaction transaction = new Transaction(txn.generateTransactionId(), new Date(), loanRequest, TransactionType.REQUEST_LOAN);
            for (int i=0;i<transactions.length;i++) 
            {
                if(transactions[i]==null) 
                {
                    transactions[i] = transaction;
                    break;
                }
            }
        }

    }
    
    public void checkBalance()
    {
        System.out.println("Your current balance is: INR "+getBankBalance());

        if(getBankBalance()<1000)
        {
            System.out.println("Your account balance is below INR 1000, Please update the balance.");
        }
    }

    public static void main(String[] args) 
    {
        //Bank bank=new Bank();

        Bank customer=new Bank(123456,"Abhishek");
        String acc=customer.getAccountNo();
        System.out.println(acc+","+customer.getPersonalID()+","+customer.getAccountHolderName());
        customer.deposit(15000);
        customer.withdraw(14700);
        customer.checkBalance();        
    }

   
    
}
