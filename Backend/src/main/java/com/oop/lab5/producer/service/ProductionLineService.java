package com.oop.lab5.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oop.lab5.producer.model.Machine;
import com.oop.lab5.producer.model.Product;
import com.oop.lab5.producer.model.ProductQueue;
import com.oop.lab5.producer.snapshot.Memento;
import com.oop.lab5.producer.snapshot.Originator;
import com.oop.lab5.producer.snapshot.SnapshotDP;
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
    private SnapshotDP snapshotDP = new SnapshotDP();
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
        autoSave();
        queues.get(1L).setProducts(new LinkedList<>(products));
        machines.forEach((key,value) -> threads.add(value.process()));
    }

    public synchronized String sendStep() throws JsonProcessingException {
        JSONObject singleStep = new JSONObject();
        JSONArray colors = new JSONArray();
        JSONArray products = new JSONArray();
        machines.forEach((key, value) ->
                colors.put(new JSONObject().put("id", key).put("color", value.getColor()))
        );

        queues.forEach((key, value) ->
                products.put(new JSONObject().put("id", key).put("products", value.getProducts().size()))
        );

        singleStep.put("colors", colors);
        singleStep.put("products", products);

        System.out.println(singleStep.toString());
        return singleStep.toString();
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

    public void autoSave() { // Make snapshot << this method should be used during simulation
        System.out.println(this.queues.get(queueID - 1).getProducts().size());
        this.snapshotDP.clear();
        Originator new_originator = new Originator();

        new_originator.addQueues(new HashMap<>(this.queues));

        new_originator.addMachines(new HashMap<>(this.machines));

        new_originator.addProducts(new LinkedList<>(this.products));

        Memento memento = new_originator.saveStateToMemento();

        this.snapshotDP.getCareTaker().add(memento);
    }

    public void replay() {
        if (this.snapshotDP.getCareTaker().get().getProducts().isEmpty())
            return;

        this.queues.clear();
        this.machines.clear();
        this.products.clear();
        this.threads.clear();

        Originator originator = new Originator();
        originator.getStateFromMemento(this.snapshotDP.getCareTaker().get());
        this.queues = new HashMap<>(originator.getQueues());
        this.machines = new HashMap<>(originator.getMachines());
        this.products = new LinkedList<>(originator.getProducts());
        this.queues.get(queueID - 1).setProducts(new LinkedList<>());

        System.out.println("Start Replay");
        run();
    }

    public void clear() {
        this.queues.clear();
        this.machines.clear();
        this.products.clear();
        this.threads.clear();
        this.productID = 1;
        this.queueID = 1;
        this.machineID = 1;
    }

//    public static void main(String[] args) throws InterruptedException {
//        ProductionLineService service = ProductionLineService.getInstance();
//        service.addMachine();
//        service.addMachine();
//        service.addQueue();
//        service.addQueue();
//        service.addProducts(5);
//
//        service.connect(1,1,false);
//        service.connect(1,2,false);
//        service.connect(1,2,true);
//        service.connect(2,2,true);
//
//        service.run();
//        Thread.sleep(10000);
//        System.out.println(service.isFinished());
//        /*if (service.isFinished()) {
//            System.out.println("Replay");
//            System.out.println(service.replay());
//        }*/
//    }
}

// saving steps in order to sending them to frontend
// adding products after adding queues
// output stream not found