package io.github.strikerrocker.realw.api;

public interface IWeight {
    /**
     * Set's the weight for the player
     *
     * @param weight weight to be set
     */
    void setWeight(int weight);

    /**
     * Add's the specifies weight to the player
     * @param weight weight to be Added
     */
    void addWeight(int weight);

    /**
     * Removes the specifies weight for the player
     * @param weight weight to be removed
     */
    void reduceWeight(int weight);

    /**
     * Return's the current weight of the player
     * @return weight
     */
    int getWeight();
}
