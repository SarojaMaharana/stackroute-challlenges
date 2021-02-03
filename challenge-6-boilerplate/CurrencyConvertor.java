import java.util.Scanner;

class CurrencyConvertor{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String currency = "";
        float toConvert = 0f;
        System.out.println("Enter the source currency: (USD, GBP, JPY, EUR, AED)");
        currency = sc.next();
        System.out.println("Enter the amount:");
        toConvert = sc.nextFloat();

        switch(currency){
            case "USD": System.out.println("The exchange rate for" +toConvert+ "is: " +(toConvert*74.3));
                        break;
            case "GBP": System.out.println("The exchange rate for" +toConvert+ "is: " +(toConvert*94.5));
                        break;
            case "JPY": System.out.println("The exchange rate for" +toConvert+ "is: " +(toConvert*0.67));
                        break;
            case "EUR": System.out.println("The exchange rate for" +toConvert+ "is: " +(toConvert*85.37));
                        break;
            case "AED": System.out.println("The exchange rate for" +toConvert+ "is: " +(toConvert*20.25));
                        break;
            default: System.out.println("Wrong source currency");
        }
    }
}