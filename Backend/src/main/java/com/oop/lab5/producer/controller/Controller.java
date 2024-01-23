package com.oop.lab5.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oop.lab5.producer.service.ProductionLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:8081")
@RestController
@RequestMapping("/")
public class Controller {
    @Autowired
    private ProductionLineService service = ProductionLineService.getInstance();

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
        System.out.println(number);
    }

    @PostMapping("/connect")
    public void connect(@RequestParam long srcID, @RequestParam long destID, @RequestParam boolean isSrcMachine) {
        service.connect(srcID, destID, isSrcMachine);
    }

    @PostMapping("/run")
    public void run() {service.run();}

    @GetMapping("/update")
    public String getUpdate() throws JsonProcessingException {return service.sendStep();}

    @GetMapping("/replay")
    public ResponseEntity<Boolean> replay() {
        boolean success = service.replay();
        return ResponseEntity.ok(success);
    }

    @PostMapping("/clear")
    public void clear() { service.clear(); }
}