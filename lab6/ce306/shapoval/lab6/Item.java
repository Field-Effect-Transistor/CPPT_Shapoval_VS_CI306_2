package ce306.shapoval.lab6;

/**
 * The <code>Item</code> class represents an item with a name and volume.
 */
public class Item implements Comparable<Item> {
    private String name;
    private double volume;

    /**
     * Constructor to initialize an item with a name and volume.
     *
     * @param name   The name of the item
     * @param volume The volume of the item
     */
    public Item(String name, double volume) {
        this.name = name;
        this.volume = volume;
    }

    /**
     * Gets the name of the item.
     *
     * @return The name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the volume of the item.
     *
     * @return The volume of the item
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Compares this item with another item based on volume.
     *
     * @param other The other item to compare with
     * @return A negative integer, zero, or a positive integer as this item
     *         is less than, equal to, or greater than the specified item
     */
    @Override
    public int compareTo(Item other) {
        return Double.compare(this.volume, other.volume);
    }

    /**
     * Returns a string representation of the item.
     *
     * @return A string representation of the item
     */
    @Override
    public String toString() {
        return String.format("Item{name='%s', volume=%.2f}", name, volume);
    }
}
