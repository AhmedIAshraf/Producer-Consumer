package com.oop.lab5.producer.snapshot;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private Memento currentMemento = new Memento();

    public void addMemento(Memento memento) {
        this.currentMemento = memento;
    }

    public void clearMemento() {
        this.currentMemento = new Memento();
    }

    public Memento getCurrentMemento() {
        return this.currentMemento;
    }
}