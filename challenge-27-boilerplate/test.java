public class test {
    public static void main(String[] args){
        System.out.println(java.time.LocalDate.now());
        String date = (java.time.LocalDate.now()).toString();
        String[] sample = date.split("-");

        for(String i:sample){
            System.out.println(i);
        }
    }
}
