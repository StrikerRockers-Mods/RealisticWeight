package io.github.strikerrocker.realw.api;

import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemWeight {
    /**
     * Stores the weight for all item's
     */
    private static Map<Item, Integer> weight = new HashMap<>();

    /**
     * Returns the weight for the specifies item's
     * @param item the item
     * @return
     */
    public static int getWeight(Item item) {
        return weight.get(item);
    }

    /**
     * Set's the weight for the given item
     *
     * @param item  The item
     * @param value The weight
     */
    public static void setWeight(Item item, int value) {
        weight.put(item, value);
    }

    /**
     * Replaces the weight for a item in the map
     * @param item the item
     * @param newWeight weight
     */
    public static void replaceWeight(Item item, int newWeight) {
        weight.remove(item);
        weight.put(item, newWeight);
    }
}
