public class Implementation {
    public static void main(String[] args) {
        Petrol P = new Petrol("P1000");
        Diesel D = new Diesel("D1300");
        CNG C = new CNG("C1000");
        ElectricEngine E = new ElectricEngine("88");

        P.showSpecs();
        D.showSpecs();
        C.showSpecs();
        E.showSpecs();
    }
}
