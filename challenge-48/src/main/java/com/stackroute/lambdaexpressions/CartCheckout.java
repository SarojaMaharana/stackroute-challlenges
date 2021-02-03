package com.stackroute.lambdaexpressions;


import java.math.BigDecimal;
import java.util.Map;

public class CartCheckout {
    private static BigDecimal sum = new BigDecimal(0);
    //write here logic to add a Map values include tax using lambda expression
    public String billGenerator(Map<String, BigDecimal> cart, Double taxPercent) {
        if(taxPercent == null)
            return "The taxPercent cannot be null";
        
        else if(cart == null)
            return "The cart Map cannot be null";

        else if(cart.isEmpty())
            return "The cart Map is empty";    

        else if(taxPercent < 0)
            return "The taxPercent cannot be negative";

        else if(cart.containsKey(null) || cart.containsKey("") || cart.containsKey(" "))
            return "The cart Map has null or empty or blank space as a value";

        cart.forEach((k, v) -> {sum = sum.add(v);});

        Double toReturn = (sum.doubleValue()+(sum.doubleValue()*(taxPercent/100)));

        return toReturn.toString();
    }
}
