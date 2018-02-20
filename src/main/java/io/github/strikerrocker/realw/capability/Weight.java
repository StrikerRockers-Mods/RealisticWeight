package io.github.strikerrocker.realw.capability;

import io.github.strikerrocker.realw.api.IWeight;
import io.github.strikerrocker.realw.api.ItemWeight;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Weight implements IWeight {


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
     * for Itemstack
     */

    @Override
    public int getStackWeight(ItemStack stack) {
        int count = stack.getCount();
        Item item = stack.getItem();
        return count * ItemWeight.getWeight(item);
    }
}
