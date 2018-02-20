package io.github.strikerrocker.realw.capability;

import io.github.strikerrocker.realw.api.IWeight;

public class Weight implements IWeight {

    private int Weight;

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
}
