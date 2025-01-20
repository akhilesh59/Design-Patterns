package StructuralDesignPattern.FlyWeightPattern;

class Bullet {
    private String color;   // Intrinsic property shared by all objects

    // Coordinates
    private int x,y;    // Extrinsic properties unique to each object
    private int velocity;

    public Bullet(String color, int x, int y, int velocity) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        System.out.println("Creating bullet at (" + x + ", " + y + " with velocity: " + velocity);
    }

    public void display() {
        System.out.println("Bullet at (" + x + ", " + y + " with velocity: " + velocity);
    }
}
public class ShootingGameWithoutFlyweightPattern {
    public static void main(String[] args) {
        // Let's create 5 bullet objects
        for(int i=0; i<5; ++i) {
            Bullet bullet = new Bullet("Red", i*10, i*12, i*100);
        }

        for(int i=0; i<5; ++i) {
            Bullet bullet = new Bullet("Yellow", i*10, i*12, i*100);
        }
    }
}

/**
 * Problem here is of the extra overhead of the bullet visual part that is same in all the bullets of a color.
 * That will occupy a lot of memory as the number of bullets increases for an instance.
 *
 * We can solve this problem of memory overhead by using Flyweight pattern.
 */
