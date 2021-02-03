public class Voter {
    String name;
    String voterId;
    int age;

    public Voter(String name, String voterId, int age) {
        this.name = name;
        this.voterId = voterId;
        this.age = age;
    }

    //age exception -> give control to the handler -> 
    // validate age
    public void validateAge() throws AgeException
    {
        if(age<18)
            throw new AgeException("Cannot vote");
        else
            System.out.println("Eligible to vote");
    }
    
}
