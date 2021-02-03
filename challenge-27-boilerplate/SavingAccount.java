import java.math.BigInteger;

public class SavingAccount {
    private BigInteger accountNumber;
    private String firstName;
    private String lastName;
    private String DOB;
    private String countryCode;
    private long mobileNumber;
    private String flatNo;
    private String streetName;
    private String talukName;
    private String cityName;
    private String stateName;
    private String country;
    private int pinCode;
    private String category;
    private float rateOfInterest;
    private String accountStatus;
    private String lastAccess;
    private long balance = 0;

    public BigInteger getAccountNumber() {
        return accountNumber;
    }

    private void setAccountNumber(BigInteger accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDOB() {
        return DOB;
    }

    private void setDOB(String dOB) {
        DOB = dOB;
    }

    public String getCountryCode() {
        return countryCode;
    }

    private void setCountryCode(String countryCode) {
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

    public String getTalukName() {
        return talukName;
    }

    private void setTalukName(String talukName) {
        this.talukName = talukName;
    }

    public String getCityName() {
        return cityName;
    }

    private void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    private void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountry() {
        return country;
    }

    private void setCountry(String country) {
        this.country = country;
    }

    public int getPinCode() {
        return pinCode;
    }

    private void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getCategory() {
        return category;
    }

    private void setCategory(String category) {
        this.category = category;
    }

    public float getRateOfInterest() {
        return rateOfInterest;
    }

    private void setRateOfInterest(float rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    private void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getLastAccess() {
        return lastAccess;
    }

    private void setLastAccess(String lastAccess) {
        this.lastAccess = lastAccess;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    private String categoryFinder(String value){
        String currentDate = (java.time.LocalDate.now()).toString();
        String[] splitCurrentDate = currentDate.split("-");
        String[] splitValue = value.split("-");
        int diff = Integer.parseInt(splitCurrentDate[0]) - Integer.parseInt(splitValue[0]);
        if(diff<18)
            return "Minor";
        else if(diff>=18 && diff<60)
            return "Major";
        else
            return "Senior Citizen";
    }

    public SavingAccount[] createAccount(Customer[] arr){
        int size = arr.length;
        SavingAccount[] accountDetails = new SavingAccount[size];

        for(int i=0;i<size;i++){
            accountDetails[i] = new SavingAccount();

            accountDetails[i].setAccountNumber(arr[i].getAccountNumber());
            accountDetails[i].setFirstName(arr[i].getfirstName());
            accountDetails[i].setLastName(arr[i].getLastName());
            accountDetails[i].setDOB(arr[i].getDOB());
            accountDetails[i].setCountryCode(arr[i].getcountryCode());
            accountDetails[i].setMobileNumber(arr[i].getMobileNumber());
            accountDetails[i].setFlatNo(arr[i].getFlatNo());
            accountDetails[i].setStreetName(arr[i].getStreetName());
            accountDetails[i].setCityName(arr[i].getCityName());;
            accountDetails[i].setTalukName(arr[i].getTalukName());
            accountDetails[i].setStateName(arr[i].getStateName());
            accountDetails[i].setCountry(arr[i].getCountry());;
            accountDetails[i].setPinCode(arr[i].getPinCode());
            accountDetails[i].setCategory(categoryFinder(accountDetails[i].getDOB()));
            accountDetails[i].setRateOfInterest(3.8f);
            accountDetails[i].setLastAccess((java.time.LocalDate.now()).toString());
            accountDetails[i].setAccountStatus("Active");
        }

        return accountDetails;
    }
    
}
