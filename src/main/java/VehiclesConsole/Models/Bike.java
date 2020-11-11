package VehiclesConsole.Models;

public class Bike extends Vehicle {

    public Bike(String producer, int speed) {
        super(producer, speed);
        this.vehicleType = "BIKE";
    }
}
