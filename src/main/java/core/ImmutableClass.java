package core;

/*
 * Concept: Creating Immutable Class in Java
 * An immutable object cannot be modified after creation.
 *
 * Rules for Immutable Class:
 * 1. Declare class as final (no subclassing)
 * 2. Make all fields private and final
 * 3. No setter methods
 * 4. Return defensive copies of mutable fields (like HashMap)
 * 5. Deep copy mutable objects in constructor
 *
 * Benefits:
 * - Thread-safe without synchronization
 * - Can be cached and reused safely
 * - Good for keys in HashMap
 */
import java.util.HashMap;
import java.util.Iterator;

final class Immutable{
    private final int id;
    private final String name;
    private final HashMap<String,String> testMap;


    Immutable(int id, String name, HashMap<String, String> testMap) {
        this.id = id;
        this.name = name;
        HashMap<String, String> tempMap = new HashMap<>();
        Iterator<String> iterator = testMap.keySet().iterator();
        String key;
        while(iterator.hasNext()){
            key= iterator.next();
            tempMap.put(key,testMap.get(key));
        }
        this.testMap = testMap;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getTestMap() {
        return (HashMap<String, String>) testMap.clone();
    }
}

public class ImmutableClass {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("1","first");
        map.put("2","second");

        String name="original";
        int i=10;

        Immutable immutable = new Immutable(i, name , map);
        System.out.println("immutable id before change::"+ immutable.getId());
        System.out.println("immutable id before change::"+ immutable.getName());
        System.out.println("immutable id before change::"+ immutable.getTestMap());

        name="changed";
        i=20;

        HashMap<String,String> lastestMap = immutable.getTestMap();
        lastestMap.put("3","three");

        System.out.println("immutable id after change::"+ immutable.getId());
        System.out.println("immutable id after change::"+ immutable.getName());
        System.out.println("immutable id after change::"+ immutable.getTestMap());

    }
}
