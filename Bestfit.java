package OS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class BestFit {
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
    private static List<Bin> bestFit(List<Item> items, int binCapacity) {
        List<Bin> bins = new ArrayList<>();

        for (Item item : items) {
            boolean itemPlaced = false;
            int bestFitIndex = -1;
            int bestFitRemaining = Integer.MAX_VALUE;

            // Find the bin with the best fit (smallest remaining capacity)
            for (int i = 0; i < bins.size(); i++) {
                Bin bin = bins.get(i);
                int remaining = bin.capacity - bin.occupied;
                if (remaining >= item.size && remaining < bestFitRemaining) {
                    bestFitIndex = i;
                    bestFitRemaining = remaining;
                }
            }

            // If a suitable bin was found, place the item in it
            if (bestFitIndex != -1) {
                Bin bin = bins.get(bestFitIndex);
                bin.occupied += item.size;
                itemPlaced = true;
            }

            // If the item couldn't be placed, create a new bin and put the item in it
            if (!itemPlaced) {
                Bin newBin = new Bin(bins.size() + 1, binCapacity);
                newBin.occupied = item.size;
                bins.add(newBin);
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
        List<Bin> bins = bestFit(items, binCapacity);
        // Print the result
        for (Bin bin : bins) {
            System.out.println("Bin " + bin.id + ": Occupied " + bin.occupied + "/" + bin.capacity);
        }
    }
}
