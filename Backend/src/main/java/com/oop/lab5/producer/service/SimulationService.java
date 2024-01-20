package com.oop.lab5.producer.service;

import com.oop.lab5.producer.model.ProductQueue;

public class SimulationService {
    private SimulationService instance;

    private ProductionLineService service;

    private SimulationService() {}

    public SimulationService getInstance() {
        if (this.instance == null)
            return new SimulationService();
        return instance;
    }

    public void simulate() {
        ProductQueue outputQ = service.outputStream();
        while (outputQ.getProducts().size() < service.products.size()) {

        }
    }
}
// check that each machine is connected to at least one destination queue
// check that Q0 is the input stream