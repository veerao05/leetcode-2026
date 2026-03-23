package core;

/*
 * Concept: Synchronized Block in Java
 * Synchronize only a portion of code instead of entire method.
 *
 * Key Points:
 * - More granular than synchronized method
 * - Can specify which object's lock to acquire
 * - synchronized(this) or synchronized(someObject)
 * - Better performance - only critical section is locked
 *
 * Advantage over Synchronized Method:
 * - Less blocking time
 * - Can use different lock objects
 * - More flexibility in lock management
 */
class AdditionTable {
    void addTable(int n) {
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println("additionTable output::" + n + i);
                try {
                    Thread.sleep(400);
                } catch (Exception exp) {
                    System.out.println(exp.getMessage());
                }
            }
        }
    }
}

class AdditionThread1 extends Thread {
    public AdditionThread1(AdditionTable table) {
        this.table = table;
    }

    AdditionTable table;

    public void run() {
        table.addTable(5);
    }
}

class AdditionThread2 extends Thread {
    AdditionTable table;

    public AdditionThread2(AdditionTable table) {
        this.table = table;
    }

    public void run() {
        table.addTable(10);
    }
}

public class SynchronisationBlock {
    public static void main(String[] args) {
        AdditionTable additionTable = new AdditionTable();
        AdditionThread1 addThread1 = new AdditionThread1(additionTable);
        AdditionThread2 addThread2 = new AdditionThread2(additionTable);
        addThread1.start();
        addThread2.start();

    }
}
