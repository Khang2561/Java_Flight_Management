package Model;

import java.awt.Color;

public class TicketClass {
	private String ticketClassID;
    private String ticketClassName;
    private int pricePercentage;
    private Color colorTicketClass;

    // Constructors
    public TicketClass() {
    }

    public TicketClass(String ticketClassName, int pricePercentage, String ticketClassID) {
        this.ticketClassName = ticketClassName;
        this.pricePercentage = pricePercentage;
        this.ticketClassID = ticketClassID;
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

    public int getPricePercentage() {
        return pricePercentage;
    }

    public void setPricePercentage(int pricePercentage) {
        this.pricePercentage = pricePercentage;
    }

    public Color getColorTicketClass() {
        return colorTicketClass;
    }

    public void setColorTicketClass(Color colorTicketClass) {
        this.colorTicketClass = colorTicketClass;
    }
}
