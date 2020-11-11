package VehiclesConsole;

import VehiclesConsole.Models.Vehicle;
import VehiclesConsole.Models.VehicleListManager;
import VehiclesConsole.Models.VehicleStaticFactory;

import java.util.ArrayList;
import java.util.Scanner;

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


        String[] arr = {"", "CAR", "SHIP", "PLANE", "BIKE", "ALL", "EXIT"};

        String strInput = "";

        while(!"6".equals(strInput)){
            printMenu();
            Scanner scanner = new Scanner(System.in);
            strInput = loadInput();

            if("6".equals(strInput)){break;}
            int userInput = Integer.parseInt(strInput);

            VehicleListManager manager = new VehicleListManager(list);

            if("all".equalsIgnoreCase(arr[userInput])){
                System.out.println(manager.fastestVehicleOfEveryTypeMsg());
            } else {
                System.out.println(manager.fastestVehicleOfOneTypeMsg(arr[userInput]));
            }
            waitForKey();
            System.out.println("\n");
        }

    }
    public static void waitForKey(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Naciśnij Enter, aby kontynuować");
        scan.nextLine();
    }

    public static void printMenu(){
        String menu = "Witaj w programie POJAZD!\n" +
                "Wybierz, kategorię do wyszukania najszybszych pojazdów\n" +
                "1. Samochód\n" +
                "2. Statek\n" +
                "3. Samolot\n" +
                "4. Motocykl\n" +
                "5. Wszystkie kategorie\n" +
                "6. Wyjście";
        System.out.println(menu);
    }

    public static String loadInput(){

        String error = "Musisz podać liczbę z przedziału 1-6";
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!input.matches("[1-6]")) {
            System.out.println(error);
            input = scanner.nextLine();
        }
        return input;
    }
}
