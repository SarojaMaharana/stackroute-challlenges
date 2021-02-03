import java.util.Scanner;

public class printCalendar{
    public int findMaximumDays(String mname, int year){
        int max = 0;
        String[] months = {"January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] noOfDays = {31,28,31,30,31,30,31,31,30,31,30,31};

        if((year%400 == 0) || ((year%100!=0)&&(year%4==0))){
            noOfDays[1] = 29;
        }
        for(int i=0;i<12;i++){
            if(mname == months[i]){
                max = noOfDays[i];
            }
        }
        return max;
    }
    public void fillCalendar(int max, int day, String mname, int year){
        int calendar[][] = new int[6][7];
        int temp = 1;

        for(int i=0;i<6;i++){
            for(int j = day; j<7;j++){
                if(temp <= max){
                    calendar[i][j] = temp;
                    temp++;
                }
            }
            day = 0;
        }
        toPrint(calendar);
    }
    public void toPrint(int arr[][]){
        System.out.println("\t\tCalendar");
        System.out.println("S\tM\tTu\tW\tTh\tF\tS");

        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                if(arr[i][j] != 0)
                    System.out.print(arr[i][j]+ "\t");
                else
                    System.out.print("\t");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        printCalendar obj = new printCalendar();

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] months = {"January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        System.out.println("Enter month(Press 1 for Jan, 2 for Feb, 12 for Dec......): ");
        int monthName = sc.nextInt();
        System.out.println("Enter Year:");
        int yearName = sc.nextInt();
        System.out.println("Enter Day of week(Press 1 for Mon, 2 for Tue, 7 for Sun......):");
        int dayName = sc.nextInt();

        int maxNoDays = obj.findMaximumDays(months[monthName-1], yearName);
        obj.fillCalendar(maxNoDays, dayName, months[monthName], yearName);

        sc.close();
    }
}