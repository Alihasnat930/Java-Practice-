package OS;

import java.util.ArrayList;
import java.util.List;

class LinkedAllocation {
    private List<FileAllocation> files;
    private int totalSpace;
    private int allocatedSpace;
    private List<Integer> linkedList;

    public LinkedAllocation(int totalSpace) {
        this.totalSpace = totalSpace;
        this.allocatedSpace = 0;
        this.files = new ArrayList<>();
        this.linkedList = new ArrayList<>();
    }

    public boolean allocateFile(FileAllocation file) {
        if (allocatedSpace + file.getSize() <= totalSpace) {
            files.add(file);
            if (files.size() == 1) {
                linkedList.add(-1);
            } else {
                linkedList.add(allocatedSpace - file.getSize());
            }
            allocatedSpace += file.getSize();
            return true;
        }
        return false;
    }

    public void printAllocatedFiles() {
        System.out.println("Linked Allocation:");
        for (int i = 0; i < files.size(); i++) {
            FileAllocation file = files.get(i);
            int prevIndex = linkedList.get(i);
            String prevFileName = prevIndex == -1 ? "None" : files.get(prevIndex).getName();
            System.out.println(file.getName() + " - " + file.getSize() + "KB (Prev: " + prevFileName + ")");
        }
        System.out.println("Allocated space: " + allocatedSpace + "KB");
        System.out.println("Remaining space: " + (totalSpace - allocatedSpace) + "KB");
    }
}

