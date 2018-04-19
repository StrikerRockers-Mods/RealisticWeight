package io.github.strikerrocker.realw.capability;

import io.github.strikerrocker.realw.api.player_weight.IWeight;

public class Weight implements IWeight
{
    /**
     * Store's the player weight
     */
    private int Weight = 1;
    private int api_weight = 0;

    /**
     * Add's the specifies weight to the player
     *
     * @param weight weight to be Added
     */
    @Override
    public void addWeight(int weight) {
        api_weight += weight;
    }

    /**
     * Removes the specifies weight for the player
     *
     * @param weight weight to be removed
     */
    @Override
    public void reduceWeight(int weight) {
        api_weight -= weight;
    }

    /**
     * Return's the current weight of the player
     * 1
     *
     * @return weight
     */
    @Override
    public int getWeight() {
        return Weight + api_weight;
    }

    /**
     * Set's the weight for the player
     *
     * @param weight weight to be set
     */
    @Override
    public void setWeight(int weight) {
        reduceWeight(this.Weight);
        addWeight(weight);
    }

    @Override
    public int getApiWeight() {
        return api_weight;
    }
}
