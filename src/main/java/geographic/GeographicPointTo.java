package geographic;

public class GeographicPointTo {
    double latitude;
    double longitude;

    public GeographicPointTo(){

    }

    public GeographicPointTo(String street, String city, String country, String postalCode) {
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
