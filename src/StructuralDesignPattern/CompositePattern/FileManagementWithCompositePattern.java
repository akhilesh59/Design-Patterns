package StructuralDesignPattern.CompositePattern;

import java.util.ArrayList;
import java.util.List;

public interface FileSystemComponent {
    void showDetails();
}

public class FileCompositePattern implements FileSystemComponent {
    private String name;
    public FileCompositePattern(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File : " + name);
    }
}

public class FolderCompositePattern implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public FolderCompositePattern(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: " + name);
        for(FileSystemComponent component: components) {
            component.showDetails();
        }
    }
}
public class FileManagementWithCompositePattern {
    FileSystemComponent file1 = new FileCompositePattern("File1.txt");
    FileSystemComponent file2 = new FileCompositePattern("File2.txt");
    FolderCompositePattern folder = new FolderCompositePattern("Documents");
    folder.addComponent(file1);
    folder.addComponent(file2);

    // Sub-folder
    FolderCompositePattern subFolder = new FolderCompositePattern("Subfolder");
    FileSystemComponent file3 = new FileCompositePattern("File3.txt");
    subFolder.addComponent(file3);
    folder.add(subFolder);

    folder.showDetails();

}
