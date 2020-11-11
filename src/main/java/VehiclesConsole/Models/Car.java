package VehiclesConsole.Models;

public class Car extends Vehicle {

    public Car(String producer, int speed) {
        super(producer, speed);
        this.vehicleType = "CAR";
    }
}
