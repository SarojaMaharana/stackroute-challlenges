import java.util.Scanner;

public class TemperatureConverter {
    // celsius to fahrenheit
    public static float celsiusToFahrenheit(float temperature) {
        return (temperature * 1.8f + 32);
    }

    // fahrenheit to celcius
    public static float fahrenheitToCelsius(float temperature) {
        return ((temperature - 32) / 1.8f);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float temp = 0f;
        char units = ' ';
        char choice = ' ';

        do {
            System.out.println("Enter the temperature:");
            temp = sc.nextFloat();
            System.out.println("Enter the source scale(celcius(c)/fahrenheit(f))?");
            units = sc.next().charAt(0);
            switch (units) {
                case 'c':
                    System.out.println("Temperature(Celsius)= " + temp + "\tTemperature(Fahrenheit)= "
                            + celsiusToFahrenheit(temp));
                    break;
                case 'f':
                    System.out.println("Temperature(Celsius)= " + fahrenheitToCelsius(temp)
                            + "\tTemperature(Fahrenheit)= " + temp);
                    break;
                default:
                    System.out.println("Invalid source scale");
            }
            System.out.println("Do you wish to continue(y/n)?");
            choice = sc.next().charAt(0);
        } while (choice != 'n');
    }
}