package com.oop.lab5.producer.service;

import com.oop.lab5.producer.model.Machine;
import com.oop.lab5.producer.model.Product;
import com.oop.lab5.producer.model.ProductQueue;
import com.oop.lab5.producer.snapshot.CareTaker;
import com.oop.lab5.producer.snapshot.Memento;
import com.oop.lab5.producer.snapshot.Originator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductionLineService {
    private long productID = 1;
    private long machineID = 1;
    private long queueID = 1;
    private HashMap<Long, Machine> machines = new HashMap<>();
    private HashMap<Long, ProductQueue> queues = new HashMap<>();
    private Queue<Product> products =  new LinkedList<>();
    private List<Thread> threads = new ArrayList<>();

    private CareTaker careTaker = new CareTaker(); // apply singleton dp for best practice

    private static ProductionLineService instance;
    private ProductionLineService() {}

    public static ProductionLineService getInstance() {
        if(instance == null){
            instance = new ProductionLineService();
        }
        return instance;
    }

    public long productsNo() {
        return (this.productID - 1);
    }

    public void run(){
        careTaker.clear();
        queues.get((long)1).setProducts(products);
        machines.forEach((key,value) -> threads.add(value.process()));
    }

    public void addProducts(long number) {
        while (number > 0) {
            Product p = new Product(this.productID++);
            this.products.add(p);
            number--;
        }
    }

    public void addMachine() {
        Machine m = new Machine(this.machineID);
        this.machines.put(this.machineID++, m);
        System.out.println("mID " + this.machineID);
    }

    public void addQueue() {
        ProductQueue q = new ProductQueue(this.queueID);
        this.queues.put(this.queueID++, q);
        System.out.println("qID " + this.queueID);
    }

    public void connect(long srcID, long destID, boolean isSrcMachine) {
        if (isSrcMachine) {
            Machine srcM = this.machines.get(srcID);
            ProductQueue destQ = this.queues.get(destID);
            srcM.setDestQueue(destQ);
        }else {
            Machine destM = this.machines.get(destID);
            ProductQueue srcQ = this.queues.get(srcID);
            destM.attachQueue(srcQ);
        }
    }

    public ProductQueue outputStream() {
        for (ProductQueue q : this.queues.values()) {
            if (q.getConnectedMachines().isEmpty())
                return q;
        }
        return null;
    }

    public boolean isFinished() {
        return outputStream().getProducts().size() == productsNo();
    }

    public synchronized void autoSave() { // Make snapshot << this method should be used during simulation
        Originator new_originator = new Originator();

        for (ProductQueue q : this.queues.values())
            new_originator.addQueue(q);

        for (Machine m : this.machines.values())
            new_originator.addMachine(m);

        Memento memento = new_originator.saveStateToMemento();

        careTaker.add(memento);
        System.out.println("State data:");
        System.out.println(new_originator.toString());
    }

    public String replay() {
        Originator originator = new Originator();
        int step = 0;
        System.out.println(careTaker.size());
        JSONObject stepStatusJson = new JSONObject();

        while (step < careTaker.size()) {
            JSONArray colors = new JSONArray();
            JSONArray qProducts = new JSONArray();
            originator.getStateFromMemento(careTaker.get(step++));

            originator.getColors().forEach((key, value) ->
                    colors.put(new JSONObject().put("id", key).put("color", value))
            );

            originator.getQueues().forEach((key, value) ->
                    qProducts.put(new JSONObject().put("id", key).put("products", value))
            );
//            System.out.println(colors.toString(2));
//            System.out.println(qProducts.toString(2));
            stepStatusJson.accumulate("colors", colors);
            stepStatusJson.accumulate("products", qProducts);

//            System.out.println(stepStatusJson.toString());
        }

        return stepStatusJson.toString(2);
    }

//    public void board() {
//        System.out.println("Queues");
//        for (long i = 1; i < this.queues.size() + 1; ++i) {
//            System.out.println(queues.get(i).toString());
//        }
//
//        System.out.println("Machines");
//        for (long i = 1; i < this.machines.size() + 1; ++i) {
//            System.out.println(machines.get(i).toString());
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
        ProductionLineService service = ProductionLineService.getInstance();
        service.addMachine();
        service.addMachine();
        service.addQueue();
        service.addQueue();
        service.addProducts(5);

        service.connect(1,1,false);
        service.connect(1,2,false);
        service.connect(1,2,true);
        service.connect(2,2,true);

        service.run();
        Thread.sleep(10000);
        System.out.println(service.isFinished());
        if (service.isFinished()) {
            System.out.println("Replay");
            System.out.println(service.replay());
        }
    }
}

// saving steps in order to sending them to frontend
// adding products after adding queues
/*
while(true) {
    djhnvfsksdfc





    autosave();
}
 */