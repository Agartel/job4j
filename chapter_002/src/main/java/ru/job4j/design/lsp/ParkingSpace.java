package ru.job4j.design.lsp;

public abstract class ParkingSpace {
    private int placeLong;
    private int placeWidth;
    private boolean isBusy = false;

    public ParkingSpace() {
        this.placeLong = 6;
        this.placeWidth = 2;
    }

    public int getPlaceLong() {
        return placeLong;
    }

    public int getPlaceWidth() {
        return placeWidth;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public void setPlaceLong(int placeLong) {
        this.placeLong = placeLong;
    }

    public void setPlaceWidth(int placeWidth) {
        this.placeWidth = placeWidth;
    }
}
