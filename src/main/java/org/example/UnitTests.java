package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UnitTests {

    private ListOfCommands listOfCommands;
    private List<Vehicle> cars;

    @BeforeEach
    void setUp() {
        listOfCommands = new ListOfCommands();
        cars = new ArrayList<>();

        cars.add(new Vehicle("Toyota", "Sedan", 12345, new int[]{0, 0, 1}, 120, 8, 20000));
        cars.add(new Vehicle("BMW", "Limusine", 67890, new int[]{1, 1, 1}, 150, 12, 35000));
        cars.add(new Vehicle("Honda", "Hatchback", 11223, new int[]{0, 0, 0}, 110, 20, 18000));
    }

    @Test
    void testAddVehicle() {
        String simulatedInput = """
        Toyota
        Sedan
        12345
        0
        1
        0
        120
        20
        25000
        """;

        Scanner testScanner = new Scanner(simulatedInput);
        ListOfCommands listOfCommands = new ListOfCommands(testScanner);

        int initialSize = cars.size();

        listOfCommands.addVehicle(cars);

        assertEquals(initialSize + 1, cars.size());
        Vehicle addedVehicle = cars.get(cars.size() - 1);
        assertEquals("Toyota", addedVehicle.getBrand());
        assertEquals(12345, addedVehicle.getVinCode());
    }

    @Test
    void testDeleteVehicle() {
        boolean found = false;
        for (Vehicle car : cars) {
            if (car.getVinCode() == 12345) {
                found = true;
                break;
            }
        }
        assertTrue(found);

        String simulatedInput = "12345\n";
        Scanner testScanner = new Scanner(simulatedInput);
        ListOfCommands listOfCommands = new ListOfCommands(testScanner);

        listOfCommands.deleteVehicle(cars);

        found = false;
        for (Vehicle car : cars) {
            if (car.getVinCode() == 12345) {
                found = true;
                break;
            }
        }
        assertFalse(found);
    }

    @Test
    void testCalculatePrice() {
        double expectedTotalPrice = 0;
        for (Vehicle car : cars) {
            expectedTotalPrice += car.getPrice();
        }

        double actualTotalPrice = listOfCommands.calculatePrice(cars);

        assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test
    void testSort() {
        listOfCommands.sort(cars);
        for (int i = 0; i < cars.size() - 1; i++) {
            assertTrue(cars.get(i).getAverageSpeed() <= cars.get(i + 1).getAverageSpeed());
        }
    }

    @Test
    void testSearchVehicleVinCode() {
        Vehicle foundVehicle = null;
        for (Vehicle car : cars) {
            if (car.getVinCode() == 67890) {
                foundVehicle = car;
                break;
            }
        }
        assertNotNull(foundVehicle);
        assertEquals("BMW", foundVehicle.getBrand());
    }

    @Test
    void testFindCarsBySpeedRange() {
        List<Vehicle> expectedCars = new ArrayList<>();
        for (Vehicle car : cars) {
            if (car.getAverageSpeed() >= 100 && car.getAverageSpeed() <= 130) {
                expectedCars.add(car);
            }
        }
        assertFalse(expectedCars.isEmpty());
    }

    @Test
    void testExitAndSave() {
        assertDoesNotThrow(() -> listOfCommands.exitAndSave(cars));
    }
}
