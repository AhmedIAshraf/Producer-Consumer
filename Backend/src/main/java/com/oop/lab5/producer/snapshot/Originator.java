package com.oop.lab5.producer.snapshot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oop.lab5.producer.model.Machine;
import com.oop.lab5.producer.model.ProductQueue;
import org.json.JSONObject;

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

    @Override
    public String toString() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("colors", gson.toJson(colors));
        jsonObject.put("products", gson.toJson(queues));

        return jsonObject.toString(2);
    }
}
