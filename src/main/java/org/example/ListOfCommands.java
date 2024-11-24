package org.example;

import java.io.*;
import java.util.*;

public class ListOfCommands
{
    Scanner sc = new Scanner(System.in);

    public List<Vehicle> createListOfCars() {
        List<Vehicle> cars = new ArrayList<>();
        String filename = "C:\\Users\\danil\\OneDrive\\Робочий стіл\\Лабораторні\\Лабораторні\\ПП\\data.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length != 9) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                try {
                    String brand = parts[0];
                    String typeBody = parts[1];
                    int vinCode = Integer.parseInt(parts[2]);
                    int[] stateOfCar = new int[3];

                    for (int i = 0; i < 3; i++) {
                        stateOfCar[i] = Integer.parseInt(parts[3 + i]);
                    }

                    double averageSpeed = Double.parseDouble(parts[6]);
                    double usingFuelPerDay = Double.parseDouble(parts[7]);
                    double price = Double.parseDouble(parts[8]);

                    Vehicle vehicle = new Vehicle(brand, typeBody, vinCode, stateOfCar, averageSpeed, usingFuelPerDay, price);
                    cars.add(vehicle);
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid line (data format error): " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return cars;
    }


    public void addVehicle(List<Vehicle> cars) {
        sc.nextLine();
        System.out.println("\nADD CAR");

        System.out.print("Enter brand:");
        String brand = sc.nextLine();

        System.out.print("Enter body type:");
        String typeBody = sc.nextLine();

        System.out.print("Enter VIN code:");
        int vinCode = sc.nextInt();

        int[] stateOfCar = new int[3];
        System.out.print("Enter each technical state:");
        for (int i = 0; i < 3; i++) {
            stateOfCar[i] = sc.nextInt();
        }

        System.out.print("Enter average speed:");
        double averageSpeed = sc.nextDouble();

        System.out.print("Enter daily fuel consumption:");
        double usingFuelPerDay = sc.nextDouble();

        System.out.print("Price:");
        double price = sc.nextDouble();

        Vehicle newVehicle = new Vehicle(brand, typeBody, vinCode, stateOfCar, averageSpeed, usingFuelPerDay, price);

        cars.add(newVehicle);

        System.out.println("Vehicle added successfully!");
    }

    public void deleteVehicle(List<Vehicle> cars) {
        sc.nextLine();
        System.out.println("\nDELETE CAR");

        if (cars == null || cars.isEmpty()) {
            System.out.println("The list of vehicles is empty.");
            return;
        }

        System.out.print("Enter the VinCode of the vehicle to delete: ");
        int vinCode = sc.nextInt();

        boolean removed = cars.removeIf(car -> car.getVinCode() == vinCode);

        if (removed) {
            System.out.println("The vehicle with VinCode " + vinCode + " was successfully deleted.");
        } else {
            System.out.println("No vehicle found with VinCode " + vinCode + ".");
        }
    }

    public void calculatePrice(List<Vehicle> cars) {
        sc.nextLine();
        System.out.println("\nCALCULATE PRICE");

        if (cars == null || cars.isEmpty()) {
            System.out.println("The list of vehicles is empty.");
            return;
        }
        double totalPriceOfAllVehicles = 0;

        for (Vehicle car : cars) {
            double vehiclePrice = car.getPrice();
            System.out.println("Price of vehicle (VIN: " + car.getVinCode() + "): $" + vehiclePrice);
            totalPriceOfAllVehicles += vehiclePrice;
        }

        System.out.println("The total price of all vehicles: $" + totalPriceOfAllVehicles);
    }

