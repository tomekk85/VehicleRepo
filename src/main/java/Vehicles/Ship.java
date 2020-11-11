package Vehicles;

public class Ship extends Vehicle {

    public Ship(String producer, int speed) {
        super(producer, speed);
        this.vehicleType = "SHIP";
    }
}
