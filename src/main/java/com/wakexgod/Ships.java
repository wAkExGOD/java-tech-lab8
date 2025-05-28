package com.wakexgod;

// Interface for a ship
interface Ship {
    void loadCargo(double weight);
    void unloadCargo(double weight);
    void info();
}

// Class for a cargo ship
class CargoShip implements Ship {
    protected String name;
    protected double capacity;
    protected double currentCargo;

    public CargoShip(String name, double capacity) {
        this.name = name;
        this.capacity = capacity;
        this.currentCargo = 0;
    }

    @Override
    public void loadCargo(double weight) {
        if (currentCargo + weight > capacity) {
            System.out.println("Not enough space for the cargo.");
        } else {
            currentCargo += weight;
            System.out.println("Cargo loaded: " + weight + " tons.");
        }
    }

    @Override
    public void unloadCargo(double weight) {
        if (currentCargo < weight) {
            System.out.println("Not enough cargo to unload.");
        } else {
            currentCargo -= weight;
            System.out.println("Cargo unloaded: " + weight + " tons.");
        }
    }

    @Override
    public void info() {
        System.out.println("Ship: " + name + ", Current cargo: " + currentCargo + " tons, Capacity: " + capacity + " tons.");
    }
}

// Class for a tanker
class Tanker extends CargoShip {
    private double liquidVolume;

    public Tanker(String name, double capacity, double liquidVolume) {
        super(name, capacity);
        this.liquidVolume = liquidVolume;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Liquid volume: " + liquidVolume + " liters.");
    }

    public void loadLiquid(double volume) {
        if (volume > liquidVolume) {
            System.out.println("Volume exceeds tanker capacity.");
        } else {
            System.out.println("Liquid loaded: " + volume + " liters.");
        }
    }
}

public class Ships {
    public static void execute() {
        Ship cargoShip = new CargoShip("Cargo Ship 1", 1000);
        cargoShip.loadCargo(500);
        cargoShip.info();

        Ship tanker = new Tanker("Tanker 1", 800, 5000);
        tanker.loadCargo(300);
        ((Tanker) tanker).loadLiquid(4000);
        tanker.info();
    }
}



// Полиморфизм – это способность программы идентично использовать объекты с одинаковым интерфейсом без информации о конкретном типе этого объекта
