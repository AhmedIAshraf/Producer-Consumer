# Producer-Consumer Simulation

## Description

An assembly line that produces different products consists of various processing machines (M) responsible for processing products at different stages and queues (Q) to handle product movement between processing stages. This assignment aims to develop a simulation program representing this production line as a queuing network.

## Requirements

### Key Features

1. **Graphical Configuration:**
   - Users can graphically add queues (Q) and processing machines (M).
   - Machines and queues can be arbitrarily connected via a user interface (UI).

2. **Random Input Rate:**
   - Products arrive at the initial queue (Q0) with a random input rate.

3. **Random Service Time:**
   - Each processing machine (M) has a random service time to process one product at a time.
   - Upon completion, a machine checks the queue to determine if waiting products need processing.
   - If no waiting products, the machine registers itself as ready (Observer Design Pattern).

4. **Multithreading:**
   - Each machine runs on a separate thread for parallel processing.
   - The UI displays real-time information on the number of elements in queues.

5. **Visual Representation:**
   - Machines flash when they finish servicing a product.
   - Each product has a unique color, and machines change their color to match the product being processed.
   - Colors revert to default once processing is complete for easy user tracking.

6. **Simulation End Options:**
   - After the simulation ends, users can initiate a new simulation or replay the previous one (Snapshot Design Pattern).

7. **Simplified Random Generation:**
   - The system uses a simplified approach for random generation, avoiding complex distributions.

8. **Queue Overflow Handling:**
   - Queues do not overflow for simplicity in simulation.

## Visual Representation

[Video](https://youtu.be/sH7EUyh7pes)

![Producer Consumer - Machine and Queue Configuration](https://github.com/Saifullah-1/Producer-Consumer/blob/master/Producer.jpg)

## Class Diagram

![Producer Consumer - Test Case](https://github.com/Saifullah-1/Producer-Consumer/blob/master/UML.png)

## [Link to Report](https://github.com/Saifullah-1/Producer-Consumer/blob/master/ProducerConsumerReport.pdf)

