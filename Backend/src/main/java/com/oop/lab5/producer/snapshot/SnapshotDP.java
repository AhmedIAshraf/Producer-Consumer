package com.oop.lab5.producer.snapshot;

public class SnapshotDP {
    private CareTaker careTaker = new CareTaker();

    public CareTaker getCareTaker() {
        return careTaker;
    }

    public void setCareTaker(CareTaker careTaker) {
        this.careTaker = careTaker;
    }

    public void clear() {
        this.careTaker.clear();
    }
}
