package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaxiPark {
    List<Vehicle> cars;
    Menu menu;
    public TaxiPark() {
        menu = new Menu();
        cars = menu.commandsList.createListOfCars();
        menu.menu(cars);
    }
}

