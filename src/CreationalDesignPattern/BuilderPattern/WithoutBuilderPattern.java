package CreationalDesignPattern.BuilderPattern;

// House.java (Product)
public class House {
    private String foundation;
    private String structure;
    private String roof;
    private String windows;
    private String doors;

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void setWindows(String windows) {
        this.windows = windows;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "House with " + foundation + " foundation, " + structure + " structure, " +
                roof + " roof, " + windows + " windows, and " + doors + " doors.";
    }
}

// Main.java (Client code)
public class WithoutBuilderPattern {
    public static void main(String[] args) {
        // Building a house manually without a builder
        House house = new House();
        house.setFoundation("Concrete");
        house.setStructure("Wooden");
        house.setRoof("Shingle");
        house.setWindows("Double-glazed");
        house.setDoors("Wooden doors");

        System.out.println(house);
    }
}
