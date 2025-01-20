package StructuralDesignPattern.CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class File {
    private String name;
    public File(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("File : " + name);
    }
}

public class Folder {
    private String name;
    private List<File> files = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void showDetails() {
        System.out.println("Folder: " + name);
        for(File file: files) {
            file.showDetails();
        }
    }
}
public class FileManagementWithoutCompositePattern {
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        Folder folder = new Folder("Documents");
        folder.addFile(file1);
        folder.addFile(file2);

        folder.showDetails();

        // Now what if I want to create a List of Folders??
        // Then we'll need to make another class that will hold a list of folders...
    }
}
