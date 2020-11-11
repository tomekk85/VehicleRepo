package Vehicles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        //tablica danych wejściowych --tablica pomocnicza!!
        String[][] input = {{"car", "BMW", "245"}, {"car", "Audi", "265"},
                {"ship", "Solarsky", "85"}, {"ship", "Fox-Boat", "65"},
                {"bike", "Kawasaki", "299"}, {"bike", "MTT", "364"},
                {"plane", "Airbus", "1000"}, {"plane", "Boeing", "1045"}
        };

        //tworzymy listę przechowującą pojazdy
        ArrayList<Vehicle> list= new ArrayList<>();

        //dodajemy do listy nowe obiekty(na podstawie tablicy input)
        for(String[] row: input){
            list.add(VehicleStaticFactory
                    .make(row[0], row[1], Integer.parseInt(row[2])));
        }

        //tworzenie komparatora do sortowania listy
        Comparator<Vehicle> compareByTopSpeed= new Comparator<>() {
            @Override
            // obiekt klasy Vehicle o wyższej wartości właściwości topSpeed przed obiektem o niższej wartości
            public int compare(Vehicle o1, Vehicle o2) {
                return o2.getTopSpeed() - o1.getTopSpeed();
            }
        };

        //tablica typów
        String[] vehicleTypesArray = {"CAR", "SHIP", "PLANE", "BIKE"};

        //input uzytkownika
        String userInput = "ALL";

        String output = "";
        if("All".equalsIgnoreCase(userInput)){
            for(String type :vehicleTypesArray){
                System.out.println(
                        "Najszybszy pojazd w kategorii " + type + ":\n" +
                        getFastestVehicle(list, type)
                );
            }

        } else {
            System.out.println(
                    "Najszybszy pojazd w kategorii " + userInput +":\n" +
                getFastestVehicle(list, userInput)
            );
        }



    }
    //funkcja zwraca obiekt typu Vehicle dla podanej listy obiektów Vehicle i zadanego typu Vehicle

    public static Vehicle getFastestVehicle(ArrayList<Vehicle> list, String vehicleType){

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
}
