import java.util.Scanner;

public class TravelSaversImpl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CalculateNewTax cnt = new CalculateNewTax(){

            @Override
            public double calculateNewTax(double investedMoney) {
                return ((investedMoney*74.3)/10);
            }
            
        };

        CalculateNewStockPrice cnst = new CalculateNewStockPrice(){

            @Override
            public double calculateNewStockPrice(double investedMoney, double sharePrice) {
                double percentage = (((investedMoney*74.3)-(investedMoney*40))/(investedMoney*40))*100;
                double newPrice = (sharePrice*percentage/100)+sharePrice;
                return newPrice;
            }
            
        };

        TotalProfit tp = new TotalProfit(){

            @Override
            public double totalProfit(double investedMoney) {
                return ((investedMoney*74.3)-(investedMoney*74.3)/10);
            }
            
        };

        ProfitInDollars pid = new ProfitInDollars(){

            @Override
            public double profitInDollars(double investedMoney) {
                return ((((investedMoney*74.3)-(investedMoney*74.3)/10))/74.3);
            }
            
        };

        System.out.println("Enter the amount invested by the company :");
        double investedMoney = sc.nextDouble();
        System.out.println("Enter the share price of the company : ");
        double sharePrice = sc.nextDouble();

        System.out.println("Investment amount after increase in exchange rate : "+(investedMoney*74.3));
        System.out.println("The new price of the stock : " +cnst.calculateNewStockPrice(investedMoney, sharePrice));
        System.out.println("The tax to be paid on the total shares at 10% : "+cnt.calculateNewTax(investedMoney));
        System.out.println("The total profit in INR : " +tp.totalProfit(investedMoney));
        System.out.println("The total profit converted to dollars : " +pid.profitInDollars(investedMoney));

        sc.close();
    }
}