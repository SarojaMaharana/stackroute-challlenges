import java.util.Scanner;

public class AGSchool {
    public int getNoOfStars(float avgMarks){
        int count = 0;

        if(avgMarks<=100 && avgMarks>90)
            count = 10;
        else if(avgMarks<=90 && avgMarks>80)
            count = 9;
        else if(avgMarks<=80 && avgMarks>70)
            count = 8;
        else if(avgMarks<=70 && avgMarks>60)
            count = 7;
        else if(avgMarks<=60 && avgMarks>50)
            count = 6;
        else if(avgMarks<=50 && avgMarks>40)
            count = 5;
        else if(avgMarks<=40 && avgMarks>30)
            count = 4;
        else if(avgMarks<=30 && avgMarks>20)
            count = 3;
        else if(avgMarks<=15 && avgMarks>10)
            count = 2;
        else if(avgMarks<=80 && avgMarks>70)
            count = 1;
        else
            count = 0;
        
        return count;
    }

    public void transposeMatrix(String[][] arr, int row, int col){
        // String[][] transposeArr = new String[col][row];
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                if(arr[j][i] == "null")
                    System.out.print("\t");
                else
                    System.out.print(arr[j][i]+ "\t");
                // transposeArr [i][j] = arr[j][i];
            }
            System.out.println();
        }
    }

    public float calculateAvg(float arr[]){
        float temp = 0f;
        for(int i=0;i<arr.length;i++){
            temp = temp + arr[i];
        }
        return temp/arr.length;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        AGSchool obj = new AGSchool();

        System.out.println("Enter the number of students:");
        int noOfStudents = sc.nextInt();
        int[] rollNo = new int[noOfStudents];
        String[] name = new String[noOfStudents];
        float[] mathMarks = new float[noOfStudents];
        float[] scienceMarks = new float[noOfStudents];
        float[] englishMarks = new float[noOfStudents];
        float[] languageMarks = new float[noOfStudents];
        float[] ssMarks = new float[noOfStudents];
        float[] totalMarks = new float[noOfStudents];
        float[] avgMarks = new float[noOfStudents];

        for(int i=0;i<noOfStudents;i++){
            System.out.println("Enter Roll Number: ");
            rollNo[i] = sc.nextInt();
            System.out.println("Enter name of the student: ");
            name[i] = sc.next();
            System.out.println("Enter the marks of "+name[i]+ " in the subjects Maths, Science, English, Language, Social Studies respectively: ");
            mathMarks[i] = sc.nextFloat();
            scienceMarks[i] = sc.nextFloat();
            englishMarks[i] = sc.nextFloat();
            languageMarks[i] = sc.nextFloat();
            ssMarks[i] = sc.nextFloat();
            totalMarks[i] = mathMarks[i]+scienceMarks[i]+englishMarks[i]+languageMarks[i]+ssMarks[i];
            avgMarks[i] = totalMarks[i]/5;
        }

        String[][] bargraph = new String[noOfStudents][11];

        for(int i=0;i<noOfStudents;i++){
            bargraph[i][11] = Integer.toString(rollNo[i]);
        }

        for(int i=0;i<noOfStudents-1;i++){
            for(int j=0;j<=obj.getNoOfStars(avgMarks[i]);j++){
                bargraph[i][j] = "*";
            }
        }
        System.out.println("Bargraph is\n");
        obj.transposeMatrix(bargraph, noOfStudents, 11);

        sc.close();
    }
}
