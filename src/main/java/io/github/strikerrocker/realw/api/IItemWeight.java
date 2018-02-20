package io.github.strikerrocker.realw.api;

import net.minecraft.item.Item;

public interface IItemWeight {
    int getWeight(Item item);

    int getWeight();

    void setWeight(Item item, int weight);

    void setWeight(int weight);

    void replaceWeight(Item item, int newWeight);
}
