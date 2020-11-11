package Vehicles;

public class VehicleStaticFactory {
    public static Vehicle make (String type, String producer, int speed) {
        type = type.toUpperCase();
        switch (type) {
            case "CAR":
                return new Car(producer, speed);
            case "SHIP":
                return new Ship(producer, speed);
            case "PLANE":
                return new Plane(producer, speed);
            case "BIKE":
                return new Bike(producer, speed);
            default:
                return null;
        }
    }
}
