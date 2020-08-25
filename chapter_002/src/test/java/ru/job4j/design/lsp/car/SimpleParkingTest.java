package ru.job4j.design.lsp.car;

import static org.hamcrest.core.Is.is;
import org.junit.Test;
import ru.job4j.design.lsp.car.*;

import static org.junit.Assert.*;

public class SimpleParkingTest {

    @Test
    public void whenThereAreTwoLightSpaceThenNotMoreThanTwoLightCarCanParking() {
        Car car1 = new LightCar(1, 4, 2);
        Car car2 = new LightCar(2, 4, 2);
        Car car3 = new LightCar(3, 4, 2);
        Parking parking = new SimpleParking(2, 0);
        parking.parkCar(car1);
        parking.parkCar(car2);
        boolean parkCCar3 = parking.parkCar(car3);
        ParkingSpace[] parkingSpace = parking.getParkingSpaces();
        assertEquals(parkingSpace[0].getCar(), car1);
        assertEquals(parkingSpace[1].getCar(), car2);
        assertFalse(parkCCar3);
        assertThat(parkingSpace.length, is(2));
    }

    @Test
    public void whenThereAreTwoHeavySpaceSpacesAndThereAreNotLightSpacesThenNotMoreThanTwoHeavyCarCanParking() {
        Car car1 = new HeavyCar(1, 8, 4);
        Car car2 = new HeavyCar(2, 8, 4);
        Car car3 = new HeavyCar(3, 8, 4);
        Parking parking = new SimpleParking(0, 2);
        parking.parkCar(car1);
        parking.parkCar(car2);
        parking.parkCar(car3);
        boolean parkCCar3 = parking.parkCar(car3);
        ParkingSpace[] parkingSpace = parking.getParkingSpaces();
        assertEquals(parkingSpace[0].getCar(), car1);
        assertEquals(parkingSpace[1].getCar(), car2);
        assertFalse(parkCCar3);
        assertThat(parkingSpace.length, is(2));
    }

    @Test
    public void whenHeavySpacesIsBusyTryBusy3LightSpaces() {
        Car car1 = new HeavyCar(1, 8, 3);
        Car car2 = new HeavyCar(2, 8, 3);
        Parking parking = new SimpleParking(3, 1);
        parking.parkCar(car1);
        parking.parkCar(car2);
        ParkingSpace[] parkingSpace = parking.getParkingSpaces();
        assertEquals(parkingSpace[0].getCar(), car2);
        assertEquals(parkingSpace[1].getCar(), car2);
        assertEquals(parkingSpace[2].getCar(), car2);
        assertEquals(parkingSpace[3].getCar(), car1);
        assertThat(parkingSpace.length, is(4));
    }

    @Test
    public void whenHeavySpacesIsBusyTryBusy2LightSpaces() {
        Car car1 = new HeavyCar(1, 6, 3);
        Car car2 = new HeavyCar(2, 6, 3);
        Parking parking = new SimpleParking(3, 1);
        parking.parkCar(car1);
        parking.parkCar(car2);
        ParkingSpace[] parkingSpace = parking.getParkingSpaces();
        assertEquals(parkingSpace[0].getCar(), car2);
        assertEquals(parkingSpace[1].getCar(), car2);
        assertNull(parkingSpace[2].getCar());
        assertEquals(parkingSpace[3].getCar(), car1);
        assertThat(parkingSpace.length, is(4));
    }

    @Test
    public void whenHeavySpacesIsBusyTryHeavyCarParkBetweenNoBusyLightSpaces() {
        Car car1 = new LightCar(1, 4, 2);
        Car car2 = new LightCar(2, 4, 2);
        Car car3 = new LightCar(1, 4, 2);
        Car car4 = new LightCar(2, 4, 2);
        Car car5 = new LightCar(1, 4, 2);
        Car car6 = new LightCar(2, 4, 2);
        Car car7 = new LightCar(1, 4, 2);
        Car car8 = new LightCar(2, 4, 2);
        Car car9 = new LightCar(1, 4, 2);
        Car car10 = new LightCar(2, 4, 2);
        Car car11 = new LightCar(1, 4, 2);
        Car car12 = new LightCar(1, 4, 2);
        Parking parking = new SimpleParking(12, 0);
        parking.parkCar(car1);
        parking.parkCar(car2);
        parking.parkCar(car3);
        parking.parkCar(car4);
        parking.parkCar(car5);
        parking.parkCar(car6);
        parking.parkCar(car7);
        parking.parkCar(car8);
        parking.parkCar(car9);
        parking.parkCar(car10);
        parking.parkCar(car11);
        parking.parkCar(car12);
        parking.leaveParking(car3);
        parking.leaveParking(car4);
        parking.leaveParking(car5);
        parking.leaveParking(car7);
        parking.leaveParking(car8);
        parking.leaveParking(car9);
        parking.leaveParking(car11);
        parking.leaveParking(car12);
        Car car345 = new HeavyCar(1, 8, 3);
        Car car789 = new HeavyCar(2, 8, 3);
        Car car101112 = new HeavyCar(2, 8, 3);
        parking.parkCar(car345);
        parking.parkCar(car789);
        parking.parkCar(car101112);
        ParkingSpace[] parkingSpace = parking.getParkingSpaces();
        assertEquals(parkingSpace[0].getCar(), car1);
        assertEquals(parkingSpace[1].getCar(), car2);
        assertEquals(parkingSpace[2].getCar(), car345);
        assertEquals(parkingSpace[3].getCar(), car345);
        assertEquals(parkingSpace[4].getCar(), car345);
        assertEquals(parkingSpace[5].getCar(), car6);
        assertEquals(parkingSpace[6].getCar(), car789);
        assertEquals(parkingSpace[7].getCar(), car789);
        assertEquals(parkingSpace[8].getCar(), car789);
        assertEquals(parkingSpace[9].getCar(), car10);
        assertNull(parkingSpace[10].getCar());
        assertNull(parkingSpace[11].getCar());
        assertThat(parkingSpace.length, is(12));
    }
}