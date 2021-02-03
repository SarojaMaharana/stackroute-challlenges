public class TemperatureConvertFloat {
    public static void main(String[] args) {
        float tempInCel = 0f;
        float tempInFar = 0f;

        System.out.format("%s %25s %25s", "Sr. No", "Temperature(Celsius)", "Temperature(Fahrenheit)");
        System.out.println();
        for (int i = 1; i <= 101; i++) {
            tempInFar = tempInCel * 1.8f + 32;
            System.out.format("%d %25.2f %25.2f", i, tempInCel, tempInFar);
            System.out.println();
            tempInCel = tempInCel + 1;
        }
    }
}