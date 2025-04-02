import java.util.*;

abstract class CompositeItem {
    protected double size=0;
    
    public abstract double getSize();
}

class FileItem extends CompositeItem{
    public FileItem(double size) {
        this.size = size;
    }
    
    public double getSize() {
        return this.size;
    }
}

class FolderItem extends CompositeItem{
    ArrayList<CompositeItem> items = new ArrayList<>();
    
    public void addItem(CompositeItem item) {
        this.items.add(item);
    }
    
    public double getSize() {
        for(CompositeItem item: items) {
            this.size += item.getSize();
        }
        
        return this.size;
    }
}

class Main {
    public static void main(String[] args) {
        /*
        - mainFolder
            - file (5)
            - file (2)
            - subFolder
                - file(6)
                - subSubFolder 
                    - file (2)
                    - subSubSubFolder
                    - file (7)
                    - file (11)
                    - file (1)
        */
        FolderItem subSubSubFolder = new FolderItem();
        
        FolderItem subSubFolder = new FolderItem();
        subSubFolder.addItem(new FileItem(2));
        subSubFolder.addItem(subSubSubFolder);
        subSubFolder.addItem(new FileItem(7));
        subSubFolder.addItem(new FileItem(11));
        subSubFolder.addItem(new FileItem(1));
        
        FolderItem subFolder = new FolderItem();
        subFolder.addItem(new FileItem(6));
        subFolder.addItem(subSubFolder);
        
        FolderItem mainFolder = new FolderItem();
        mainFolder.addItem(new FileItem(5));
        mainFolder.addItem(new FileItem(2));
        mainFolder.addItem(subFolder);
        
        System.out.println(String.join(" ", "Total size of the main folder:", mainFolder.getSize()+""));
    }
}
