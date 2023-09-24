package OS;
import java.util.ArrayList;
import java.util.List;
class NextFit {
    private static class Bin {
        int id;
        int capacity;
        int occupied;
        Bin(int id, int capacity) {
            this.id = id;
            this.capacity = capacity;
            this.occupied = 0;
        }
    }
    private static class Item {
        int id;
        int size;

        Item(int id, int size) {
            this.id = id;
            this.size = size;
        }
    }
    private static List<Bin> nextFit(List<Item> items, int binCapacity) {
        List<Bin> bins = new ArrayList<>();
        Bin currentBin = new Bin(1, binCapacity);
        bins.add(currentBin);

        for (Item item : items) {
            // If the item fits in the current bin, place it
            if (currentBin.capacity - currentBin.occupied >= item.size) {
                currentBin.occupied += item.size;
            }
            // If the item doesn't fit, create a new bin and place it there
            else {
                currentBin = new Bin(bins.size() + 1, binCapacity);
                currentBin.occupied = item.size;
                bins.add(currentBin);
            }
        }
        return bins;
    }
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, 4));
        items.add(new Item(2, 2));
        items.add(new Item(3, 5));
        items.add(new Item(4, 1));
        items.add(new Item(5, 3));
        int binCapacity = 10;
        List<Bin> bins = nextFit(items, binCapacity);
        // Print the result
        for (Bin bin : bins) {
            System.out.println("Bin " + bin.id + ": Occupied " + bin.occupied + "/" + bin.capacity);
        }
    }
}
