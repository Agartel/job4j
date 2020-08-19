package ru.job4j.design.lsp;

public class Parking {

    private final Car[] cars;
    private final Car[] heavycars;
    private int carcurpos = 0;
    private int carheavycurpos = 0;

    public Parking(int carsccount, int carsheavyccount) {
        this.cars = new Car[carsccount];
        this.heavycars = new Car[carsheavyccount];
    }

    public void parkCar(Car car) {

    }
}
