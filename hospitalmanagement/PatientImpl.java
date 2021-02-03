import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PatientImpl {
    Path path;
    String patientsFile;

    void patient() throws IOException {
        List<Patient> patientList = new ArrayList<>();
        
        String patientFileName = "patients_records.csv";
        FileWriter fileWriter = new FileWriter(patientFileName, true);
        
        Patient obj = new Patient(1212, "P1212", "Praveen", false, 25478.00);
        Patient obj2 = new Patient(1213, "P1213", "Naveen", false, 45848.00);
        patientList.add(obj);
        patientList.add(obj2);

        for(Patient p : patientList){
            fileWriter.append(p.toString()+System.lineSeparator());
        }
        fileWriter.close();

    }  // Get Details from Bank, generate other details, add in patient files

    void checkDoctorAssigned(){

    } // Get details of assigned doctor
    void payBill(){

    } // if cured pay Bill to Clinic through Bank and if available, insurance, remove from files.

    public static void main(String[] args) {
        PatientImpl i = new PatientImpl();
        try {
            i.patient();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
