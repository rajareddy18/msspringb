package sekar;

public class City {

    private final String origin;
    private final String destination;

    public City(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }


    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }
}
