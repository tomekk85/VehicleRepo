package VehiclesConsole;

import VehiclesConsole.Models.Vehicle;
import VehiclesConsole.Models.VehicleListManager;
import VehiclesConsole.Models.VehicleStaticFactory;

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
        ArrayList<Vehicle> list = new ArrayList<>();

        //dodajemy do listy nowe obiekty(na podstawie tablicy input)
        //obiekty tworzymy przy użyciu metody make kalsy fabrycznej
        for (String[] row : input) {
            list.add(VehicleStaticFactory
                    .make(row[0], row[1], Integer.parseInt(row[2])));
        }
        //input uzytkownika
        String userInput = "AlL";
        VehicleListManager manager = new VehicleListManager(list);
        if("all".equalsIgnoreCase(userInput)){
            System.out.println(manager.fastestVehicleOfAllTypesMsg());
        } else {
            System.out.println(manager.fastestVehicleOfOneTypeMsg(userInput));
        }
    }
}
