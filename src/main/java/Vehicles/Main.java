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
        Comparator<Vehicle> compareByTopSpeed= new Comparator<Vehicle>() {
            @Override
            // obiekt klasy Vehicle o wyższej wartości właściwości topSpeed przed obiektem o niższej wartości
            public int compare(Vehicle o1, Vehicle o2) {
                return o2.getTopSpeed() - o1.getTopSpeed();
            }
        };

        //tablica możliwych polecen uzytkownika
        String[] userInputArray = {"CAR", "SHIP", "PLANE", "BIKE", "ALL", "EXIT"};//tablica pomocnicza!!

        //input uzytkownika
        String userInput = userInputArray[0];
        //użycie strumienia
        list.stream()
                .filter(//1.filtrowanie listy
                        new Predicate<Vehicle>() {// w tym celu tworzymy obiekt typu Predicate
            @Override
            public boolean test(Vehicle vehicle) {
                return userInput.equalsIgnoreCase("ALL") ? //jeżeli input użtywkownika=="all"
                        true:                                          //zwróć wszystko
                        vehicle.getVehicleType().equalsIgnoreCase(userInput);// jeżeli nie - przyrównaj input użytkownika do typu Vehicle
            }
        })
                .sorted(compareByTopSpeed)//2.sortowanie listy za pomocą komparatora
                .forEach(System.out::println);//wypisanie listy

    }
}
