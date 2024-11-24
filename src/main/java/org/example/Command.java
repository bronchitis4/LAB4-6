package org.example;

import java.util.List;

public interface Command {
    public void execute(List<Vehicle> cars);
    void undo();
}

class CreateListOfCars implements Command
{
    ListOfCommands listOfCommands;
    public CreateListOfCars(ListOfCommands listOfCommands)
    {
        this.listOfCommands = listOfCommands;
    }

    @Override
    public void execute(List<Vehicle> cars)
    {
        listOfCommands.createListOfCars();
    }

    @Override
    public void undo()
    {

    }
}

class AddVehicle implements Command
{
    ListOfCommands listOfCommands;
    public AddVehicle(ListOfCommands listOfCommands)
    {
        this.listOfCommands = listOfCommands;
    }

    @Override
    public void execute(List<Vehicle> cars)
    {
        listOfCommands.addVehicle(cars);
    }

    @Override
    public void undo()
    {

    }
}

class DeleteVehicle implements Command
{
    ListOfCommands listOfCommands;
    public DeleteVehicle(ListOfCommands listOfCommands)
    {
        this.listOfCommands = listOfCommands;
    }

    @Override
    public void execute(List<Vehicle> cars)
    {
        listOfCommands.deleteVehicle(cars);
    }

    @Override
    public void undo()
    {

    }
}

class CalculatePriceOfAllParts implements Command
{
    ListOfCommands listOfCommands;
    public CalculatePriceOfAllParts(ListOfCommands listOfCommands)
    {
        this.listOfCommands = listOfCommands;
    }

    @Override
    public void execute(List<Vehicle> cars)
    {
        listOfCommands.calculatePrice(cars);
    }

    @Override
    public void undo()
    {

    }
}

class Sort implements Command
{
    ListOfCommands listOfCommands;
    public Sort(ListOfCommands listOfCommands)
    {
        this.listOfCommands = listOfCommands;
    }

    @Override
    public void execute(List<Vehicle> cars)
    {
        listOfCommands.sort(cars);
    }

    @Override
    public void undo()
    {

    }
}

class SearchVehicleVinCode implements Command
{
    ListOfCommands listOfCommands;
    public SearchVehicleVinCode(ListOfCommands listOfCommands)
    {
        this.listOfCommands = listOfCommands;
    }

    @Override
    public void execute(List<Vehicle> cars)
    {
        listOfCommands.searchVehicleVinCode(cars);
    }

    @Override
    public void undo()
    {

    }
}
class ReviewTechnicalStateOfCars implements  Command
{
    ListOfCommands listOfCommands;
    public ReviewTechnicalStateOfCars(ListOfCommands listOfCommands)
    {
        this.listOfCommands = listOfCommands;
    }

    @Override
    public void execute(List<Vehicle> cars)
    {
        listOfCommands.reviewTechnicalStateOfCars(cars);
    }

    public void undo()
    {

    }
}

class SendVehicleToRepairStation implements Command
{
    ListOfCommands listOfCommands;
    public SendVehicleToRepairStation(ListOfCommands listOfCommands)
    {
        this.listOfCommands = listOfCommands;
    }

    @Override
    public void execute(List<Vehicle> cars)
    {
        listOfCommands.sendVehicleToRepairStation(cars);
    }

    @Override
    public void undo()
    {

    }
}

class FindCarsBySpeedRange implements Command
{
    ListOfCommands listOfCommands;
    public FindCarsBySpeedRange(ListOfCommands listOfCommands)
    {
        this.listOfCommands = listOfCommands;
    }

    @Override
    public void execute(List<Vehicle> cars)
    {
        listOfCommands.findCarsBySpeedRange(cars);
    }

    @Override
    public void undo()
    {

    }
}



class ExitAndSave implements Command
{
    ListOfCommands listOfCommands;
    public ExitAndSave(ListOfCommands listOfCommands)
    {
        this.listOfCommands = listOfCommands;
    }

    @Override
    public void execute(List<Vehicle> cars)
    {
        listOfCommands.exitAndSave(cars);
    }

    @Override
    public void undo()
    {

    }
}



