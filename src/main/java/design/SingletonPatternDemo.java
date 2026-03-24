package design;

// 1. EAGER INITIALIZATION SINGLETON
class EagerInitializationSingleton {
    private static final EagerInitializationSingleton instance = new EagerInitializationSingleton();

    private EagerInitializationSingleton() {
    }

    public static EagerInitializationSingleton getInstance() {
        return instance;
    }
}

// 2. STATIC BLOCK INITIALIZATION SINGLETON
class StaticBlockSingleton {

    private static final StaticBlockSingleton instance;

    static {
        instance = new StaticBlockSingleton();
    }

    private StaticBlockSingleton() {
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }

}


// 3. LAZY INITIALIZATION SINGLETON (NOT THREAD SAFE)
class LazyInitializationSingleton {

    private static LazyInitializationSingleton instance;

    private LazyInitializationSingleton() {
    }

    public static LazyInitializationSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializationSingleton();
        }
        return instance;
    }

}
// 4. THREAD SAFE SINGLETON (SYNCHRONIZED METHOD)

class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }


    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

}


// 5. DOUBLE-CHECKED LOCKING SINGLETON
class DoubleCheckedLockingSingleton {

    private static DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {
    }


    public static DoubleCheckedLockingSingleton getInstance() {

        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }

        }
        return instance;
    }

}


//6. BILL PUGH SINGLETON (RECOMMENDED)
class BillPughSingleton {
    private BillPughSingleton() {

    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BillPughSingleton instance = new BillPughSingleton();

    }
}

public class SingletonPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== SINGLETON PATTERN IMPLEMENTATIONS ===\n");
        // 1. Eager Initialization
        EagerInitializationSingleton eager1 = EagerInitializationSingleton.getInstance();
        EagerInitializationSingleton eager2 = EagerInitializationSingleton.getInstance();
        System.out.println("Eager Initialization - Same instance: " + (eager1 == eager2));



        // 2. Static Block
        StaticBlockSingleton static1 = StaticBlockSingleton.getInstance();
        StaticBlockSingleton static2 = StaticBlockSingleton.getInstance();
        System.out.println("Static Block - Same instance: " + (static1 == static2));

        // 3. Lazy Initialization (Not thread-safe)
        LazyInitializationSingleton lazy1 = LazyInitializationSingleton.getInstance();
        LazyInitializationSingleton lazy2 = LazyInitializationSingleton.getInstance();
        System.out.println("Lazy Initialization - Same instance: " + (lazy1 == lazy2));

        // 4. Thread Safe
        ThreadSafeSingleton threadSafe1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton threadSafe2 = ThreadSafeSingleton.getInstance();
        System.out.println("Thread Safe - Same instance: " + (threadSafe1 == threadSafe2));

        // 5. Double-Checked Locking
        DoubleCheckedLockingSingleton dcl1 = DoubleCheckedLockingSingleton.getInstance();
        DoubleCheckedLockingSingleton dcl2 = DoubleCheckedLockingSingleton.getInstance();
        System.out.println("Double-Checked Locking - Same instance: " + (dcl1 == dcl2));

        // 6. Bill Pugh
        BillPughSingleton billPugh1 = BillPughSingleton.getInstance();
        BillPughSingleton billPugh2 = BillPughSingleton.getInstance();
        System.out.println("Bill Pugh - Same instance: " + (billPugh1 == billPugh2));


    }
}
