package io.github.strikerrocker.realw.api;

import net.minecraft.item.ItemStack;

public interface IWeight {
    void setWeight(int weight);

    void addWeight(int weight);

    void reduceWeight(int weight);

    int getWeight();

    int getStackWeight(ItemStack stack);
}
