package org.example;

public class Vehicle
{
    String brand;
    String typeBody;
    int vinCode;
    int[] stateOfCar;
    double averageSpeed;
    double usingFuelPerDay;
    double price;

    public Vehicle(String brand, String typeBody, int vinCode, int[] stateOfCar, double averageSpeed, double usingFuelPerDay, double price)
    {
        this.brand = brand;
        this.typeBody = typeBody;
        this.vinCode = vinCode;
        this.stateOfCar = stateOfCar;
        this.averageSpeed = averageSpeed;
        this.usingFuelPerDay = usingFuelPerDay;
        this.price = price;
    }

    public double getPrice(){return price;}
    public String getBrand(){return brand;}
    public String getTypeBody(){return typeBody;}
    public int getVinCode(){return vinCode;}
    public int[] getStateOfCar(){return stateOfCar;}
    public double getAverageSpeed(){return averageSpeed;}
    public double getUsingFuelPerDay(){return usingFuelPerDay;}

    public void setBrand(String brand){this.brand = brand;}
    public void setTypeBody(String typeBody){this.typeBody = typeBody;}
    public void setVinCode(int vinCode){this.vinCode = vinCode;}
    public void setStateOfCar(int[] stateOfCar){this.stateOfCar = stateOfCar;}
    public void setAverageSpeed(double averageSpeed){this.averageSpeed = averageSpeed;}

}

