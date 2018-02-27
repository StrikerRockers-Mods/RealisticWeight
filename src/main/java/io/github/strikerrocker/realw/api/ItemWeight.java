package io.github.strikerrocker.realw.api;

import net.minecraft.item.Item;

import java.util.HashMap;

public class ItemWeight {
    /**
     * Stores the weight for all item's
     */
    private static HashMap<Item, Integer> weight = new HashMap<>();

    /**
     * Returns the weight for the specifies item's
     *
     * @param item the item
     * @return the weight of the item
     */
    public static int getWeight(Item item) {
        return weight.get(item);
    }

    /**
     * Set's the weight for the given item
     *
     * Don't use this during runtime may cause issue's
     *
     * @param item  The item
     * @param value The weight
     */
    public static void setWeight(Item item, int value) {
        weight.put(item, value);
    }
}
