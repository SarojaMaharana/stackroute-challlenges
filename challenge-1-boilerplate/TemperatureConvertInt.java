public class TemperatureConvertInt {
    public static void main(String[] args) {
        int tempInCel = 0;

        System.out.format("%s %25s %25s", "Sr. No", "Temperature(Celsius)", "Temperature(Fahrenheit)");
        System.out.println();
        System.out.format("%d %25d %25d", 1, tempInCel, (int) Math.round(tempInCel * 1.8 + 32));
        System.out.println();
        tempInCel = tempInCel + 10;
        System.out.format("%d %25d %25d", 2, tempInCel, (int) Math.round(tempInCel * 1.8 + 32));
        System.out.println();
        tempInCel = tempInCel + 10;
        System.out.format("%d %25d %25d", 3, tempInCel, (int) Math.round(tempInCel * 1.8 + 32));
        System.out.println();
        tempInCel = tempInCel + 10;
        System.out.format("%d %25d %25d", 4, tempInCel, (int) Math.round(tempInCel * 1.8 + 32));
        System.out.println();
        tempInCel = tempInCel + 10;
        System.out.format("%d %25d %25d", 5, tempInCel, (int) Math.round(tempInCel * 1.8 + 32));
        System.out.println();
        tempInCel = tempInCel + 10;
        System.out.format("%d %25d %25d", 6, tempInCel, (int) Math.round(tempInCel * 1.8 + 32));
        System.out.println();
        tempInCel = tempInCel + 10;
        System.out.format("%d %25d %25d", 7, tempInCel, (int) Math.round(tempInCel * 1.8 + 32));
        System.out.println();
        tempInCel = tempInCel + 10;
        System.out.format("%d %25d %25d", 8, tempInCel, (int) Math.round(tempInCel * 1.8 + 32));
        System.out.println();
        tempInCel = tempInCel + 10;
        System.out.format("%d %25d %25d", 9, tempInCel, (int) Math.round(tempInCel * 1.8 + 32));
        System.out.println();
        tempInCel = tempInCel + 10;
        System.out.format("%d %24d %25d", 10, tempInCel, (int) Math.round(tempInCel * 1.8 + 32));
        System.out.println();
        tempInCel = tempInCel + 10;
        System.out.format("%d %24d %25d", 11, tempInCel, (int) Math.round(tempInCel * 1.8 + 32));
    }
}
