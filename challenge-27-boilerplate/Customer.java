import java.math.BigInteger;
import java.util.Scanner;

public class Customer {
    private BigInteger accountNumber;
    private String firstName;
    private String lastName;
    private String DOB;
    private String countryCode;
    private long mobileNumber;
    private String flatNo;
    private String streetName;
    private String cityName;
    private String talukName;
    private String stateName;
    private String country;
    private int pinCode;
    private BigInteger temp = new BigInteger ("1000000000000");

    public BigInteger getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(BigInteger accountNumber) {
        this.accountNumber = accountNumber;
    }

    private BigInteger calculateAcc(){
        temp = temp.add(BigInteger.ONE);
        return temp;
    }

    public String getfirstName() {
        return firstName;
    }

    private void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getcountryCode() {
        return countryCode;
    }

    private void setcountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    private void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFlatNo() {
        return flatNo;
    }

    private void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getStreetName() {
        return streetName;
    }

    private void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    private void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTalukName() {
        return talukName;
    }

    private void setTalukName(String talukName) {
        this.talukName = talukName;
    }

    public String getStateName() {
        return stateName;
    }

    private void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getPinCode() {
        return pinCode;
    }

    private void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getCountry() {
        return country;
    }

    private void setCountry(String country) {
        this.country = country;
    }

    public String getDOB() {
        return DOB;
    }

    private void setDOB(String dOB) {
        DOB = dOB;
    }

    private boolean validateMobileNumber(long number){
        int count = 0;
        while(number != 0){
            number/= 10;
            count++;
        }
        if(count == 10)
            return true;
        else
            return false;
    }

    public Customer[] acceptCustomerDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of customers: ");
        int noOfCustomers = sc.nextInt();
        Customer[] customerList = new Customer[noOfCustomers];

        for(int i=0;i<noOfCustomers;i++){
            customerList[i] = new Customer();

            customerList[i].accountNumber = calculateAcc();
            System.out.println("Enter the first name of the customer: ");
            customerList[i].setfirstName(sc.next());
            System.out.println("Enter the last name of the customer: ");
            customerList[i].setLastName(sc.next());
            System.out.println("Enter the Date of Birth in the order of yyy-mm-dd");
            customerList[i].setDOB(sc.next());
            System.out.println("Enter the country code:");
            customerList[i].setcountryCode(sc.next());
            System.out.println("Enter the mobile number:");
            customerList[i].setMobileNumber(sc.nextLong());
            boolean flag = true;
            while(flag){
                boolean temp = validateMobileNumber(customerList[i].getMobileNumber());

                if(temp == true){
                    flag = false;
                }
                else{
                    System.out.println("Enter the correct mobile number: ");
                    customerList[i].setMobileNumber(sc.nextLong());
                }
            }
            System.out.println("Enter the flat no.: ");
            customerList[i].setFlatNo(sc.next());
            System.out.println("Enter the street name:");
            customerList[i].setStreetName(sc.next());
            System.out.println("Enter the taluk name:");
            customerList[i].setTalukName(sc.next());
            System.out.println("Enter the name of the city:");
            customerList[i].setCityName(sc.next());
            System.out.println("Enter the name of the state:");
            customerList[i].setStateName(sc.next());
            System.out.println("Enter the name of the country:");
            customerList[i].setCountry(sc.next());
            System.out.println("Enter the pin code:");
            customerList[i].setPinCode(sc.nextInt());
        }
        
        // sc.close();
        return customerList;
    }

    
 
}
