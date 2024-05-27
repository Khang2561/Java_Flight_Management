package Model;

import java.awt.Color;

public class TicketClass {
	private String ticketClassID;
    private String ticketClassName;
    private String pricePercentage;
    private Color colorTicketClass;

    // Constructors
    public TicketClass() {
    }

    public TicketClass(String ticketClassName, String pricePercentage, String ticketClassID, Color colorTicketClass) {
        this.ticketClassName = ticketClassName;
        this.pricePercentage = pricePercentage;
        this.ticketClassID = ticketClassID;
        this.colorTicketClass = colorTicketClass;
    }

    // Getters and setters
    public String getTicketClassID() {
        return ticketClassID;
    }

    public void setTicketClassID(String ticketClassID) {
        this.ticketClassID = ticketClassID;
    }

    public String getTicketClassName() {
        return ticketClassName;
    }

    public void setTicketClassName(String ticketClassName) {
        this.ticketClassName = ticketClassName;
    }

    public String getPricePercentage() {
        return pricePercentage;
    }

    public void setPricePercentage(String pricePercentage) {
        this.pricePercentage = pricePercentage;
    }

    public Color getColorTicketClass() {
        return colorTicketClass;
    }

    public void setColorTicketClass(Color colorTicketClass) {
        this.colorTicketClass = colorTicketClass;
    }
}
