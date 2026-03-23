package core;

/*
 * Design Pattern: Factory Pattern
 * Creates objects without exposing creation logic to the client.
 *
 * Key Points:
 * - Factory class encapsulates object creation
 * - Client doesn't know concrete class being instantiated
 * - Easy to add new types without modifying client code
 * - Promotes loose coupling
 *
 * Example:
 *   FactoryShape.getShape("Car") returns Car instance
 *   Client only uses Shape interface
 */
interface Shape {
    void draw();
}

class Car implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Car");

    }
}

class Bus implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Bus");
    }
}

class Bike implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Bike");
    }
}

class FactoryShape {

    Shape getShape(String shape) {
        if (shape.equals("Car")) {
            return new Car();
        } else if (shape.equals("Bike")) {
            return new Bike();
        } else if (shape.equals("Bus")) {
            return new Bus();
        }
        return null;
    }
}

public class FactoryPatternDemo {
    public static void main(String[] args) {
        FactoryShape factoryShape  = new FactoryShape();
        Shape shape = factoryShape.getShape("Car");
        shape.draw();

    }
}
