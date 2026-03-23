package core;

/*
 * Concept: Producer-Consumer Problem using wait() and notify()
 * Classic concurrency problem with bounded buffer.
 *
 * Key Points:
 * - Producer adds items to shared queue
 * - Consumer removes items from shared queue
 * - Use synchronized methods for thread safety
 * - wait() when queue is full (producer) or empty (consumer)
 * - notifyAll() to wake up waiting threads
 * - Use while loop (not if) for wait condition check
 *
 * Time Complexity: O(1) for enqueue/dequeue operations
 * Space Complexity: O(n) where n is queue limit
 */
import java.util.LinkedList;
import java.util.Queue;

class CustomQueue<E> {
    int limit;
    Queue<E> queue;

    CustomQueue(int limit) {
        queue = new LinkedList<>();
        this.limit = limit;
    }

    public synchronized void enQueue(E e) throws InterruptedException {
        while (queue.size() == limit) {
            System.out.println("Unable to add elements");
            wait();
        }
        queue.add(e);
        System.out.println("Element pushed::" + e);
        notifyAll();

    }

    public synchronized E deQueue() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Unable to remove elements");
            wait();
        }
        E e = queue.remove();
        System.out.println("Element removed::" + e);
        notifyAll();
        return e;

    }
}

class Producer implements Runnable {
    CustomQueue<Integer> queue;

    public Producer(CustomQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            produceItems();
        }
    }

    private void produceItems() {
        try {
            for (int i = 0; i <= 10; i++) {
                queue.enQueue(i);
                System.out.println("Item produced::" + i);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

class Consumer implements Runnable {
    CustomQueue<Integer> queue;

    public Consumer(CustomQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            int item = consumeItems();
        }
    }

    private int consumeItems() {
        int item = 0;
        try {
            item = queue.deQueue();
            System.out.println("Item removed::" + item);

        } catch (InterruptedException e) {
            System.out.println("Unable to remove element" + e.getMessage());
        }
        return item;
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        CustomQueue<Integer> queue = new CustomQueue<>(10);
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);

        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);

        Thread prodThread1 = new Thread(producer1);
        Thread prodThread2 = new Thread(producer2);

        Thread consumerThread1 = new Thread(consumer1);
        Thread consumerThread2 = new Thread(consumer2);

        prodThread1.setName("producer1");
        prodThread2.setName("producer2");

        consumerThread1.setName("consumer1");
        consumerThread2.setName("consumer2");

        prodThread1.start();
        prodThread2.start();

        consumerThread1.start();
        consumerThread2.start();

    }
}
