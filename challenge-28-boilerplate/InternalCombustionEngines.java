public class InternalCombustionEngines extends Engine {
    int noOfCylinders;
    int displacement;
    
    public InternalCombustionEngines(String modelNo) {
        super(modelNo);
        System.out.println("Enter the Number of Cylinders - Integer – typically 3, 4, 6, or 8 for engine model no."+super.getModelNo());
        setNoOfCylinders(sc.nextInt());
        System.out.println("Enter the Displacement - Total volume of all the cylinders in litres (l) or cubic cm (cc) for engine model no."+super.getModelNo());
        setDisplacement(sc.nextInt());
    }

    public int getNoOfCylinders() {
        return noOfCylinders;
    }

    public void setNoOfCylinders(int noOfCylinders) {
        this.noOfCylinders = noOfCylinders;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    @Override
    public void showSpecs() {
        // TODO Auto-generated method stub

    }
    
}
