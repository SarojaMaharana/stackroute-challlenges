package com.stackroute.streams;

import java.util.List;

public class StringFormat {
    String toReturn = "";

    //write logic to find the format for given list and return result
    public String findStringFormat(List<Integer> input) {
        if(input.isEmpty())
            return "Give proper input not empty list";

        long negativeCount = input.stream().filter(i -> i<0).toArray().length;
        if(negativeCount > 0)
            return "Give proper input not negative values";

        // String toReturn = "";
        input.stream().forEach(i -> {
            if(i%2 == 0)
                toReturn = toReturn+"even"+Integer.toString(i)+",";
            else
                toReturn = toReturn+"odd"+Integer.toString(i)+",";
        });
        return toReturn.substring(0, toReturn.length()-1);
    }
}
