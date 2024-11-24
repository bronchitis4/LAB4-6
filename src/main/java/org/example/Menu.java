package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Menu {

    Scanner sc = new Scanner(System.in);
    List<Command> commandList = null;
    ListOfCommands commandsList;

    public Menu(){
        commandList = new ArrayList<Command>();
        commandsList = new ListOfCommands();
    }

    public void menu(List<Vehicle> cars) {

        List<Command> commandList = Arrays.asList(
                new AddVehicle(commandsList),
                new DeleteVehicle(commandsList),
                new CalculatePriceOfAllParts(commandsList),
                new Sort(commandsList),
                new SearchVehicleVinCode(commandsList),
                new ReviewTechnicalStateOfCars(commandsList),
                new SendVehicleToRepairStation(commandsList),
                new FindCarsBySpeedRange(commandsList),
                new ExitAndSave(commandsList)
        );
       // MenuManager manager = new MenuManager();

        int answer = 1;
        while (true) {
            outputMenu();
            answer = sc.nextInt() - 1;

            if (answer < 0 || answer >= commandList.size()) {
                commandList.getLast().execute(cars);
                System.out.println("Exit...");
                break;
            }
            commandList.get(answer).execute(cars);
        }
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (var elm : commandList){
            System.out.println(elm);
        }
        System.out.println("0. Exit");
        System.out.println("1. Add Car");
        System.out.println("2. Delete Car");
        System.out.println("3. Calculate Price");
        System.out.println("4. Sort by Speed");
        System.out.println("5. Search Vehicle Vin Code");
        System.out.println("6. Review Technical State of Cars");
        System.out.println("7. Send Vehicle to Repair Station");
        System.out.println("8. Find Cars by Speed");
    }
}
