package io.github.strikerrocker.realw.api;

import com.sun.istack.internal.NotNull;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
    @NotNull
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

    /**
     * Return's the stack weight for the given stack
     *
     * @param stack the stack
     * @return weight
     */
    public static int getStackWeight(ItemStack stack) {
        int count = stack.getCount();
        Item item = stack.getItem();
        return count * ItemWeight.getWeight(item);
    }
}
