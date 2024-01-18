package com.oop.lab5.producer.controller;

import com.oop.lab5.producer.service.Simulation;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("")
@RestController
@RequestMapping("/")
public class Controller {
    private Simulation simulator;

    public Controller(Simulation simulator) {
        this.simulator = simulator;
    }

    // We will start with adding a machine and a queue
    @PostMapping("/addItem")
    public void addItem(@RequestParam boolean isMachine) {
        if (isMachine) {
            // create a machine
        } else {
            // create a queue
        }
    }

    @GetMapping("/deleteItem")
    public String deleteItem(@RequestParam long id, @RequestParam boolean isMachine) {
        if (isMachine) {
            // remove the machine
        } else {
            // remove the queue
        }
        // return all the data >> konva board
    }

    @PostMapping("/connect")
    public void connect(@RequestParam long srcID, @RequestParam long distID, @RequestParam boolean isMachine, @RequestParam boolean isQueue) {

    }

    @GetMapping("/run")
    public String run() {

    }

}
