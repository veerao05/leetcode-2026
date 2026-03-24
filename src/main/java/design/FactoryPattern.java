package design;

import java.util.Objects;

class Triangle implements Shape{


    @Override
    public void draw() {
        System.out.println("Draw traingle method");
    }
}

class Rectangle implements Shape{


    @Override
    public void draw() {
        System.out.println("Draw Rectangle method");
    }
}

class Square implements Shape{


    @Override
    public void draw() {
        System.out.println("Draw Rectangle method");
    }
}

class FactoryMethod{

    public Shape getShape(String shapeType){
        if(Objects.equals(shapeType, "triangle")){
           return new Triangle();
        }
        else if(Objects.equals(shapeType, "square")){
            return new Square();
        }
        else if(Objects.equals(shapeType, "rectangle")){
            return new Rectangle();
        }
        return  null;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        FactoryMethod factoryMethod = new FactoryMethod();
        Shape circle = factoryMethod.getShape("triangle");
        circle.draw();

        Shape rectangle = factoryMethod.getShape("rectangle");
        rectangle.draw();
    }
}
