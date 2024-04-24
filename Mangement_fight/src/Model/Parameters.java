package Model;

public class Parameters {
	private static int minimumFlightTime;
    private static int maxPreventiveAirports;
    private static int minimumStopoverTime;
    private static int maximumStopoverTime;
    private static int earliestBookingTime;
    private static int latestBookingCancellationTime;

    private static Parameters instance;

    // Private constructor to prevent instantiation from outside
    private Parameters() {}

    // Getters and setters
    public static Parameters getInstance() {
        if (instance == null) {
            instance = new Parameters();
        }
        return instance;
    }

    public int getMinimumFlightTime() {
        return minimumFlightTime;
    }

    public void setMinimumFlightTime(int minimumFlightTime) {
        Parameters.minimumFlightTime = minimumFlightTime;
    }

    public int getMaxPreventiveAirports() {
        return maxPreventiveAirports;
    }

    public void setMaxPreventiveAirports(int maxPreventiveAirports) {
        Parameters.maxPreventiveAirports = maxPreventiveAirports;
    }

    public int getMinimumStopoverTime() {
        return minimumStopoverTime;
    }

    public void setMinimumStopoverTime(int minimumStopoverTime) {
        Parameters.minimumStopoverTime = minimumStopoverTime;
    }

    public int getMaximumStopoverTime() {
        return maximumStopoverTime;
    }

    public void setMaximumStopoverTime(int maximumStopoverTime) {
        Parameters.maximumStopoverTime = maximumStopoverTime;
    }

    public int getEarliestBookingTime() {
        return earliestBookingTime;
    }

    public void setEarliestBookingTime(int earliestBookingTime) {
        Parameters.earliestBookingTime = earliestBookingTime;
    }

    public int getLatestBookingCancellationTime() {
        return latestBookingCancellationTime;
    }

    public void setLatestBookingCancellationTime(int latestBookingCancellationTime) {
        Parameters.latestBookingCancellationTime = latestBookingCancellationTime;
    }
}
