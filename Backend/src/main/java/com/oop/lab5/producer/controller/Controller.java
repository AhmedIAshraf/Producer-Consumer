package com.oop.lab5.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oop.lab5.producer.service.ProductionLineService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("")
@RestController
@RequestMapping("/")
public class Controller {
    private ProductionLineService service;

    public Controller(ProductionLineService service) {
        this.service = ProductionLineService.getInstance();
    }

    // We will start with adding a machine and a queue
    @PostMapping("/addItem")
    public void addItem(@RequestParam boolean isMachine) {
        if (isMachine) {
            service.addMachine();
        } else {
            service.addQueue();
        }
    }

    @PostMapping("/addProducts")
    public void addProduct(@RequestParam long number) {
        this.service.addProducts(number);
    }

    @PostMapping("/connect")
    public void connect(@RequestParam long srcID, @RequestParam long destID, @RequestParam boolean isSrcMachine) {
        service.connect(srcID, destID, isSrcMachine);
    }

    @PostMapping("/run")
    public void run() {service.run();}

    @GetMapping("/update")
    public String getUpdate() throws JsonProcessingException {return service.sendStep();}

    @PostMapping("/replay")
    public void replay() {
        service.replay();
    }

    @PostMapping("/clear")
    public void clear() { service.clear(); }
}