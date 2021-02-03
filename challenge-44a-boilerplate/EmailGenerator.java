import java.util.List;

public interface EmailGenerator {
    int defaultPwdLength = 8;

    void generateEmailAddress(List<Recruits> recruitList);

    default String makeEmailAddress(Recruits r){
        String toReturn = r.getFirstName().toLowerCase()+r.getLastName().toLowerCase()+"@"+r.getDepartmentName().toLowerCase()+"toycrates.com";
        return toReturn;
    }

    void display(List<Recruits> recruitList);

    default void passwordGenerator(List<Recruits> recruitList){
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789"+ "abcdefghijklmnopqrstuvxyz";
        for(Recruits r:recruitList){
            StringBuilder sb = new StringBuilder(defaultPwdLength);

            for(int i=0;i<defaultPwdLength;i++){
                int index = (int)(alphaNumericString.length()*Math.random());
                sb.append(alphaNumericString.charAt(index));
            }
            r.setPassword(sb.toString());
        }
    }
}
