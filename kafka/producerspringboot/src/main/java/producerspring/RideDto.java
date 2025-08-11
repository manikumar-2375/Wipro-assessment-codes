package producerspring;

import java.io.Serializable;

public class RideDto implements Serializable {
    private Long id;
    private String driverName;
    private String passengerName;
    private String pickupLocation;
    private String dropLocation;
    private Double fare;

    public RideDto() {}

    public RideDto(Long id, String driverName, String passengerName, String pickupLocation, String dropLocation, Double fare) {
        this.id = id;
        this.driverName = driverName;
        this.passengerName = passengerName;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.fare = fare;
    }

    public Long getId() {
        return id;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public Double getFare() {
        return fare;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }
}
