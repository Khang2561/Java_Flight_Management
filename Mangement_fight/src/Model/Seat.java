package Model;

public class Seat {
	private String seatID;
    private String planeID;
    private String ticketClass;
    private boolean isHave;

    // Constructor
    public Seat() {
    }

    // Getters and setters
    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public String getPlaneID() {
        return planeID;
    }

    public void setPlaneID(String planeID) {
        this.planeID = planeID;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public boolean isHave() {
        return isHave;
    }

    public void setHave(boolean have) {
        isHave = have;
    }
}
