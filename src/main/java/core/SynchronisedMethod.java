package core;

/*
 * Concept: Synchronized Method in Java
 * Ensures only one thread executes the method at a time on same object.
 *
 * Key Points:
 * - synchronized keyword on method declaration
 * - Acquires intrinsic lock (monitor) on 'this' object
 * - Other threads wait until lock is released
 * - Prevents race conditions on shared data
 *
 * Example:
 *   Thread1 and Thread2 share same Table object
 *   Output is sequential (5x table, then 10x table)
 */
class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("table output::" + n * i);
            try {
                Thread.sleep(400);
            } catch (Exception exp) {
                System.out.println(exp.getMessage());
            }
        }

    }
}

class MyThread1 extends Thread {
    Table table;

    public MyThread1(Table table) {
        this.table = table;
    }

    public void run() {
        table.printTable(5);
    }
}

class MyThread2 extends Thread {
    Table table;

    public MyThread2(Table table) {
        this.table = table;
    }

    public void run() {
        table.printTable(10);
    }
}

public class SynchronisedMethod {
    public static void main(String[] args) {
        Table obj = new Table();
        MyThread1 myThread1 = new MyThread1(obj);
        MyThread2 myThread2 = new MyThread2(obj);

        myThread1.start();
        myThread2.start();
    }
}
