public class NumbersImpl {
    public static void main(String[] args) {
        
        ReturnNumber ret = new ReturnNumber(){

            @Override
            public int getNumber() {
               
                return 10;
            }
            
        };

        System.out.println(ret.getNumber());


        ReturnNumber retr = () -> 10;

        System.out.println(retr.getNumber());


        Numbers n = new Numbers(){
            @Override
            public String oddEven(int no) {
                if(no%2==0) return no+" is even";
                else return no+" is odd";
            }
        };

        System.out.println(n.oddEven(5));

        Numbers num = (x) -> x%2 == 0 ? "even":"odd";

        System.out.println(num.oddEven(5));

       

    
    }
}
