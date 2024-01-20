package com.oop.lab5.producer.module;

public interface IObservable {  // >> Machine Observed by Queue
    void attachQueue(ProductQueue queue); // queue >> observer
    void notifyQueues() throws InterruptedException;
}
