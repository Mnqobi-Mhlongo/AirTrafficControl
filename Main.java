// Surname:     Mhlongo
// Name:        Mnqobi
// Student no.: 4271048
// Course:      CSC211
// Year:        2024
// Assignment:  Practical 5 Term 2
// File:        Main.java

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        Scanner scanner = null;

        try {
            File file = new File("flights.txt"); // File must be in the program directory
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + e.getMessage());
            return; // Exit the program if file not found
        }

        // Skip header line
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        // Process each line in the file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");

            // Trim and assign fields
            String flight_no = parts[0].trim();
            String departureTimeStr = parts[1].trim();
            String flightDuration = parts[2].trim();

            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

            try {
                // Parse the departure time
                Date departureTime = sdf.parse(departureTimeStr);
                String[] durationParts = flightDuration.split(":");
                long hours = Integer.parseInt(durationParts[0]);
                long minutes = Integer.parseInt(durationParts[1]);
                long seconds = Integer.parseInt(durationParts[2]);

                // Calculate arrival time
                Date arrivalTime = new Date(
                        departureTime.getTime() +
                                (hours * 60 * 60 * 1000) +
                                (minutes * 60 * 1000) +
                                (seconds * 1000)
                );

                // Add to priority queue
                Node node = new Node(flight_no, arrivalTime);
                priorityQueue.add(node);

            } catch (ParseException e) {
                System.out.println("Error parsing date: " + e.getMessage());
            }
        }

        // Display sorted flights
        System.out.println("Order of incoming flights:");
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.remove();
            System.out.println(node.getFlight_no() + " arriving at " +
                    new SimpleDateFormat("HH:mm:ss").format(node.getArrival_time()));
        }
    }
}