import java.util.Scanner;

public class TravelSaversImpl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount invested by the company :");
        double investedMoney = sc.nextDouble();
        System.out.println("Enter the share price of the company : ");
        double sharePrice = sc.nextDouble();

        Currency oldim = (amount) -> amount*Currency.oldUSD;
        Currency newim = (amount) -> amount*Currency.newUSD;
        double oldInvestedMoney = oldim.exchangeRate(investedMoney);
        double newInvestedMoney = newim.exchangeRate(investedMoney);

        System.out.println("Investment amount after increase in exchange rate : "+newInvestedMoney);
        System.out.println("The new price of the stock : " +((sharePrice*(((newInvestedMoney-oldInvestedMoney)/oldInvestedMoney)*100)/100)+sharePrice));
        System.out.println("The tax to be paid on the total shares at 10% : "+newInvestedMoney/10);
        System.out.println("The total profit in INR : "+(newInvestedMoney-(newInvestedMoney/10)));
        System.out.println("The total profit converted to dollars : "+((((newInvestedMoney)-(newInvestedMoney)/10))/74.3));

        sc.close();
    }
}