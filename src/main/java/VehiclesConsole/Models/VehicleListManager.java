package VehiclesConsole.Models;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class VehicleListManager {
    private ArrayList<String> vehicleTypes;
    private ArrayList<Vehicle> vehiclesList;

    public VehicleListManager(ArrayList<Vehicle> inputList){
        this.vehiclesList = inputList;
        vehicleTypes = vehiclesList.stream().map(Vehicle::getVehicleType).distinct()
                .map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getVehicleTypes() {
        return vehicleTypes;
    }

    //funkcja zwraca obiekt typu Vehicle dla podanej listy obiektów Vehicle i zadanego typu Vehicle
    public Vehicle getFastestVehicle(ArrayList<Vehicle> list, String vehicleType) {

        Predicate<Vehicle> predicate = new Predicate<>() {
            @Override
            public boolean test(Vehicle vehicle) {
                return vehicle.getVehicleType().equalsIgnoreCase(vehicleType);
            }
        };
        Comparator<Vehicle> comparator = new Comparator<>() {
            @Override
            // obiekt klasy Vehicle o wyższej wartości właściwości topSpeed przed obiektem o niższej wartości
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.getTopSpeed() - o2.getTopSpeed();
            }
        };

        return list.stream().filter(predicate)
                .max(comparator).get();
    }

    public String fastestVehicleOfOneTypeMsg(String vehicleType){
        vehicleType = vehicleType.toUpperCase();
        return vehicleTypes.contains(vehicleType) ?
                "Najszybszy pojazd w kategorii " + vehicleType + ":\n" + getFastestVehicle(vehiclesList, vehicleType):
                "Niewłaściwy typ klasy parametru";

    }

    public String fastestVehicleOfEveryTypeMsg(){
        String output = "";
        for(String type: vehicleTypes) {
            output = output.concat(fastestVehicleOfOneTypeMsg(type) +"\n") ;
        }
        return output;
    }
}
