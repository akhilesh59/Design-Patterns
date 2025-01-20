package StructuralDesignPattern.DecoratorPattern;

// Without Decorator Pattern
public interface Pizza {
    String getDescription();
    double getCost();
}

public class BasicPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Basic Pizza";
    }

    @Override
    public double getCost() {
        return 99.00;
    }
}

public class CheesePizza extends BasicPizza {
    @Override
    public String getDescription() {
        return super.getDescription() + ", Cheese";
    }
    @Override
    public double getCost() {
        return 149.00;
    }

}

public class CheeseMushroomPizza extends CheesePizza {
    @Override
    public String getDescription() {
        return super.getDescription() + ", Mushroom";
    }
    @Override
    public double getCost() {
        return 199.00;
    }
}

/**
 * .
 * .
 * .
 * .. and so on. We have to create many combination classes that will lead to Class explosion.
 */

public class PizzaAppWithoutDecorator {
    public static void main(String[] args) {
        Pizza pizza = new CheesePizza();
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());
        // Hard to scale and test this kind of code...
    }
}

//--------------------------------------------------------------------------------------------------------------//
