package VehiclesConsole.Models;


public  class Vehicle {
    private int topSpeed;
    private String producer;
    public String vehicleType;

    public String getVehicleType() {
        return vehicleType;
    }

    public Vehicle(String producer, int speed) {
        this.producer = producer;
        this.topSpeed = speed;
    }
    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
    @Override
    public String toString(){
        return "[Producent]:" + getProducer() + ", [Prędkość]:" + getTopSpeed();
    }
}
