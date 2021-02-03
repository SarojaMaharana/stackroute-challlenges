public class ElectricEngine extends Engine {
    String currentType;
    int voltage;
    public ElectricEngine(String modelNo) {
        super(modelNo);
        System.out.println("Enter the Current Type - AC or DC for the engine model no. "+super.getModelNo());
        setCurrentType(sc.next());
        System.out.println("Enter the voltage required for the engine model no. "+super.getModelNo());
    }

    public String getCurrentType() {
        return currentType;
    }

    public void setCurrentType(String currentType) {
        this.currentType = currentType;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public void showSpecs(){
        System.out.println("Engine Type: Electric Engine");
        System.out.println("Engine Power Source: Electricity");
        System.out.println("Engine Model No.: "+super.getModelNo());
        System.out.println("Current Type: "+getCurrentType());
        System.out.println("Voltage: "+getVoltage()+"V");
        System.out.println("Maximum Power Rating: "+super.getMaxPowerRating()+"kW");
        System.out.println("Maximum Torque: "+super.getMaxTorque()+"Nm");
        System.out.println("Maximum RPM: "+super.getMaxRPM()+"RPM");
        System.out.println("Weight: "+super.getWeight()+"Kg");
    }   
}
