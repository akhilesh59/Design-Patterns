package CreationalDesignPattern.AbstractFactoryPattern;

// Without Abstract Factory, the client needs to instantiate classes manually.
class VictorianChair {
    public void sitOn() {
        System.out.println("Sitting on a Victorian Chair");
    }
}

class ModernChair {
    public void sitOn() {
        System.out.println("Sitting on a Modern Chair");
    }
}

public class FurnitureShowroom1 {
    public static void main(String[] args) {
        VictorianChair victorianChair = new VictorianChair();
        ModernChair modernChair = new ModernChair();

        victorianChair.sitOn();
        modernChair.sitOn();
    }
}
