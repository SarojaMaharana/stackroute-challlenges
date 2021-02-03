import java.util.Scanner;

public class DayFinder {
    public void dayCalculator(int value){
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println("Its a "+days[value]);
    }
    public static void main(String[] args){
        DayFinder obj = new DayFinder();
        Scanner sc = new Scanner(System.in);

        int input = 0, currentDay = 0;
        

        // Taking inputs from the user
        System.out.println("Enter the current day of week(For Monday Enter 1, Tuesday, Enter 2 and so on):");
        currentDay = sc.nextInt();
        System.out.println("Enter the no. of days from today:");
        input = sc.nextInt();

        if(((input+currentDay)%7) <0){
            obj.dayCalculator(7+((currentDay+input-1)%7));
        }
        else{
            obj.dayCalculator(((currentDay+input-1)%7));
        }
    }
}