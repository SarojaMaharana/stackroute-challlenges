public class VoterImpl {
    public static void main(String[] args) {
        Voter voter = new Voter("Sara", "V1234100", 16);
        try {
            voter.validateAge();
        } catch (AgeException e) {
           e.printStackTrace();
        }
    }
}
