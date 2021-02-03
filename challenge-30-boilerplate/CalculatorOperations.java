public class CalculatorOperations {
    public void add(Double num1, Double num2){
        System.out.println("The sum of "+num1+" and "+num2+" is " +(num1+num2));
    }

    public void subtract(Double num1, Double num2){
        System.out.println("The difference between "+num1+" and "+num2+" is " +(num1-num2));
    }

    public void multiply(Double num1, Double num2){
        System.out.println("The product of "+num1+" and "+num2+" is " +(num1*num2));
    }

    public void divide(Double num1, Double num2){
        System.out.println("The division of "+num1+" and "+num2+" is " +(num1/num2));
    }

    public void modulo(Double num1, Double num2){
        System.out.println("The modulo of "+num1+" and "+num2+" is " +(num1%num2));
    }

    public void getCeil(Double num1){
        System.out.println("The ceil of "+num1+" is " +Math.ceil(num1));
    }

    public void getFloor(Double num1){
        System.out.println("The floor of "+num1+" is " +Math.floor(num1));
    }

    public void getSquareRoot(Double num1){
        System.out.println("The square root of "+num1+" is " +Math.sqrt(num1));
    }

    public void getPowerOf(Double base, Double exponent){
        System.out.println("The value of "+base+" to the power of "+exponent+" is " +Math.pow(base, exponent));
    }
}
