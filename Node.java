// Surname:     Mhlongo
// Name:        Mnqobi
// Student no.: 4271048
// Course:      CSC211
// Year:        2024
// Assignment:  Practical 5 Term 2
// File:        Node.java

import java.util.Date;

public class Node {
    // Attributes
    private String flight_no;    // Flight number
    private Date arrival_time;   // Time at which the flight lands

    // Default Constructor
    public Node() {
        this.arrival_time = new Date();
        this.flight_no = "";
    }

    // Parameterized Constructor
    public Node(String flight_no, Date arrival_time) {
        this.arrival_time = arrival_time;
        this.flight_no = flight_no;
    }

    // Getters and Setters
    public String getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }

    public Date getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Date arrival_time) {
        this.arrival_time = arrival_time;
    }
}
