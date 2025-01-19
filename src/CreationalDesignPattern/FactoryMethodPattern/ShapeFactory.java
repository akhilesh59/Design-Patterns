package CreationalDesignPattern.FactoryMethodPattern;

// Factory Pattern centralizes object creation.
abstract class Shape {
    public abstract void draw();
}

class Circle extends Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle extends Shape {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class ShapeFactory {
    public static Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }
}

public class DrawingApp {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape("CIRCLE");
        Shape rectangle = ShapeFactory.getShape("RECTANGLE");

        circle.draw();
        rectangle.draw();

        // Adding new shapes is easier without modifying client code.
    }
}

