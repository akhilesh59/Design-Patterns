package StructuralDesignPattern.ProxyPattern;

// Subject
interface Image {
    void display();
}

// RealSubject
// If we do not use Proxy Pattern then we'll end up loading the image again and again from the disk,
// even if we don't need it now.
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    // lazy loading in display() method
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client code
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("example.jpg");
        Image image2 = new ProxyImage("example.jpg");

        // Image will be loaded from disk only when display() is called
        image1.display();

        // Image will not be loaded again, as it has been cached in the Proxy
        image1.display();

        // Since we never called display() on image2, hence image2 will not be loaded from the disk.
    }
}
