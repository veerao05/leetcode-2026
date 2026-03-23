package core;

/*
 * Concept: Deadlock in Java
 * Demonstrates a classic deadlock scenario with nested locks.
 *
 * Deadlock Conditions (all must be true):
 * 1. Mutual Exclusion - Resources cannot be shared
 * 2. Hold and Wait - Thread holds one resource while waiting for another
 * 3. No Preemption - Resources cannot be forcibly taken
 * 4. Circular Wait - Thread1 waits for Thread2, Thread2 waits for Thread1
 *
 * Scenario:
 * - Thread1: locks resource1, then tries to lock resource2
 * - Thread2: locks resource2, then tries to lock resource1
 * - Both threads wait forever → DEADLOCK
 *
 * Prevention: Always acquire locks in the same order
 */
public class DeadLockExample {
    public static void main(String[] args) {
        final String resource1 = "veena";
        final String resource2 = "vivek";
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread1 locked resource1");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException exp) {
                        System.out.println(exp.getMessage());
                    }
                    synchronized (resource2) {
                        System.out.println("Thread1 locked resource2");
                    }
                }

            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread2 locked resource2");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException exp) {
                        System.out.println(exp.getMessage());
                    }

                    synchronized (resource1) {
                        System.out.println("Thread2 locked resource1");
                    }
                }

            }
        };

        t1.start();
        t2.start();
    }
}
