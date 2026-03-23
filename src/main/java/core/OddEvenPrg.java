package core;

/*
 * Concept: Print Odd-Even Numbers Using Two Threads
 * Two threads alternately print odd and even numbers.
 *
 * Key Points:
 * - Shared counter between threads
 * - synchronized block ensures mutual exclusion
 * - wait() when it's not your turn
 * - notify() to wake up the other thread
 * - Thread coordination using inter-thread communication
 *
 * Example Output:
 *   even: 0, odd: 1, even: 2, odd: 3, ...
 */
class OddEven {

    int count = 0;
    int MAX = 20;

    void printOdd() {
        synchronized (this) {
            while (count < MAX) {
                while (count % 2 == 0)
                    try {
                        wait();
                    } catch (InterruptedException exp) {
                        System.out.println(exp.getMessage());
                    }
                System.out.println("odd no is:: " + count + " ");
                count++;
                notify();
            }

        }
    }

    void printEven() {
        synchronized (this) {
            while (count < MAX) {
                while (count % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException exp) {
                        System.out.println(exp.getMessage());
                    }
                }
                System.out.println("even no is:: " + count + " ");
                count++;
                notify();
            }
        }
    }
}

public class OddEvenPrg {
    public static void main(String[] args) {
        OddEven oddEven = new OddEven();
        Thread thread1 = new Thread(oddEven::printEven);
        Thread thread2 = new Thread(oddEven::printOdd);

        thread1.start();
        thread2.start();

    }
}
