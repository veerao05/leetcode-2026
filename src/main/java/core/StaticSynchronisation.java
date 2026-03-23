package core;

/*
 * Concept: Static Synchronization in Java
 * Synchronization on class-level lock (not object-level).
 *
 * Key Points:
 * - synchronized static method acquires class-level lock
 * - All instances share the same lock
 * - Only one thread can execute ANY static synchronized method
 * - Useful when static resources need protection
 *
 * Difference from Instance Synchronization:
 * - Instance: lock on 'this' object
 * - Static: lock on Class object (ClassName.class)
 */
class MultiplyTable {
    synchronized static void multiplyTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("mulitiplyTable output::" + n * i);
            try {
                Thread.sleep(400);
            } catch (Exception exp) {
                System.out.println(exp.getMessage());
            }
        }

    }
}

class MyThread3 extends Thread {
    public void run() {
        MultiplyTable.multiplyTable(5);
    }
}

class MyThread4 extends Thread {
    public void run() {
        MultiplyTable.multiplyTable(10);
    }
}

public class StaticSynchronisation {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        MyThread4 myThread4 = new MyThread4();

        myThread3.start();
        myThread4.start();

    }
}
