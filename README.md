# Air Traffic Control System

This project is an implementation of an air traffic control system using a **priority queue** to manage flight arrival schedules based on their landing times. It was written in Java for CSC211, Practical 5 Term 2, 2024.

---

## Features

- **Priority Queue Implementation**: Manages flights by prioritizing the earliest arrival times.
- **Heap-Based Min-Heap Structure**: Ensures efficient insertion and removal of flights.
- **Custom Node Class**: Stores flight information such as flight number and arrival time.
- **File Input**: Reads flight data from an external file (`flights.txt`).

---

## How It Works

1. **Input**: The program reads flight data from `flights.txt`. Each line in the file contains:
   - Flight number
   - Departure time (in `HH:mm:ss` format)
   - Flight duration (in `HH:mm:ss` format)

   Example:ZA2951,23:40:10,8:05:41
2. **Processing**:
- The program calculates the **arrival time** by adding the flight duration to the departure time.
- Flights are stored in a **priority queue** (min-heap) based on their arrival times.

3. **Output**:
- Flights are printed in the order of their arrival times.

Example: Order of incoming flights: Order of incoming flights:
ZA5348 arriving at 09:23:01

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/AirTrafficControl.git
   cd AirTrafficControl/src
