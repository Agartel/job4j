package ru.job4j.design.lsp;

public interface Parking {
    public boolean parkCar(Car car);
    public ParkingSpace[] getParkingSpaces();
    public boolean leaveParking(Car car);
}
