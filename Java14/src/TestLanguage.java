import java.util.Scanner;

public class TestLanguage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the country: ");
        String countryName = sc.next();
        String language;

        language = switch(countryName){
            case "INDIA":   yield "Hindi";
            case "USA", "NIGERIA":     yield "English";
            default:        yield "Wrong optpion";
        };
        System.out.println("Language: "+language);
    }
}
