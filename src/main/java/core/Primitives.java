package core;

/*
 * Concept: Pass by Value in Java
 * Demonstrates how Java passes primitives and objects to methods.
 *
 * Key Points:
 * - Primitives are passed by value (copy of value)
 * - Objects are passed by reference value (copy of reference)
 * - Modifying object's fields affects original object
 * - Reassigning reference inside method doesn't affect original
 *
 * Example Output:
 *   val1 = 10 (unchanged after foo() call)
 *   obj1 = 30 (changed because we modified field)
 *   obj2 = 30 (unchanged because we reassigned reference)
 */
class MyObject {

    int val;

    MyObject(int val) {
        this.val = val;
    }
}

public class Primitives {

    public static void main(String[] args) {

        int val1 = 10;
        System.out.println(val1);
        foo(val1);
        System.out.println(val1);
        MyObject object = new MyObject(10);
        changeNonReferenceObject1(object);
        System.out.println("obj1::"+object.val);
        changeNonReferenceObject2(object);
        System.out.println("obj2::"+object.val);


    }

    private static void changeNonReferenceObject2(MyObject object) {
         object = new MyObject(50);
    }

    private static void changeNonReferenceObject1(MyObject object) {
        object.val = 30;
    }


    private static void foo(int val1) {
        val1 = 20;
    }

}









