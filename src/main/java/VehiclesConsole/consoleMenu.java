package VehiclesConsole;

import VehiclesConsole.Models.Vehicle;
import VehiclesConsole.Models.VehicleListManager;

import java.util.ArrayList;
import java.util.Scanner;

public class consoleMenu {
    private ArrayList<Vehicle> vehicleList;
    private int userInput;
    private String menuMsg;
    private String errorMsg;
    private String continueMsg;
    private String[] arrOfTypes ;

    public consoleMenu(ArrayList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
        this.userInput = 0;
        initializeMessages();
        arrOfTypes = new String[]{"", "CAR", "SHIP", "PLANE", "BIKE", "ALL", "EXIT"};//corresponds with menuMsg
        //Menu index              0     1       2       3       4       5       6
        start();
    }

    private void initializeMessages(){
        menuMsg = "Witaj w programie POJAZD!\n" +
                "Wybierz, kategorię do wyszukania najszybszych pojazdów\n" +
                "1. Samochód\n" +
                "2. Statek\n" +
                "3. Samolot\n" +
                "4. Motocykl\n" +
                "5. Wszystkie kategorie\n" +
                "6. Wyjście";

        errorMsg = "Musisz podać liczbę z przedziału 1-6";

        continueMsg = "Naciśnij Enter, aby kontynuować";

    }

    //zaczyna komunikacje z użytkownikiem
    private void start() {
        while (userInput != 6) {
            printMenu();
            userInput = loadInput();
            if (userInput == 6) {
                break;
            }

            VehicleListManager manager = new VehicleListManager(vehicleList);

            if ("all".equalsIgnoreCase(arrOfTypes[userInput])) {
                System.out.println(manager.fastestVehicleOfEveryTypeMsg());
            } else {
                System.out.println(manager.fastestVehicleOfSpecifiedTypeMsg(arrOfTypes[userInput]));
            }

            waitForKey();
            //System.out.println("\n");
        }
    }
    //drukuje do konsoli komunikat
    //i czeka na potwierdzenie przez użytkonika
    private void waitForKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(continueMsg);
        scanner.nextLine();
    }

    //drukuje menu do konsoli
    private void printMenu() {
        System.out.println(menuMsg);
    }

    //pobiera dane od użytkownika,
    //oraz przeprowadza walidację
    //zwraca wartość z przedziału 1-6
    private int loadInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.matches("[1-6]")) {
            System.out.println(errorMsg);
            input = scanner.nextLine();
        }

        return Integer.parseInt(input);
    }
}
