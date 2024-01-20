package com.oop.lab5.producer.observer;

import com.oop.lab5.producer.model.ProductQueue;

public interface IObservable {  // >> Machine Observed by Queue
    void attachQueue(ProductQueue queue); // queue >> observer
    void notifyQueues() throws InterruptedException;
}