    public void sort(List<Vehicle> cars) {

        System.out.println("\nSORT BY SPEED");

        if (cars == null || cars.isEmpty()) {
            System.out.println("The list of vehicles is empty.");
            return;
        }

        Collections.sort(cars, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return Double.compare(v1.getAverageSpeed(), v2.getAverageSpeed());
            }
        });

        System.out.println("Vehicles sorted by average speed:");
        for (Vehicle car : cars) {
            System.out.println("Speed: " + car.getAverageSpeed() + " km/h, Brand: " + car.getBrand());
        }
    }

    public void searchVehicleVinCode(List<Vehicle> cars) {
        sc.nextLine();
        System.out.println("\nSEARCH BY VINCODE");


        if (cars == null || cars.isEmpty()) {
            System.out.println("The list of vehicles is empty.");
            return;
        }

        System.out.print("Enter VIN Code to search: ");
        int vinCodeToSearch = sc.nextInt();

        Vehicle foundVehicle = null;
        for (Vehicle car : cars) {
            if (car.getVinCode() == vinCodeToSearch) {
                foundVehicle = car;
                break;
            }
        }

        if (foundVehicle != null) {
            System.out.println("Vehicle found: ");
            System.out.println("Brand: " + foundVehicle.getBrand());
            System.out.println("Body Type: " + foundVehicle.getTypeBody());
            System.out.println("VIN Code: " + foundVehicle.getVinCode());
            System.out.println("Average Speed: " + foundVehicle.getAverageSpeed() + " km/h");
            System.out.println("Fuel Consumption: " + foundVehicle.getUsingFuelPerDay() + " liters/day");
        } else {
            System.out.println("Vehicle with VIN code " + vinCodeToSearch + " not found.");
        }
    }

    public void reviewTechnicalStateOfCars(List<Vehicle> cars) {
        sc.nextLine();
        System.out.println("\nCHECK TECHNICAL STATE OF CARS");

        if (cars == null || cars.isEmpty()) {
            System.out.println("No cars available for review.");
            return;
        }

        for (Vehicle car : cars) {
            System.out.println("Reviewing vehicle: " + car.getBrand() + " - VIN: " + car.getVinCode());

            int[] stateOfCar = car.getStateOfCar();

            System.out.println("Technical state of the car:");

            if (stateOfCar != null) {
                for (int i = 0; i < stateOfCar.length; i++) {
                    String stateMessage = (stateOfCar[i] == 0) ? "Good condition" : "Needs maintenance";
                    System.out.println("Part " + (i + 1) + ": " + stateMessage);
                }
            } else {
                System.out.println("No technical data available.");
            }

            System.out.println();
        }
    }

    public void sendVehicleToRepairStation(List<Vehicle> cars) {
        sc.nextLine();
        System.out.println("\nSEND VEHICLE TO REPAIR STATION");

        if (cars == null || cars.isEmpty()) {
            System.out.println("No cars available to send for repairs.");
            return;
        }

        for (Vehicle car : cars) {
            System.out.println("Checking vehicle: " + car.getBrand() + " - VIN: " + car.getVinCode());

            int[] stateOfCar = car.getStateOfCar();
            boolean needsRepair = false;

            if (stateOfCar != null) {
                for (int i = 0; i < stateOfCar.length; i++) {
                    if (stateOfCar[i] == 1) {
                        needsRepair = true;
                        break;
                    }
                }
            }

            if (needsRepair) {
                System.out.println("Vehicle " + car.getBrand() + " (VIN: " + car.getVinCode() + ") has been sent to the repair station.");
            } else {
                System.out.println("Vehicle " + car.getBrand() + " (VIN: " + car.getVinCode() + ") does not need repairs.");
            }

            System.out.println();
        }
    }

    public void findCarsBySpeedRange(List<Vehicle> cars) {
        sc.nextLine();
        System.out.println("\nFIND CAR BY SPEED RANGE");

        if (cars == null || cars.isEmpty()) {
            System.out.println("No cars available to search.");
            return;
        }

        System.out.print("Enter minimum speed: ");
        double minSpeed = sc.nextDouble();

        System.out.print("Enter maximum speed: ");
        double maxSpeed = sc.nextDouble();

        boolean foundCar = false;

        for (Vehicle car : cars) {
            double speed = car.getAverageSpeed();

            if (speed >= minSpeed && speed <= maxSpeed) {
                System.out.println("Car found: " + car.getBrand() + " (VIN: " + car.getVinCode() + ")");
                foundCar = true;
            }
        }

        if (!foundCar) {
            System.out.println("No cars found in the specified speed range.");
        }
    }

    public void exitAndSave(List<Vehicle> cars) {
        String filename = "C:\\Users\\danil\\OneDrive\\Робочий стіл\\Лабораторні\\Лабораторні\\ПП\\data.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Brand,TypeBody,VinCode,State1,State2,State3,AverageSpeed,UsingFuelPerDay,Price");
            writer.newLine();

            for (Vehicle car : cars) {
                StringBuilder line = new StringBuilder();
                line.append(car.getBrand()).append(",");
                line.append(car.getTypeBody()).append(",");
                line.append(car.getVinCode()).append(",");

                int[] stateOfCar = car.getStateOfCar();
                for (int i = 0; i < stateOfCar.length; i++) {
                    line.append(stateOfCar[i]);
                    if (i < stateOfCar.length - 1) {
                        line.append(",");
                    }
                }

                line.append(",").append(car.getAverageSpeed()).append(",");
                line.append(car.getUsingFuelPerDay()).append(",");
                line.append(car.getPrice());

                writer.write(line.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }

}
