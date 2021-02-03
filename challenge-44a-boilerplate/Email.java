import java.util.List;

public class Email implements EmailGenerator {

    @Override
    public void generateEmailAddress(List<Recruits> recruitList) {
        for(Recruits r:recruitList)
            r.setEmailId(makeEmailAddress(r));
    }

    public void display(List<Recruits> recruitList){
        for(Recruits r:recruitList){
            System.out.println("First Name: "+r.getFirstName());
            System.out.println("Last Name: "+r.getLastName());
            System.out.println("Department: "+r.getDepartmentName());
            System.out.println("Email ID: "+r.getEmailId());
            System.out.println("Mail box capacity: "+r.getBoxCapacity()+"GB");
            System.out.println("Password: "+r.getPassword());
            System.out.println();
        }
    }
    
}
