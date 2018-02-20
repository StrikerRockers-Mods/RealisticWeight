package io.github.strikerrocker.realw.capability;

import io.github.strikerrocker.realw.api.IWeight;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class Weight implements IWeight {

    private Map<Item, Integer> weight = new HashMap<>();
    private int Weight;

    /**
     * Common for player and stack
     */

    @Override
    public void setWeight(int weight) {
        this.Weight = weight;
    }

    @Override
    public void addWeight(int weight) {
        this.Weight += weight;
    }

    @Override
    public void reduceWeight(int weight) {
        this.Weight -= weight;
    }

    @Override
    public int getWeight() {
        return Weight;
    }

    /**
     * For Item's
     */

    @Override
    public int getWeight(Item item) {
        return weight.get(item);

    }


    @Override
    public void replaceWeight(Item item, int newWeight) {
        this.weight.remove(item);
        this.weight.put(item, newWeight);
    }

    /**
     * for Itemstack
     */

    @Override
    public int getStackWeight(ItemStack stack) {
        int count = stack.getCount();
        Item item = stack.getItem();
        return count * getWeight(item);
    }
}
