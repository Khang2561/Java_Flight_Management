package Model;

public class PlaneTicketClassDetail {
	private String planeID;
    private TicketClass ticketClass;
    private int quantity;

    // Constructor
    public PlaneTicketClassDetail() {
    }

    // Getters and setters
    public String getPlaneID() {
        return planeID;
    }

    public void setPlaneID(String planeID) {
        this.planeID = planeID;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
