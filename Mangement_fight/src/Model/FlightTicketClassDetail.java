package Model;

import java.math.BigDecimal;

public class FlightTicketClassDetail {
	private String flightID;
    private String ticketClassID;
    private BigDecimal fare;
    private int seatCapacity;
    private int ticketSold;
    private int seatRemaining;

    // Constructor
    public FlightTicketClassDetail() {
    }

    // Getters and setters
    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getTicketClassID() {
        return ticketClassID;
    }

    public void setTicketClassID(String ticketClassID) {
        this.ticketClassID = ticketClassID;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public int getTicketSold() {
        return ticketSold;
    }

    public void setTicketSold(int ticketSold) {
        this.ticketSold = ticketSold;
    }

    public int getSeatRemaining() {
        return seatRemaining;
    }

    public void setSeatRemaining(int seatRemaining) {
        this.seatRemaining = seatRemaining;
    }
}
