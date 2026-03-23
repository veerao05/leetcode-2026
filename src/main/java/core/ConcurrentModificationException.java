package core;

/*
 * Concept: Avoiding ConcurrentModificationException
 * Demonstrates safe removal of elements while iterating.
 *
 * Key Points:
 * - Use Iterator.remove() instead of List.remove() while iterating
 * - Modifying collection directly during iteration throws ConcurrentModificationException
 * - Iterator.remove() safely removes the current element
 *
 * Example:
 *   Remove element 30 from list while iterating
 *   Safe approach: itr.remove()
 *   Unsafe approach: list.remove() → throws exception
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationException {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            Integer val = itr.next();
            if (val.equals(30)) {
                itr.remove();
                System.out.println("List val::" + val);
            }
        }
    }
}
