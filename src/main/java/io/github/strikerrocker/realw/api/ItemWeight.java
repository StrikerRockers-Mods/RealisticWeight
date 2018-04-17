package io.github.strikerrocker.realw.api;

import javafx.util.Pair;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"unused"})
public class ItemWeight
{
    /**
     * Stores the weight for all item's
     */
    private static Map<Item, Map<Pair<Integer, NBTTagCompound>, Integer>> weight = new HashMap<>();

    /**
     * Returns the weight for the given item's
     *
     * @param item The item to return weight for
     * @return The weight of the item
     */
    public static int getWeight(Item item) {
        return getWeight(item, 0, null);
    }

    /**
     * Returns the weight for the given item's
     *
     * @param item The item to returstack   n weight for
     * @param meta The meta of the item to return weight for
     * @return The weight of the item
     */
    public static int getWeight(Item item, int meta) {
        return getWeight(item, meta, null);
    }

    /**
     * Returns the weight of the item in the itemstack
     *
     * @param itemStack The item to return weight for
     * @return The weight of the item
     */
    public static int getWeight(ItemStack itemStack) {
        return getWeight(itemStack.getItem(), itemStack.getMetadata(), itemStack.getTagCompound());
    }

    /**
     * Returns the weight of the item in the itemstack
     *
     * @param item The item to return weight for
     * @param meta The meta of the item to return weight for
     * @param nbt  The NBT of the item to return weight for
     * @return The weight of the item
     */
    public static int getWeight(Item item, int meta, NBTTagCompound nbt) {
        if (weight.get(item).get(new Pair<>(meta, nbt)) != null) {
            return weight.get(item).get(new Pair<>(meta, nbt));
        }
        return 0;
    }

    /**
     * Return's the stack weight for the given stack
     *
     * @param stack The stack to return weight for
     * @return weight The weight of the stack
     */
    public static int getStackWeight(ItemStack stack) {
        return getWeight(stack) * stack.getCount();
    }

    /**
     * Set's the weight for the given item
     * <p>
     * Don't use this during runtime may cause issue's
     *
     * @param item  The item to store weight for
     * @param value The weight to store
     */
    public static void setWeight(Item item, int value) {
        setWeight(item, value, 0, null);
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
        setWeight(itemStack.getItem(), value, itemStack.getMetadata(), itemStack.getTagCompound());
    }

    /**
     * Set's the weight for the given item
     * <p>
     * Don't use this during runtime may cause issue's
     *
     * @param item  The item to set weight for
     * @param value The weight to set for the item
     * @param meta  The Metadata of the item to store weight for
     */
    public static void setWeight(Item item, int value, int meta) {
        setWeight(item, value, meta, null);
    }

    /**
     * Set's the weight for the given item
     * <p>
     * Don't use this during runtime may cause issue's
     *
     * @param item  The item
     * @param value The weight
     * @param meta  The Metadata
     * @param nbt   The NBT data
     */
    public static void setWeight(Item item, int value, int meta, NBTTagCompound nbt) {
        if (weight.get(item) != null) {
            weight.get(item).put(new Pair<>(meta, nbt), value);
            return;
        }

        Map<Pair<Integer, NBTTagCompound>, Integer> map = new HashMap<>();
        map.put(new Pair<>(meta, nbt), value);
        weight.put(item, map);
    }

    /**
     * Return's the weight map
     *
     * @return
     */
    public static Map<Item, Map<Pair<Integer, NBTTagCompound>, Integer>> getMap() {
        return weight;
    }
}
