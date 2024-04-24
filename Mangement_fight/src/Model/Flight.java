package Model;

import java.math.BigDecimal;
import java.sql.Date;

public class Flight {
	 private String flightID;
	    private String planeID;
	    private String departureAirportCode;
	    private String departureAirportName;
	    private String departureCityName;
	    private String arrivalAirportCode;
	    private String arrivalAirportName;
	    private String arrivalCityName;
	    private BigDecimal ticketPrice;
	    private Date departureDateTime;
	    private int flightDuration;
	    
	 // Constructor
	    public Flight() {
	    }

	    // Getters and setters
	    public String getFlightID() {
	        return flightID;
	    }

	    public void setFlightID(String flightID) {
	        this.flightID = flightID;
	    }

	    public String getPlaneID() {
	        return planeID;
	    }

	    public void setPlaneID(String planeID) {
	        this.planeID = planeID;
	    }

	    public String getDepartureAirportCode() {
	        return departureAirportCode;
	    }

	    public void setDepartureAirportCode(String departureAirportCode) {
	        this.departureAirportCode = departureAirportCode;
	    }

	    public String getDepartureAirportName() {
	        return departureAirportName;
	    }

	    public void setDepartureAirportName(String departureAirportName) {
	        this.departureAirportName = departureAirportName;
	    }

	    public String getDepartureCityName() {
	        return departureCityName;
	    }

	    public void setDepartureCityName(String departureCityName) {
	        this.departureCityName = departureCityName;
	    }

	    public String getArrivalAirportCode() {
	        return arrivalAirportCode;
	    }

	    public void setArrivalAirportCode(String arrivalAirportCode) {
	        this.arrivalAirportCode = arrivalAirportCode;
	    }

	    public String getArrivalAirportName() {
	        return arrivalAirportName;
	    }

	    public void setArrivalAirportName(String arrivalAirportName) {
	        this.arrivalAirportName = arrivalAirportName;
	    }

	    public String getArrivalCityName() {
	        return arrivalCityName;
	    }

	    public void setArrivalCityName(String arrivalCityName) {
	        this.arrivalCityName = arrivalCityName;
	    }

	    public BigDecimal getTicketPrice() {
	        return ticketPrice;
	    }

	    public void setTicketPrice(BigDecimal ticketPrice) {
	        this.ticketPrice = ticketPrice;
	    }

	    public Date getDepartureDateTime() {
	        return departureDateTime;
	    }

	    public void setDepartureDateTime(Date departureDateTime) {
	        this.departureDateTime = departureDateTime;
	    }

	    public int getFlightDuration() {
	        return flightDuration;
	    }

	    public void setFlightDuration(int flightDuration) {
	        this.flightDuration = flightDuration;
	    }
}
