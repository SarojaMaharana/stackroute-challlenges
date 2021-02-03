public class RouteData{
    private String fromLocation;
    private String toLocation;
    private int distanceInKM;
    private String travelTime;
    private String typicalFare;

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public int getDistanceInKM() {
        return distanceInKM;
    }

    public void setDistanceInKM(int distanceInKM) {
        this.distanceInKM = distanceInKM;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public String getTypicalFare() {
        return typicalFare;
    }

    public void setTypicalFare(String typicalFare) {
        this.typicalFare = typicalFare;
    }

    public RouteData(String fromLocation, String toLocation, int distanceInKM, String travelTime, String typicalFare) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.distanceInKM = distanceInKM;
        this.travelTime = travelTime;
        this.typicalFare = typicalFare;
    }

    @Override
    public String toString() {
        return "RouteData [distanceInKM=" + distanceInKM + ", fromLocation=" + fromLocation + ", toLocation="
                + toLocation + ", travelTime=" + travelTime + ", typicalFare=" + typicalFare + "]";
    }
    
}