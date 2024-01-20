package com.oop.lab5.producer.module.snapshot;

import com.oop.lab5.producer.module.Machine;
import com.oop.lab5.producer.module.ProductQueue;

import java.util.HashMap;

public class Originator {
    private HashMap<Long, String> colors = new HashMap<Long, String>(); // Machines colors
    private HashMap<Long, Integer> queues = new HashMap<Long, Integer>(); // No. of products in queues

    public void addMachine (Machine machine) {
        colors.put(machine.getId(), machine.getColor());
    }

    public void addQueue (ProductQueue queue){
        queues.put(queue.getId(), queue.getProducts().size());
    }

    public void clear () {
        this.colors.clear();
        this.queues.clear();
    }

    public HashMap<Long, String> getColors () {
        return this.colors;
    }

    public HashMap<Long, Integer> getQueues () {
        return this.queues;
    }

    public Memento saveStateToMemento () {
        return new Memento(this.colors, this.queues);
    }

    public void getStateFromMemento (Memento memento) {
        this.colors = memento.getColors();
        this.queues = memento.getQueues();
    }
}
