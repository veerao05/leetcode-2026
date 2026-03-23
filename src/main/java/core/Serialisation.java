package core;

/*
 * Concept: Java Serialization and Deserialization
 * Demonstrates how to serialize objects to files and deserialize them back.
 *
 * Key Points:
 * - transient fields are NOT serialized (b becomes null)
 * - static fields are NOT serialized (c retains current value)
 * - final fields ARE serialized (d is restored)
 * - Non-serializable parent needs no-arg constructor for deserialization
 * - Parent's fields are re-initialized via no-arg constructor
 *
 * Time Complexity: O(n) where n is object graph size
 * Space Complexity: O(n) for serialized data
 */
import java.io.*;

class Parent {
    public int x;

    public Parent() {
        x = 10;
        System.out.println("Parent Constructor Called");
    }
    public Parent(int x){
        this.x=x;
        System.out.println("Parent para-Constructor Called");
    }
}

class Demo extends Parent implements Serializable {
    public int a;
    public transient String b;
    public static int c = 100;
    public final int d;

    public Demo(int a, String val, int d) {
        this.a = a;
        this.b = val;
        this.d = d;
    }
}

public class Serialisation {
    public static void main(String[] args) {
        Demo demo = new Demo(10, "hello", 90);
        try {

            System.out.println("Before serialisation a::" + demo.a);
            System.out.println("Before serialisation b::" + demo.b);
            System.out.println("Before serialisation c::" + Demo.c);
            System.out.println("Before serialisation d::" + demo.d);
            System.out.println("Before serialisation x::" + demo.x);
            Demo.c=200;
            FileOutputStream fs = new FileOutputStream("serial.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(demo);
            os.close();


            FileInputStream fis = new FileInputStream("serial.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Demo demo1 = (Demo) ois.readObject();
            System.out.println("After deserialisation a::" + demo1.a);
            System.out.println("After deserialisation b::" + demo1.b);
            System.out.println("After deserialisation c::" + Demo.c);
            System.out.println("After deserialisation d::" + demo1.d);
            System.out.println("After deserialisation x::" + demo.x);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
