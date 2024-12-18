// Surname:     Mhlongo
// Name:        Mnqobi
// Student no.: 4271048
// Course:      CSC211
// Year:        2024
// Assignment:  Practical 5 Term 2
// File:        PriorityQueue.java

public class PriorityQueue {
    // Attributes
    private int currentSize; // Tracks the number of elements in the priority queue
    private Node root;       // Reference to the root (not actively used here)
    private Node[] flights;  // Array to hold the nodes in a heap structure

    // Default Constructor
    public PriorityQueue() {
        this.currentSize = 0;
        this.root = null;
        this.flights = new Node[25]; // Default capacity of 25
    }

    // Parameterized Constructor
    public PriorityQueue(int initialCapacity) {
        this.flights = new Node[initialCapacity];
        this.root = null;
        this.currentSize = 0;
    }

    // Getters and Setters
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    // Clear all elements from the queue
    public void clear() {
        this.currentSize = 0;
        this.root = null;
        this.flights = new Node[this.flights.length];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    /**
     * Adds a new node to the priority queue.
     *
     * @param x The Node to be added.
     * @return true if the node was added successfully, false if the queue is full.
     * @throws IllegalStateException if the queue is full.
     */
    public boolean add(Node x) {
        if (this.currentSize >= this.flights.length) {
            throw new IllegalStateException("Priority queue is full.");
        }
        this.flights[this.currentSize] = x;
        this.currentSize++;
        percolateUp(this.currentSize - 1); // Maintain heap property
        return true;
    }

    /**
     * Removes and returns the root node (node with the earliest arrival time).
     *
     * @return The Node removed, or null if the queue is empty.
     */
    public Node remove() {
        if (this.isEmpty()) {
            return null;
        }
        Node removedNode = this.flights[0];
        this.flights[0] = this.flights[this.currentSize - 1];
        this.currentSize--;
        percolateDown(0); // Restore heap property
        return removedNode;
    }

    /**
     * Returns the root node (node with the earliest arrival time) without removing it.
     *
     * @return The root Node, or null if the queue is empty.
     */
    public Node getMin() {
        return this.isEmpty() ? null : this.flights[0];
    }

    // Heapify upwards to maintain the heap property
    private void percolateUp(int hole) {
        int parent;
        Node temp = this.flights[hole];
        while (hole > 0) {
            parent = (hole - 1) / 2;
            if (this.flights[parent].getArrival_time().compareTo(temp.getArrival_time()) > 0) {
                this.flights[hole] = this.flights[parent];
                hole = parent;
            } else {
                break;
            }
        }
        this.flights[hole] = temp;
    }

    // Heapify downwards to maintain the heap property
    private void percolateDown(int hole) {
        int child;
        Node temp = this.flights[hole];
        while (hole * 2 + 1 < this.currentSize) {
            child = hole * 2 + 1;
            if (child + 1 < this.currentSize &&
                    this.flights[child].getArrival_time().compareTo(this.flights[child + 1].getArrival_time()) > 0) {
                child++;
            }
            if (this.flights[child].getArrival_time().compareTo(temp.getArrival_time()) < 0) {
                this.flights[hole] = this.flights[child];
                hole = child;
            } else {
                break;
            }
        }
        this.flights[hole] = temp;
    }
}
