import java.util.List;

public interface SMSSender
{
    void establishConnection(); //Airtel -> connect to towers Airtel
    default void sendSMS(List<User> userList, String sms)
    {
        for(User user:userList)
        {
            if(user.isDndEnabled())
            {
                System.out.println("in dnd");
                
            }
            else
                user.setSms(sms);
        }
    }

    void disconnectFromTower();
}
