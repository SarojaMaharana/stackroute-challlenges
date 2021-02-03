public class CurrencyConversion {
    
    private static float otherToINR(float value, String desired){
        float toReturn = 0f;
        switch(desired){
            case "USD": toReturn = (value*74.3f);
                        break;
            case "GBP": toReturn = (value*94.5f);
                        break;
            case "JPY": toReturn = (value*0.67f);
                        break;
            case "EUR": toReturn = (value*85.37f);
                        break;
            case "AED": toReturn = (value*20.25f);
                        break;
            default: System.out.println("Wrong source currency");
        }
        return toReturn;
    }

    public static String calculateCurrency(String str1, String str2){
        String currency1 = str1.substring(0, 3);
        String currency2 = str2.substring(0, 3);
        int money1 = Integer.parseInt(str1.substring(3));
        int money2 = Integer.parseInt(str2.substring(3));
        float total = 0f;
        if(currency1.compareTo(currency2) == 0)
            total = money1 + money2;
        else{
            String soruceCurrency = currency2;
            String desiredCurrency = currency1;
            float toConvert = money2;
            float temp = 0f;
            if(soruceCurrency == "INR"){
                temp = toConvert;
            }    
            else {
                temp = otherToINR(toConvert, soruceCurrency);
            }
            switch(desiredCurrency){
                case "INR": total = money1 + temp;
                            break;
                case "USD": total = money1 + (temp/74.3f);
                            break;
                case "GBP": total = money1 + (temp/94.5f);
                            break;
                case "JPY": total = money1 + (temp/0.67f);
                            break;
                case "EUR": total = money1 + (temp/85.37f);
                            break;
                case "AED": total = money1 + (temp/20.25f);
                            break;
                default: System.out.println("Wrong desired currency");
            }    
        }
        String toReturn = currency1 + Integer.toString((int) total);
        return toReturn;
    }
}
