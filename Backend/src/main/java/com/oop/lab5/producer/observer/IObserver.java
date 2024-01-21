package com.oop.lab5.producer.observer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oop.lab5.producer.model.Machine;

public interface IObserver { // >> Queue observes Machine
    void  updateState(Machine machine) throws InterruptedException, JsonProcessingException;
}
