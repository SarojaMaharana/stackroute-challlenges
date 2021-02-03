import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) throws ZeroNumberException {
        Scanner sc = new Scanner(System.in);
        CalculatorOperations operations = new CalculatorOperations();
        int option1=0, option2 = 0;
        Double number1, number2;
        do{
            System.out.println("Enter the operation you wish to perform :");
            System.out.println("1. Mathematical Calculation");
            System.out.println("2. Scientific Calculation");
            System.out.println("3. Exit");
            option1 = sc.nextInt();

            switch(option1){
                case 1: do{
                            System.out.println("1. Add");
                            System.out.println("2. Subtract");
                            System.out.println("3. Multiply");
                            System.out.println("4. Divide");
                            System.out.println("5. Modulo");
                            System.out.println("6. Back to Main Menu");
                            option2 = sc.nextInt();

                            switch(option2){
                                case 1: System.out.println("Enter the numbers a and b:");
                                        number1 = sc.nextDouble();
                                        number2 = sc.nextDouble();
                                        operations.add(number1, number2);
                                        break;

                                case 2: System.out.println("Enter the numbers a and b:");
                                        number1 = sc.nextDouble();
                                        number2 = sc.nextDouble();
                                        operations.subtract(number1, number2);
                                        break;

                                case 3: System.out.println("Enter the numbers a and b:");
                                        number1 = sc.nextDouble();
                                        number2 = sc.nextDouble();
                                        operations.multiply(number1, number2);
                                        break;

                                case 4: System.out.println("Enter the numbers a and b:");
                                        number1 = sc.nextDouble();
                                        number2 = sc.nextDouble();
                                        if(number2 == 0)
                                            throw(new ZeroNumberException());
                                        else
                                            operations.divide(number1, number2);
                                        break;

                                case 5: System.out.println("Enter the numbers a and b:");
                                        number1 = sc.nextDouble();
                                        number2 = sc.nextDouble();
                                        if(number2 == 0)
                                            throw(new ZeroNumberException());
                                        else
                                            operations.modulo(number1, number2);
                                        break;

                                case 6: break;

                                default: System.out.println("Wrong choice");
                            }
                        }while(option2!=6);
                        break;

                case 2: option2 = 0;
                        do{
                            System.out.println("1. Ceil");
                            System.out.println("2. Floor");
                            System.out.println("3. Square Root");
                            System.out.println("4. Power Of");
                            System.out.println("5. Back to Main Menu");
                            option2 = sc.nextInt();

                            switch(option2){
                                case 1: System.out.println("Enter a decimal number:");
                                        number1 = sc.nextDouble();
                                        if(number1 == 0)
                                            throw(new ZeroNumberException());
                                        else
                                            operations.getCeil(number1);
                                        break;

                                case 2: System.out.println("Enter a decimal number:");
                                        number1 = sc.nextDouble();
                                        if(number1 == 0)
                                            throw(new ZeroNumberException());
                                        else
                                            operations.getFloor(number1);
                                        break;

                                case 3: System.out.println("Enter a decimal number:");
                                        number1 = sc.nextDouble();
                                        if(number1 == 0)
                                            throw(new ZeroNumberException());
                                        else
                                            operations.getSquareRoot(number1);
                                        break;

                                case 4: System.out.println("Enter the base and exponent:");
                                        number1 = sc.nextDouble();
                                        number2 = sc.nextDouble();
                                        operations.getPowerOf(number1, number2);
                                        break;

                                case 5: break;

                                default: System.out.println("Wrong choice");
                            }
                        }while(option2!=5);
                        break;

                case 3: break;
                default: System.out.println("Wrong choice");
            }
        }while(option1 != 3);
        sc.close();
    }
}