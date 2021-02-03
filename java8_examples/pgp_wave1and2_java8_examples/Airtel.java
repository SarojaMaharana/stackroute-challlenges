public class Airtel implements SMSSender {

    @Override
    public void establishConnection() {
      System.out.println("Establist connection with airtel tower");

    }

    @Override
    public void disconnectFromTower() {
        System.out.println("disconnected from airtel tower");
    }
   
   
}
