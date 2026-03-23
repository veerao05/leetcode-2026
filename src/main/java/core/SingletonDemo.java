package core;

/*
 * Design Pattern: Singleton Pattern
 * Ensures only one instance of a class exists.
 *
 * Implementations Shown:
 * 1. Eager Initialization - Instance created at class load
 * 2. Synchronized Method - Thread-safe but slow
 * 3. Double-Checked Locking - Thread-safe and efficient
 * 4. Bill Pugh (Static Holder) - Lazy, thread-safe, no synchronization
 *
 * Key Points:
 * - Private constructor prevents direct instantiation
 * - Static method provides global access point
 * - volatile keyword prevents instruction reordering
 */
class Singleton {
    private static Singleton eagerInstance = new Singleton();
    private static volatile Singleton instance;

    private Singleton() {
        System.out.println("Single instance constructor called");
    }

    public static Singleton getInstance() {
        return eagerInstance;
    }

    public static synchronized Singleton getInstance2() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static Singleton getInstance3() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    private static class SingletonHolder{
        private static final Singleton instance = new Singleton();
    }
    public static Singleton getInstance4() {
        return SingletonHolder.instance;

    }
}


public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("Eager Initialization");
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("Same instance? " + (s1 == s2));

        System.out.println("Synchronised method Initialization");
        Singleton s3 = Singleton.getInstance2();
        Singleton s4 = Singleton.getInstance2();
        System.out.println("Same instance? " + (s3 == s4));

        System.out.println("double lock method Initialization");
        Singleton s5 = Singleton.getInstance3();
        Singleton s6 = Singleton.getInstance3();
        System.out.println("Same instance? " + (s5 == s6));

        System.out.println("bull pull method Initialization");
        Singleton s7 = Singleton.getInstance4();
        Singleton s8 = Singleton.getInstance4();
        System.out.println("Same instance? " + (s7 == s8));

    }
}
