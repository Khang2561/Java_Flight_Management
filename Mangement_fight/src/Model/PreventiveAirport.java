package Model;

public class PreventiveAirport {
	private String flightID;
    private String preventiveAirportID;
    private String airportName;
    private String cityName;
    private int stopoverDuration;
    private String note;

    // Constructor
    public PreventiveAirport() {
    }

    // Getters and setters
    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getPreventiveAirportID() {
        return preventiveAirportID;
    }

    public void setPreventiveAirportID(String preventiveAirportID) {
        this.preventiveAirportID = preventiveAirportID;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getStopoverDuration() {
        return stopoverDuration;
    }

    public void setStopoverDuration(int stopoverDuration) {
        this.stopoverDuration = stopoverDuration;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
