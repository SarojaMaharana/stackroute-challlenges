public class Routes{
    private String sourceCity;
    private String destinationCity;
    private long distance;
    private String flightTime;
    private String cost;

    public String getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Routes(String str) {
        String[] data = str.split(", ");
        setSourceCity(data[0]);
        setDestinationCity(data[1]);
        setDistance(Long.parseLong(data[2]));
        setFlightTime(data[3]);
        setCost(data[4]);
    }
    
}