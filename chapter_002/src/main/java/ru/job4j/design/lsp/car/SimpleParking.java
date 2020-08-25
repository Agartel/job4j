package ru.job4j.design.lsp.car;

import java.util.ArrayList;
import java.util.List;

public class SimpleParking implements Parking {

    private final ParkingSpace[] simpleSpace;
    private final ParkingSpace[] heavySpace;

    public SimpleParking(int simpeSpaces, int heavySpaces) {
        this.simpleSpace = new SimpleParkingSpace[simpeSpaces];
        for (int i = 0;  i < this.simpleSpace.length; i++) {
            this.simpleSpace[i] = new SimpleParkingSpace();
        }
        this.heavySpace = new HeavyParkingSpace[heavySpaces];
        for (int i = 0;  i < this.heavySpace.length; i++) {
            this.heavySpace[i] = new HeavyParkingSpace(10, 4);
        }
    }

    private ParkingSpace findFreeSpace(ParkingSpace[] spaces) {
        ParkingSpace freeSpace = null;
        for (int i = 0;  i < spaces.length; i++) {
            if  (spaces[i].isBusy()) {
                continue;
            }
            freeSpace = spaces[i];
            break;
        }
        return freeSpace;
    }

    @Override
    public boolean parkCar(Car car) {
         if (car instanceof HeavyCar) {
             ParkingSpace freeSpace = findFreeSpace(heavySpace);
             if (freeSpace != null) {
                 freeSpace.setCar(car);
                 return true;
             }

            List<ParkingSpace> seqFreeSpaces = new ArrayList<>();
            double square = 0;
            for (int i = 0; i < simpleSpace.length; i++) {
                if (simpleSpace[i].isBusy()) {
                    seqFreeSpaces.clear();
                    square = 0;
                    continue;
                }
                seqFreeSpaces.add(simpleSpace[i]);
                square = square + simpleSpace[i].getPlaceLong() * simpleSpace[i].getPlaceWidth();
                if (square >= car.getLength() * car.getWeight()) {
                    for (ParkingSpace oneOfSpaces : seqFreeSpaces) {
                        oneOfSpaces.setCar(car);
                    }
                    return true;
                }
            }
            return false;
        } else {
             ParkingSpace freeSpace = findFreeSpace(simpleSpace);
             if (freeSpace != null) {
                 freeSpace.setCar(car);
                 return true;
             }
             return false;
         }
    }

    @Override
    public ParkingSpace[] getParkingSpaces() {
        ParkingSpace[] result = new ParkingSpace[simpleSpace.length + heavySpace.length];
        System.arraycopy(simpleSpace, 0, result, 0, simpleSpace.length);
        System.arraycopy(heavySpace, 0, result, simpleSpace.length, heavySpace.length);
        return result;
    }

    private boolean remainSpaces(ParkingSpace[] spaces, Car car) {
        boolean success = false;
        for (int i = 0;  i < spaces.length; i++) {
            if (spaces[i].getCar() != null && spaces[i].getCar().equals(car)) {
                spaces[i].setCar(null);
                success = true;
            }
        }
        return success;
    }

    @Override
    public boolean leaveParking(Car car) {
        boolean res1, res2 = false;
        res1 = remainSpaces(this.simpleSpace, car);
        res2 = remainSpaces(this.heavySpace, car);
        return res1 && res2;
    }
}
