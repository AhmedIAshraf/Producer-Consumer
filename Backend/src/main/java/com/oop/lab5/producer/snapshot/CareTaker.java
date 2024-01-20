package com.oop.lab5.producer.snapshot;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> state = new ArrayList<Memento>();

    public void add (Memento memento) {
        this.state.add(memento);
    }

    public int size () {
        return this.state.size();
    }

    public void clear () {
        this.state.clear();
    }

    public Memento get (int index) {
        return this.state.get(index);
    }
}

// Must create a Memento object for every change in the system and save it

//Initialize once
//Originator originator = new Originator();
//CareTaker careTaker = new CareTaker();

//Repeat the next two lines till saving every machine and every queue
//for machines, it will save only id and color
//for queues, it will save only id and number of products
//originator.addMachine(Machine machine);
//originator.addQueue(ProductQueue queue);

//this line is used to save the state
//careTaker.add(originator.saveStateToMemento());

//After any change in machine color use the following lines
//originator.addMachine(Machine machine);
//careTaker.add(originator.saveStateToMemento());

//After any change in the number of products in queues use the following lines
//originator.addQueue(ProductQueue queue);
//careTaker.add(originator.saveStateToMemento());

//Use the following line to get how many states are saved
//careTaker.size()

//Loop from zero to the number of states to get each state
//originator.getStateFromMemento(careTaker.get(index));

//To reset the states (make a new simulation)
//originator.clear()
//careTaker.clear()