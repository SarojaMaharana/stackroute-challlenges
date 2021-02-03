package com.stackroute.methodreference;

public class FindResult {
    //write logic to find multiplication result of given numbers
    // Use static method multiply of StaticMethodReference class
    public int findResult(int number1, int number2) {
      int toReturn = operations(StaticMethodReference::multiply, number1, number2);
      return toReturn;
    }

    static int operations(IntFunctionality inf, int num1, int num2) {
      return inf.intFunctionality(num1, num2);
    }
}
