package ru.job4j.design.lsp;

public class SimpleParking implements Parking {

    private final ParkingSpace[] simpleSpace;
    private final ParkingSpace[] heavySpace;
    private int carPosition = 0;
    private int carHeavyPosition = 0;

    public SimpleParking(int simpeSpaces, int heavySpaces) {
        this.simpleSpace = new SimpleParkingSpace[simpeSpaces];
        this.heavySpace = new HeavyParkingSpace[heavySpaces];
    }

    @Override
    public boolean parkCar(Car car) {
        return false;
    }
}
