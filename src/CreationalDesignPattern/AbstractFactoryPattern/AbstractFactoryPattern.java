package CreationalDesignPattern.AbstractFactoryPattern;

// Without Abstract Factory, the client needs to instantiate classes manually.
// Vehicle.java (interface)
public interface Vehicle {
    void drive();
}

// USCar.java (specific vehicle type for US)
public class USCar implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car in the US");
    }
}

// USBike.java (specific vehicle type for US)
public class USBike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike in the US");
    }
}

// EUCar.java (specific vehicle type for Europe)
public class EUCar implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car in Europe");
    }
}

// EUBike.java (specific vehicle type for Europe)
public class EUBike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike in Europe");
    }
}

// Main.java (Client code)
public class Main {
    public static void main(String[] args) {
        // US Region
        Vehicle usCar = new USCar();
        usCar.drive();

        Vehicle usBike = new USBike();
        usBike.drive();

        // Europe Region
        Vehicle euCar = new EUCar();
        euCar.drive();

        Vehicle euBike = new EUBike();
        euBike.drive();
    }
}

// -----------------------------------------------------------------------------------//
// Using Abstract Factory Pattern:
// Vehicle.java (interface)
public interface Vehicle {
    void drive();
}

// Car.java (abstract product)
public interface Car extends Vehicle {
    void drive();
}

// Bike.java (abstract product)
public interface Bike extends Vehicle {
    void drive();
}

// USCar.java (concrete product for US)
public class USCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a car in the US");
    }
}

// USBike.java (concrete product for US)
public class USBike implements Bike {
    @Override
    public void drive() {
        System.out.println("Riding a bike in the US");
    }
}

// EUCar.java (concrete product for Europe)
public class EUCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a car in Europe");
    }
}

// EUBike.java (concrete product for Europe)
public class EUBike implements Bike {
    @Override
    public void drive() {
        System.out.println("Riding a bike in Europe");
    }
}

// AbstractFactory.java (Abstract Factory)
public interface AbstractFactory {
    Car createCar();
    Bike createBike();
}

// USFactory.java (Concrete Factory for US)
public class USFactory implements AbstractFactory {
    @Override
    public Car createCar() {
        return new USCar();
    }

    @Override
    public Bike createBike() {
        return new USBike();
    }
}

// EUFactory.java (Concrete Factory for Europe)
public class EUFactory implements AbstractFactory {
    @Override
    public Car createCar() {
        return new EUCar();
    }

    @Override
    public Bike createBike() {
        return new EUBike();
    }
}

// FactoryProducer.java (Factory Producer to get the correct factory)
public class FactoryProducer {
    public static AbstractFactory getFactory(String region) {
        if (region.equalsIgnoreCase("US")) {
            return new USFactory();
        } else if (region.equalsIgnoreCase("EU")) {
            return new EUFactory();
        }
        return null;
    }
}

// Main.java (Client code)
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        // Using Factory Producer to get factories
        AbstractFactory usFactory = FactoryProducer.getFactory("US");
        Vehicle usCar = usFactory.createCar();
        usCar.drive();
        Vehicle usBike = usFactory.createBike();
        usBike.drive();

        AbstractFactory euFactory = FactoryProducer.getFactory("EU");
        Vehicle euCar = euFactory.createCar();
        euCar.drive();
        Vehicle euBike = euFactory.createBike();
        euBike.drive();
    }
}

/**
 * +------------------+      +----------------+       +------------------+
 * |   Vehicle        |<-----|     Car        |<------|      USCar       |
 * +------------------+      +----------------+       +------------------+
 * | +drive()         |      | +drive()       |       | +drive()         |
 * +------------------+      +----------------+       +------------------+
 *         ^                      ^
 *         |                      |
 * +---------------+        +---------------+      +------------------+
 * |     Bike      |<------>|     USBike    |      |     USBike       |
 * +---------------+        +---------------+      +------------------+
 * | +drive()      |        | +drive()      |      | +drive()         |
 * +---------------+        +---------------+      +------------------+
 *
 *                     +---------------------------+
 *                     |   AbstractFactory         |
 *                     +---------------------------+
 *                     | +createCar()              |
 *                     | +createBike()             |
 *                     +---------------------------+
 *                             ^
 *                             |
 *           +-----------------------------------+
 *           |           ConcreteFactories      |
 *           +-----------------------------------+
 *           |   USFactory      |   EUFactory    |
 *           +-----------------------------------+
 *           | +createCar()     | +createCar()   |
 *           | +createBike()    | +createBike()  |
 *           +-----------------------------------+
 */

