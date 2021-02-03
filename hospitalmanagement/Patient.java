class Patient {
    int personalID;
    String patientID;
    String patientName;
    boolean patientCondition;
    double totalBill;

    public int getPersonalID() {
        return personalID;
    }

    public void setPersonalID(int personalID) {
        this.personalID = personalID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public boolean isPatientCondition() {
        return patientCondition;
    }

    public void setPatientCondition(boolean patientCondition) {
        this.patientCondition = patientCondition;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    @Override
    public String toString() {
        return "Patient [patientCondition=" + patientCondition + ", patientID=" + patientID + ", patientName="
                + patientName + ", personalID=" + personalID + ", totalBill=" + totalBill + "]";
    }

    public Patient(int personalID, String patientID, String patientName, boolean patientCondition, double totalBill) {
        this.personalID = personalID;
        this.patientID = patientID;
        this.patientName = patientName;
        this.patientCondition = patientCondition;
        this.totalBill = totalBill;
    }
}