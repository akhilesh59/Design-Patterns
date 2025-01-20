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

// HouseBuilder.java (Builder)
public class HouseBuilder {
    private House house;

    public HouseBuilder() {
        this.house = new House();
    }

    public HouseBuilder buildFoundation(String foundation) {
        house.setFoundation(foundation);
        return this;
    }

    public HouseBuilder buildStructure(String structure) {
        house.setStructure(structure);
        return this;
    }

    public HouseBuilder buildRoof(String roof) {
        house.setRoof(roof);
        return this;
    }

    public HouseBuilder buildWindows(String windows) {
        house.setWindows(windows);
        return this;
    }

    public HouseBuilder buildDoors(String doors) {
        house.setDoors(doors);
        return this;
    }

    public House build() {
        return house;
    }
}

// Main.java (Client code)
public class WithBuilderPattern {
    public static void main(String[] args) {
        // Using the builder to create a house with desired features
        HouseBuilder builder = new HouseBuilder();

        House house1 = builder.buildFoundation("Concrete")
                .buildStructure("Wooden")
                .buildRoof("Shingle")
                .buildWindows("Double-glazed")
                .buildDoors("Wooden doors")
                .build();

        System.out.println(house1);

        // Building another house with a different combination
        House house2 = builder.buildFoundation("Brick")
                .buildStructure("Stone")
                .buildRoof("Tile")
                .buildWindows("Single-glazed")
                .buildDoors("Metal doors")
                .build();

        System.out.println(house2);
    }
}

/**
 * +-------------------+      +-------------------+
 * |      House        |<-----|    HouseBuilder   |
 * +-------------------+      +-------------------+
 * | +hasSwimmingPool  |      | +setSwimmingPool() |
 * | +hasGarden        |      | +setGarden()       |
 * | +hasGarage        |      | +setGarage()       |
 * +-------------------+      | +build()           |
 *                            +-------------------+
 *                                    ^
 *                                    |
 *                              +-----------------+
 *                              |     Client      |
 *                              +-----------------+
 *                              | +main()         |
 *                              +-----------------+
 *
 * House: The product class with various attributes like hasSwimmingPool, hasGarden, and hasGarage.
 * HouseBuilder: The builder class that provides methods to set each of the house's attributes. It also provides a build()
 *               method to return the constructed House object.
 * Client: The class that uses the builder to create a House with specific configurations, simplifying the object creation process.
 */

