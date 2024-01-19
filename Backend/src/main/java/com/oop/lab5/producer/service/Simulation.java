package com.oop.lab5.producer.service;

import com.oop.lab5.producer.module.Machine;
import com.oop.lab5.producer.module.ProductQueue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Simulation {
    private long productID = 1;
    private long machineID = 1;
    private long queueID = 1;
    private List<Machine> machines;
    private List<ProductQueue> queues;
}
