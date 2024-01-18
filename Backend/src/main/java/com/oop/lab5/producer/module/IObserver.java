package com.oop.lab5.producer.module;

public interface IObserver { // >> Queue observes Machine
    void  updateMachineState(Machine machine);
}
