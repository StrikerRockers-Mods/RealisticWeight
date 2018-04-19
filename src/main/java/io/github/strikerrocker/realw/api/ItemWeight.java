package io.github.strikerrocker.realw.api;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"unused"})
public class ItemWeight
{
    /**
     * Stores the weight for all item's
     */
    private static Map<String, Integer> weights = new HashMap<>();

    /**
     * Returns the weight for the given item's
     *
     * @param item The item to return weight for
     * @return The weight of the item
     */
    public static int getWeight(Item item) {
        return getWeight(item, 0);
    }

    /**
     * Returns the weight for the given item's
     *
     * @param item The item to return weight for
     * @param meta The meta of the item to return weight for
     * @return The weight of the item
     */
    public static int getWeight(Item item, int meta) {
        Integer itemWeight = weights.get(item.getRegistryName().toString() + ":" + meta);
        return itemWeight == null ? 0 : itemWeight;
    }

    /**
     * Returns the weight of the item in the Itemstack
     *
     * @param itemStack The item to return weight for
     * @return The weight of the item
     */
    public static int getWeight(ItemStack itemStack) {
        return getWeight(itemStack.getItem(), itemStack.getMetadata());
    }

    /**
     * Return's the stack weight for the given stack
     *
     * @param stack The stack to return weight for
     * @return The weight of the stack
     */
    public static int getStackWeight(ItemStack stack) {
        return getWeight(stack) * stack.getCount();
    }

    /**
     * Return's the inventory weight for the given inventory
     *
     * @param inventory The inventory to return weight for
     * @return The weight of the inventory
     */
    public static int getInventoryWeight(IInventory inventory) {
        int weight = 0;
        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            ItemStack stack = inventory.getStackInSlot(i);
            if (!(stack == ItemStack.EMPTY) && !(stack.isEmpty())) {
                weight += getStackWeight(stack);
            }
        }
        return weight;
    }

    /**
     * Set's the weight for the given item
     * <p>
     * Don't use this during runtime may cause issue's
     *
     * @param item  The item to set weight for
     * @param value The weight to set
     */
    public static void setWeight(Item item, int value) {
        setWeight(item, 0, value);
    }

    /**
     * Set's the weight for the given item
     * <p>
     * Don't use this during runtime may cause issue's
     *
     * @param itemStack The itemStack
     * @param value     The weight
     */
    public static void setWeight(ItemStack itemStack, int value) {
        setWeight(itemStack.getItem(), itemStack.getMetadata(), value);
    }

    /**
     * Set's the weight for the given item
     * <p>
     * Don't use this during runtime may cause issue's
     *
     * @param item  The item to set weight for
     * @param value The weight to set for the item
     * @param meta  The Metadata of the item to set weight for
     */
    public static void setWeight(Item item, int meta, int value) {
        weights.put(item.getRegistryName().toString() + ":" + meta, value);
    }

    /**
     * Return's the weight map
     *
     * @return
     */
    public static Map<String, Integer> getMap() {
        return new HashMap<>(weights);
    }
}
