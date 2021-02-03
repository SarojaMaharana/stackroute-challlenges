package com.stackroute.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FindDay {

    //write logic to find day of the date and return result
    public String findDay(int month, int day, int year) {
        if(month == 0 && day == 0 && year == 0)
            return "Give month in rangeGive day in rangeGive year in range";
        if(month == 0 && day == 0)
            return "Give month in rangeGive day in range";
        if(month == 0 && year == 0)
            return "Give month in rangeGive year in range";
        if(day == 0 && year == 0)
            return "Give day in rangeGive year in range";
        if(month < 1 || month > 12)
            return "Give month in range";
        if(day < 1 || day > 31)
            return "Give day in range";
        if(year < 2000 || year > 3000)
            return "Give year in range";
        // String givenDate = String.valueOf(month+100).substring(1)+" "+String.valueOf(day+100).substring(1)+" "+String.valueOf(year);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM d uuuu");
        LocalDate givenDate = LocalDate.parse(String.valueOf(month+100).substring(1)+" "+String.valueOf(day+100).substring(1)+" "+String.valueOf(year), dateFormatter);
        return givenDate.getDayOfWeek().toString();
    }
}
