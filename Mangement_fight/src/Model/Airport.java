package Model;

public class Airport {
	private String airportID;
    private String airportName;
    private String cityName;
    private String countryName;

    // Constructors
    public Airport() {
    }

    public Airport(String airportID, String airportName, String cityName, String countryName) {
        super();
    	this.airportID = airportID;
        this.airportName = airportName;
        this.cityName = cityName;
        this.countryName = countryName;
    }

	public String getAirportID() {
		return airportID;
	}

	public void setAirportID(String airportID) {
		this.airportID = airportID;
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

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "Airport [airportID=" + airportID + ", airportName=" + airportName + ", cityName=" + cityName
				+ ", countryName=" + countryName + "]";
	}

}
