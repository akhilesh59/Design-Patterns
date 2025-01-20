package CreationalDesignPattern.FactoryMethodPattern;

// Without Factory, client code needs to know the exact class names.
/*package whatever //do not write package name here */

import java.io.*;

// Vehicle.java (interface)
public interface Vehicle {
    void drive();
}

// Car.java
public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car");
    }
}

// Bike.java
public class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike");
    }
}

// Main.java (Client code)
public class Main {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Car(); // Direct instantiation
        vehicle1.drive();

        Vehicle vehicle2 = new Bike(); // Direct instantiation
        vehicle2.drive();
    }
}

//-------------------------------------------------------------------//
//With Factory Pattern:
// Vehicle.java (interface)
public interface Vehicle {
    void drive();
}

// Car.java
public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car");
    }
}

// Bike.java
public class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike");
    }
}

// VehicleFactory.java (Factory Class)
public class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("Car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("Bike")) {
            return new Bike();
        }
        return null;
    }
}

// Main.java (Client code)
public class FactoryPattern {
    public static void main(String[] args) {
        // Using the factory to create vehicles
        Vehicle vehicle1 = VehicleFactory.getVehicle("Car");
        vehicle1.drive();

        Vehicle vehicle2 = VehicleFactory.getVehicle("Bike");
        vehicle2.drive();
    }
}

/**
 * +------------------+    +------------------+    +------------------+
 * |   Vehicle        |<---|   Car            |    |   Bike           |
 * +------------------+    +------------------+    +------------------+
 * | +drive()         |    | +drive()         |    | +drive()         |
 * +------------------+    +------------------+    +------------------+
 *
 *                     +----------------------+
 *                     |   VehicleFactory     |
 *                     +----------------------+
 *                     | +getVehicle(type)    |
 *                     +----------------------+
 *                             ^
 *                             |
 *               +----------------------------+
 *               |  FactoryProducer           |
 *               +----------------------------+
 *               | +getFactory(region)        |
 *               +----------------------------+
 */



