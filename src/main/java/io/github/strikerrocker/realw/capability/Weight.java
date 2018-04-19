package io.github.strikerrocker.realw.capability;

import io.github.strikerrocker.realw.api.IWeight;

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
        this.Weight += api_weight;
    }

    /**
     * Removes the specifies weight for the player
     *
     * @param weight weight to be removed
     */
    @Override
    public void reduceWeight(int weight) {
        this.Weight -= api_weight;
    }

    /**
     * Return's the current weight of the player
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
        this.Weight = weight;
        api_weight = 0;
    }

    @Override
    public int getApiWeight() {
        return api_weight;
    }

    @Override
    public void setApiWeight(int weight) {
        this.api_weight = weight;
    }
}
