import java.util.Arrays;
import java.util.List;

public class SMSSenderImpl {

    public static void main(String[] args) {
        SMSSender smssender = new Airtel();
        List<User> userlist = Arrays.asList(new User(1234,"Raj",true,true),
        new User(3456,"Tom",true,false),
        new User(5678,"Sam",true,false));

        //1. connection
        smssender.establishConnection();
        smssender.sendSMS(userlist, "promo on shopping");
        smssender.disconnectFromTower();
        System.out.println("The sms list of the users ");
        for(User u:userlist)
        {
            System.out.println(u.getSms());
        }
    }
}
