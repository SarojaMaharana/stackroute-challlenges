package com.stackroute.optional;


import java.util.Optional;

public class OptionalDemo {

    public String concatenateString(String inputOne, String inputTwo) {
        /* When inputTwo is null, then concatenate with defaultString */
        final String defaultString = "Bangalore";
        String stringOne;
        String stringTwo;

        /* Optional.ofNullable - allows passed parameter to be null.*/
        Optional<String> optionalValueOne = Optional.ofNullable(inputOne);
        Optional<String> optionalValueTwo = Optional.ofNullable(inputTwo);

        /* check if optionalValueOne is present, then implement logic to concat strings and return the output string */
        if(optionalValueOne.isPresent()){
        /* gets the value of optionalValueOne */
            stringOne = optionalValueOne.get();

        /* returns the value optionalValueTwo if present otherwise returns the "defaultString" */
            if(optionalValueTwo.isPresent()){
                stringTwo = optionalValueTwo.get();
                return stringOne+stringTwo;
            }
            else
                stringTwo = defaultString;
                return stringOne+stringTwo;
        }

        /* else return string message, if optionalValueOne is not present */

        return "Cannot concatenate with null string";
    }
}
