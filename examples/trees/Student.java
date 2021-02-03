public class Student {
   String studentName;
   int totalMarks;

   public String getStudentName() {
       return studentName;
   }

   public void setStudentName(String studentName) {
       this.studentName = studentName;
   }

   public int getTotalMarks() {
       return totalMarks;
   }

   public void setTotalMarks(int totalMarks) {
       this.totalMarks = totalMarks;
   }

   @Override
   public String toString() {
       return "Student [studentName=" + studentName + ", totalMarks=" + totalMarks + "]";
   }

   public Student(String studentName, int totalMarks) {
       this.studentName = studentName;
       this.totalMarks = totalMarks;
   }

   
    
}
