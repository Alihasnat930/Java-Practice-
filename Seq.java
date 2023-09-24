package OS;

import java.util.ArrayList;
import java.util.List;

class FileAllocation {
    private String name;
    private int size;

    public FileAllocation(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}

class SequentialAllocation {
    private List<FileAllocation> files;
    private int totalSpace;
    private int allocatedSpace;

    public SequentialAllocation(int totalSpace) {
        this.totalSpace = totalSpace;
        this.allocatedSpace = 0;
        this.files = new ArrayList<>();
    }

    public boolean allocateFile(FileAllocation file) {
        if (allocatedSpace + file.getSize() <= totalSpace) {
            files.add(file);
            allocatedSpace += file.getSize();
            return true;
        }
        return false;
    }

    public void printAllocatedFiles() {
        System.out.println("Sequential Allocation:");
        for (FileAllocation file : files) {
            System.out.println(file.getName() + " - " + file.getSize() + "KB");
        }
        System.out.println("Allocated space: " + allocatedSpace + "KB");
        System.out.println("Remaining space: " + (totalSpace - allocatedSpace) + "KB");
    }
}