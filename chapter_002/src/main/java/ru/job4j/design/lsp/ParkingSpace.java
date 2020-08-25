package ru.job4j.design.lsp;

public abstract class ParkingSpace {
    private int placeLong;
    private int placeWidth;
    private Car car;

    public ParkingSpace() {
        this.placeLong = 5;
        this.placeWidth = 2;
    }

    public ParkingSpace(int placeLong, int placeWidth) {
        this.placeLong = placeLong;
        this.placeWidth = placeWidth;
    }

    public int getPlaceLong() {
        return placeLong;
    }

    public int getPlaceWidth() {
        return placeWidth;
    }

    public boolean isBusy() {
        return car == null ? false : true;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
