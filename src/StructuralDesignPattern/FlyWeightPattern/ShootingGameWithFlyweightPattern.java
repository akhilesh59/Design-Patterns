package StructuralDesignPattern.FlyWeightPattern;

import java.util.HashMap;

/**
 * How can we solve the overhead problem:
 * In this refactor, the bullet class contains only extrinsic data like position and velocity. The intrinsic
 * data like color is stored in a BulletType class, which is shared across all Bullet objects.
 * This allows us to manage a large number of bullets efficiently.
 */

public class FlyweightBullet {
    private BulletType type;    // Intrinsic property shared by all bullets
    // Coordinates
    private int x,y;    // Extrinsic properties unique to each object
    private int velocity;

    public FlyweightBullet(String color, int x, int y, int velocity) {
        // If this color is already created then no new object will be created, hence we'll save memory
        this.type = BulletTypeFactory.getBulletType(color);
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        System.out.println("Creating bullet at (" + x + ", " + y + " with velocity: " + velocity);
    }

    public void display() {
        System.out.println("Bullet at (" + x + ", " + y + " with velocity: " + velocity);
    }
}

public class BulletType {
    private String color;   // Intrinsic
    public BulletType(String color) {
        this.color = color;
        System.out.println("Creating BulletType with color: " + color);
    }
}

public class BulletTypeFactory {
    private static final HashMap<String,BulletType> bulletTypes = new HashMap<>();

    public static BulletType getBulletType(String color){
        if(!bulletTypes.containsKey(color)) {
            bulletTypes.put(color, new BulletType(color));
        }
        return bulletTypes.get(color);
    }
}
public class ShootingGameWithFlyweightPattern {
}

