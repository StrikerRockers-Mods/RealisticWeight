package io.github.strikerrocker.realw.api;

import com.sun.istack.internal.NotNull;
import javafx.util.Pair;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.HashMap;
import java.util.Map;

public class ItemWeight {
    /**
     * Stores the weight for all item's
     */
    private static Map<Item, Map<Pair<Integer, NBTTagCompound>, Integer>> weight = new HashMap<>();

    /**
     * Returns the weight for the specifies item's
     *
     * @param item the item
     * @return the weight of the item
     */
    @NotNull
    public static int getWeight(Item item) {
        return getWeight(item, 0, null);
    }

    @NotNull
    public static int getWeight(Item item, int meta){
        return getWeight(item, meta, null);
    }

    @NotNull
    public static int getWeight(ItemStack item){
        return getWeight(item.getItem(), item.getMetadata(), item.getTagCompound());
    }

    @NotNull
    public static int getWeight(Item item, int meta, NBTTagCompound nbt){
        if(weight.get(item)!=null){
            return weight.get(item).get(new Pair<>(meta, nbt));
        }
        return 0;
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
        setWeight(item, value, 0, null);
    }

    /**
     * Set's the weight for the given item
     *
     * Don't use this during runtime may cause issue's
     *
     * @param item  The itemStack
     * @param value The weight
     */
    public static void setWeight(ItemStack item, int value){
        setWeight(item.getItem(), value, item.getMetadata(), item.getTagCompound());
    }

    /**
     * Set's the weight for the given item
     *
     * Don't use this during runtime may cause issue's
     *
     * @param item  The item
     * @param value The weight
     * @param meta The Metadata
     */
    public static void setWeight(Item item, int value, int meta){
        setWeight(item, value, meta, null);
    }

    /**
     * Set's the weight for the given item
     *
     * Don't use this during runtime may cause issue's
     *
     * @param item  The item
     * @param value The weight
     * @param meta The Metadata
     * @param nbt The NBT data
     */
    public static void setWeight(Item item, int value, int meta, NBTTagCompound nbt){
        if(weight.get(item)!=null){
            weight.get(item).put(new Pair<>(meta, nbt), value);
            return;
        }

        Map<Pair<Integer, NBTTagCompound>, Integer> map = new HashMap<>();
        map.put(new Pair<>(meta, nbt), value);
        weight.put(item, map);
    }

    /**
     * Return's the stack weight for the given stack
     *
     * @param stack the stack
     * @return weight
     */
    public static int getStackWeight(ItemStack stack) {
        return ItemWeight.getWeight(stack) * stack.getCount();
    }
}
