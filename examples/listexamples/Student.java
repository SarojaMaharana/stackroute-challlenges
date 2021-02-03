public class Student //implements Comparable<Student> 
{
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

   @Override
   public int hashCode() {
      return this.totalMarks+this.studentName.hashCode();
   }

   @Override
   public boolean equals(Object obj) {
      Student std = (Student) obj;
      if(totalMarks!=std.getTotalMarks())
        return false;
      if(studentName == null){
          if(std.getStudentName()!=null) return false;
      }
      else if(!studentName.equals(std.getStudentName())) return false;
      return true;
   }

//    @Override
//    public int compareTo(Student sobj) {
//        if(totalMarks>sobj.getTotalMarks())
//             return 1;
//         else if(totalMarks<sobj.getTotalMarks())
//             return -1;
//         else return 0;
//    }

   
    
}
