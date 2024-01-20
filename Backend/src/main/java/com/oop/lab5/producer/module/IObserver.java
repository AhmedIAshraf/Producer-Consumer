package com.oop.lab5.producer.module;

public interface IObserver { // >> Queue observes Machine
    void  updateState(Machine machine) throws InterruptedException;
}
