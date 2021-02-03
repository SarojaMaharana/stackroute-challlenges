#PROBLEM STATEMENT

##Mimicking some Database activities through JAVA.

Given below are five classes,

- Doctor
- Bank
- Insurance
- Patient
- Clinic

All of the five classes will have corresponding .csv files storing their details. Any empty value can be stored as 0.

NOTE:: Create one Clinic Account in Bank.

Given below are the attributes and methods of said Classes.

1) Doctor

   Attributes:
-  -personalID int
   -empID String
-  -doctorName String
-  -salary  double
-  -age  int
-  -presence boolean

   Methods:
- +checkIn() -> Doctor is present in Clinic.
- +checkOut() -> Doctor is not present in Clinic.
- +checkAssignedPatients() ->check patient details for assigned patients.

2) Bank

   Attributes:
-  -personalID int
-  -accountHolderName String
-  -accountNo String
-  -bankBalance double
-  -loanTaken boolean

   Methods:
-  +checkbalance() -> balance should not fall below 1000 
-  +Bank(personalID int, accountHolderName String) -> register Bank Account with personalID and Name, get other values from other files, add in file, using parameterzed Constructor;
-  +withdraw()  ->withdraw amount, bank Balance should not fall below 1000, update file
-  +deposit()  -> deposit money, update file.
-  +takeOutLoan() ->take out loan, not greater than 3.5 times than current balance
cannot take out loan until loan is paid.


3) Insurance

  Attributes:
- -personalID int
- -contractorNo String
- -contractorName String
- -age int
- -totalInsuranceValue double

   Methods:
- +Insurance( personalId int, contractorName Strng) register Insurance with personal ID and contractorName, and get other values from other files and register in file.
- +insuranceClaim() claim insurance, update the file.

4) Patient

   Attributes:
- -personalID int 
- -patientID  String
- -patientName String
- -patientCondition boolean
- -totalBill double

  Methods:
- +Patient()  // Get Details from Bank, generate other details, add in patient files
- +checkDoctorAssigned() // Get details of assigned doctor
- +payBill() // if cured pay Bill to Clinic through Bank and if available, insurance, remove from files.

5) Clinic
 
   Attributes:
-  -empID   String
-  -patientID String
-  -roomNo int
-  -treatmentCost double
-  -static final ClinicPersonalID

    Methods:
-   +registerPatient() //create new Patient object and assign room value
-   +assignDoctor() // if doctor present, assign doctor.
-   +treatPatient() // if patient registered and doctor present, set treatment cost and cure patient.
-   +patientCheckOut() // find Patient from files, make patient pay bill.
-   +paySalary()  // pay Doctor Salary from Clinic Account
      


  




