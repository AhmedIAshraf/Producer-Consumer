package com.oop.lab5.producer.module.snapshot;

import java.util.HashMap;

public class Memento {
    private HashMap<Long, String> colors = new HashMap<Long, String>();
    private HashMap<Long, Integer> queues = new HashMap<Long, Integer>();

    public Memento (HashMap<Long, String> colors, HashMap<Long, Integer> queues){
        this.colors = colors;
        this.queues = queues;
    }

    public HashMap<Long, String> getColors () {
        return this.colors;
    }

    public HashMap<Long, Integer> getQueues () {
        return this.queues;
    } 
}
