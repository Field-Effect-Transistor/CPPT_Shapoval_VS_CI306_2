package ce306.shapoval.lab6;

import java.util.*;

/**
 * The <code>Cabinet</code> class represents a cabinet with a generic type.
 * It allows adding, removing, and searching for items.
 *
 * @param <T> the type of items stored in the cabinet
 */
public class Cabinet<T extends Item> {
    private List<T> items;

    /**
     * Constructor to initialize the cabinet.
     */
    public Cabinet() {
        items = new ArrayList<>();
    }

    /**
     * Adds an item to the cabinet.
     * @param item The item to be added
     */
    public void addItem(T item) {
        items.add(item);
    }

    /**
     * Removes an item from the cabinet.
     * @param item The item to be removed
     * @return <code>true</code> if the item was removed, <code>false</code> otherwise
     */
    public boolean removeItem(T item) {
        return items.remove(item);
    }

    /**
     * Searches for the minimum item in the cabinet (for even variants).
     * @return The minimum item, or <code>null</code> if the cabinet is empty
     */
    public T findMin() {
        if (items.isEmpty()) {
            return null;
        }
        T min = items.get(0);
        for (T item : items) {
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return min;
    }

    /**
     * Returns the list of items in the cabinet.
     * @return List of items
     */
    public List<T> getItems() {
        return items;
    }
}
