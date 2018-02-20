package io.github.strikerrocker.realw.api;

import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemWeight {

    private static Map<Item, Integer> weight = new HashMap<>();

    /**
     * For Item's
     */

    public static int getWeight(Item item) {
        return weight.get(item);
    }

    public static void setWeight(Item item, int value) {
        weight.put(item, value);
    }

    public static void replaceWeight(Item item, int newWeight) {
        weight.remove(item);
        weight.put(item, newWeight);
    }
}
