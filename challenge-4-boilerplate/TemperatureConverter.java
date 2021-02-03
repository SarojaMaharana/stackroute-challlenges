import java.util.Scanner;

public class TemperatureConverter {
    // Conversion method
    public static float celsiusToFahrenheit(float temperature) {
        return (temperature * 1.8f + 32);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float temp = 0f;
        char choice = ' ';
        do {
            System.out.println("Enter the temperature in Degree Celsius:");
            temp = sc.nextFloat();
            System.out.println(
                    "Temperature(Celsius)= " + temp + "\tTemperature(Fahrenheit)= " + celsiusToFahrenheit(temp));
            System.out.println("Do you wish to continue(y/n)?");
            choice = sc.next().charAt(0);
        } while (choice != 'n');
    }
}