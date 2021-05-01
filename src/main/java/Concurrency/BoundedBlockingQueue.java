package main.java.Concurrency;

import java.util.LinkedList;
import java.util.List;

public class BoundedBlockingQueue {

    private volatile int capacity;
    private List<Integer> queue;


    public BoundedBlockingQueue(int capacity) {
        queue = new LinkedList();
        this.capacity = capacity;
    }

    public synchronized void enqueue(int element) throws InterruptedException {

        while (queue.size() == this.capacity) {
            wait();
        }
        this.queue.add(element);
        if (queue.size() > 0) {
            notifyAll();
        }
    }

    public synchronized int dequeue() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.capacity) {
            notifyAll();
        }
        return this.queue.remove(0);
    }

    public synchronized int size() {
        return this.queue.size();
    }
}
