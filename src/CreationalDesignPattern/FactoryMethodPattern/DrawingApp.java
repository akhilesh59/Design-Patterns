package CreationalDesignPattern.FactoryMethodPattern;

// Without Factory, client code needs to know the exact class names.
public class Circle {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

public class Rectangle {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

public class DrawingApp {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();

        circle.draw();
        rectangle.draw();

        // Adding a new shape requires modification in client code.
    }
}

