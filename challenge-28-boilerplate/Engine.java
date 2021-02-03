import java.util.Scanner;

public abstract class Engine {
    Scanner sc = new Scanner(System.in);
    String modelNo;
    int maxPowerRating;
    int maxTorque;
    long maxRPM;
    int weight;

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public int getMaxPowerRating() {
        return maxPowerRating;
    }

    public void setMaxPowerRating(int maxPowerRating) {
        this.maxPowerRating = maxPowerRating;
    }

    public int getMaxTorque() {
        return maxTorque;
    }

    public void setMaxTorque(int maxTorque) {
        this.maxTorque = maxTorque;
    }

    public long getMaxRPM() {
        return maxRPM;
    }

    public void setMaxRPM(long maxRPM) {
        this.maxRPM = maxRPM;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Engine(String modelNo) {
        setModelNo(modelNo);
        System.out.println("Enter the Maximum Power Rating - In kW or Horsepower (HP) for engine model no. "+getModelNo());
        setMaxPowerRating(sc.nextInt());
        System.out.println("Enter the Maximum Torque - In Newton-metres (Nm) for the engine model no. "+getModelNo());
        setMaxTorque(sc.nextInt());
        System.out.println("Enter the Maximum RPM - RPM for the engine model no. "+getModelNo());
        setMaxRPM(sc.nextLong());
        System.out.println("Enter the Weight - In Kgs of the engine model no. "+getModelNo());
        setWeight(sc.nextInt());
    }

    public abstract void showSpecs();
    
}