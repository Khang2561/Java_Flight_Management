package Model;

public class Plane {
	private String planeID;
    private String planeName;
    private int seatCount;

    // Constructors
    public Plane() {
    }

    public Plane(String planeID, String planeName, int seatCount) {
        this.planeID = planeID;
        this.planeName = planeName;
        this.seatCount = seatCount;
    }

    // Getters and setters
    public String getPlaneID() {
        return planeID;
    }

    public void setPlaneID(String planeID) {
        this.planeID = planeID;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}
