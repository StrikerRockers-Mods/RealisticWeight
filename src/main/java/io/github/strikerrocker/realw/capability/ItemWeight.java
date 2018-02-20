package io.github.strikerrocker.realw.capability;

import io.github.strikerrocker.realw.api.IItemWeight;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemWeight implements IItemWeight {

    private Map<Item, Integer> weight = new HashMap<>();

    @Override
    public int getWeight(Item item) {
        return weight.get(item);
    }

    @Override
    public void setWeight(Item item, int weight) {
        this.weight.put(item, weight);
    }

    @Override
    public void replaceWeight(Item item, int newWeight) {
        this.weight.remove(item);
        this.weight.put(item, newWeight);
    }
}