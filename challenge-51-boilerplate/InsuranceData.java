import java.util.function.Supplier;

public class InsuranceData{
    private int age;
    private String gender;
    private float bmi;
    private int children;
    private String smoker;
    private String region;
    private double charges;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public String getSmoker() {
        return smoker;
    }

    public void setSmoker(String smoker) {
        this.smoker = smoker;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(Supplier<String> highestRegionSupplier) {
        this.region = highestRegionSupplier.toString();
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public InsuranceData(int age, String gender, float bmi, int children, String smoker, String region,
            double charges) {
        this.age = age;
        this.gender = gender;
        this.bmi = bmi;
        this.children = children;
        this.smoker = smoker;
        this.region = region;
        this.charges = charges;
    }

    @Override
    public String toString() {
        return "InsuranceData [age=" + age + ", bmi=" + bmi + ", charges=" + charges + ", children=" + children
                + ", gender=" + gender + ", region=" + region + ", smoker=" + smoker + "]";
    }
    
}