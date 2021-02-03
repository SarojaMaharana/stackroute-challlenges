public class PrimeImpl {
    public static void main(String[] args) {
        //block lambda
        Prime prime = (no) ->
        {
            boolean flag = false;
            for(int i =2;i<no/2;i++)
            {
                if(no%i == 0)
                {
                    flag = true;
                    break;
                }
                                 
            }
            if(flag)
                    return no+" is a not prime";  
            else
                return no+ " is prime";
        };

        System.out.println(prime.findPrimeNo(30));
    }
}
