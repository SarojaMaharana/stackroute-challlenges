import java.util.Scanner;

public class AGSchool{

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
        float[] avgMarks = new float[5];

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
        }

        avgMarks[0] = obj.calculateAvg(mathMarks);
        avgMarks[1] = obj.calculateAvg(scienceMarks);
        avgMarks[2] = obj.calculateAvg(englishMarks);
        avgMarks[3] = obj.calculateAvg(languageMarks);
        avgMarks[4] = obj.calculateAvg(ssMarks);

        System.out.println("");
        System.out.format("%s %20s %20s", "Roll No.", "Name", "Total");
        System.out.println("");
        for(int i=0;i<noOfStudents;i++){
            System.out.format("%d %20s %20.2f", rollNo[i], name[i], totalMarks[i]);
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");

        float top = 0f;
        int index = 0;

        for(int i=0;i<noOfStudents;i++){
            if(top < totalMarks[i]){
                top = totalMarks[i];
                index = i;
            }
        }
        System.out.println("The topper of the class is " +rollNo[index]+ " " +name[index]);
        System.out.println("");
        System.out.println("");

        System.out.format("%s %20s", "Subject", "Avg Score");
        System.out.println("");
        System.out.format("%s %20.2f", "Maths", avgMarks[0]);
        System.out.println("");
        System.out.format("%s %20.2f", "Science", avgMarks[1]);
        System.out.println("");
        System.out.format("%s %20.2f", "English", avgMarks[2]);
        System.out.println("");
        System.out.format("%s %20.2f", "Language", avgMarks[3]);
        System.out.println("");
        System.out.format("%s %20.2f", "Social", avgMarks[4]);
        System.out.println("");

        sc.close();
    }
}