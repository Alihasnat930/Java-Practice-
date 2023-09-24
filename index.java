package OS;

import java.util.ArrayList;
import java.util.List;

class IndexedAllocation {
    private List<FileAllocation> files;
    private int totalSpace;
    private int allocatedSpace;
    private List<Integer> indexTable;

    public IndexedAllocation(int totalSpace) {
        this.totalSpace = totalSpace;
        this.allocatedSpace = 0;
        this.files = new ArrayList<>();
        this.indexTable = new ArrayList<>();
    }

    public boolean allocateFile(FileAllocation file) {
        if (allocatedSpace + file.getSize() <= totalSpace) {
            files.add(file);
            indexTable.add(allocatedSpace);
            allocatedSpace += file.getSize();
            return true;
        }
        return false;
    }

    public void printAllocatedFiles() {
        System.out.println("Indexed Allocation:");
        for (int i = 0; i < files.size(); i++) {
            FileAllocation file = files.get(i);
            System.out.println(file.getName() + " - " + file.getSize() + "KB (Index: " + indexTable.get(i) + ")");
        }
        System.out.println("Allocated space: " + allocatedSpace + "KB");
        System.out.println("Remaining space: " + (totalSpace - allocatedSpace) + "KB");
    }
}