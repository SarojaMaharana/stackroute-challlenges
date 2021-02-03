public class Petrol extends InternalCombustionEngines {
    String powerSource = "Petrol";
    public Petrol(String modelNo) {
        super(modelNo);
        // TODO Auto-generated constructor stub
    }

    public void showSpecs(){
        System.out.println("Engine Type: Internal Combustion");
        System.out.println("Engine Power Source: "+powerSource);
        System.out.println("Engine Model No.: "+super.getModelNo());
        System.out.println("No. of cylinders: "+getNoOfCylinders());
        System.out.println("Displacement: "+getDisplacement());
        System.out.println("Maximum Power Rating: "+super.getMaxPowerRating()+"kW");
        System.out.println("Maximum Torque: "+super.getMaxTorque()+"Nm");
        System.out.println("Maximum RPM: "+super.getMaxRPM()+"RPM");
        System.out.println("Weight: "+super.getWeight()+"Kg");
    }
    
}
