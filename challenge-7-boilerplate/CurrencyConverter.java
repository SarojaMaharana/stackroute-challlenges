import java.util.Scanner;

class CurrencyConverter{
    public static float otherToINR(float value, String desired){
        float toReturn = 0f;
        switch(desired){
            case "USD": toReturn = (value/74.3f);
                        break;
            case "GBP": toReturn = (value/94.5f);
                        break;
            case "JPY": toReturn = (value/0.67f);
                        break;
            case "EUR": toReturn = (value/85.37f);
                        break;
            case "AED": toReturn = (value/20.25f);
                        break;
            default: System.out.println("Wrong source currency");
        }
        return toReturn;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] notes = {1, 10, 20, 50, 100};

        System.out.format("%20s %10s %10s %10s %10s %10s", "Denominations (INR)", "USD", "GBP", "JPY", "EUR", "AED");
        System.out.println("");
        for(int i=0;i<5;i++){
            System.out.format("%20d %10.2f %10.2f %10.2f %10.2f %10.2f", notes[i]*1, notes[i]*74.3, notes[i]*94.5, notes[i]*0.67, notes[i]*85.37, notes[i]*20.25);
            System.out.println("");
        }
        String soruceCurrency = "";
        String desiredCurrency = "";
        float toConvert = 0f;
        float temp = 0f;
        System.out.println("Enter the source currency: (INR, USD, GBP, JPY, EUR, AED)");
        soruceCurrency = sc.next();
        System.out.println("Enter the desired currency: (INR, USD, GBP, JPY, EUR, AED)");
        desiredCurrency = sc.next();
        toConvert = sc.nextFloat();

        if(soruceCurrency != "INR"){
            temp = toConvert;
        }
        else {
            temp = otherToINR(toConvert, soruceCurrency);
        }
        switch(desiredCurrency){
            case "INR": System.out.println("The exchange rate for" +toConvert+ "is: " +(temp*1));
                        break;
            case "USD": System.out.println("The exchange rate for" +toConvert+ "is: " +(temp*74.3));
                        break;
            case "GBP": System.out.println("The exchange rate for" +toConvert+ "is: " +(temp*94.5));
                        break;
            case "JPY": System.out.println("The exchange rate for" +toConvert+ "is: " +(temp*0.67));
                        break;
            case "EUR": System.out.println("The exchange rate for" +toConvert+ "is: " +(temp*85.37));
                        break;
            case "AED": System.out.println("The exchange rate for" +toConvert+ "is: " +(temp*20.25));
                        break;
            default: System.out.println("Wrong desired currency");
        }
        sc.close();
    }
}