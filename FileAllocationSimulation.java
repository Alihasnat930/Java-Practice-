package OS;

import java.util.ArrayList;
import java.util.List;
public class FileAllocationSimulation {
    public static void main(String[] args) {
        SequentialAllocation sequentialAllocation = new SequentialAllocation(1000);
        IndexedAllocation indexedAllocation = new IndexedAllocation(1000);
        LinkedAllocation linkedAllocation = new LinkedAllocation(1000);

        FileAllocation file1 = new FileAllocation("file1.txt", 200);
        FileAllocation file2 = new FileAllocation("file2.txt", 400);
        FileAllocation file3 = new FileAllocation("file3.txt", 300);

        sequentialAllocation.allocateFile(file1);
        sequentialAllocation.allocateFile(file2);
        sequentialAllocation.allocateFile(file3);

        indexedAllocation.allocateFile(file1);
        indexedAllocation.allocateFile(file2);
        indexedAllocation.allocateFile(file3);

        linkedAllocation.allocateFile(file1);
        linkedAllocation.allocateFile(file2);
        linkedAllocation.allocateFile(file3);

        sequentialAllocation.printAllocatedFiles();
        indexedAllocation.printAllocatedFiles();
        linkedAllocation.printAllocatedFiles();
    }
}
