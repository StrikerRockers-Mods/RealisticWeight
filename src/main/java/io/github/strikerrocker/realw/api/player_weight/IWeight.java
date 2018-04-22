package io.github.strikerrocker.realw.api.player_weight;

public interface IWeight {
    /**
     * Add's the specifies weight to the player
     *
     * @param weight weight to be Added
     */
    void addWeight(int weight);

    /**
     * Removes the specifies weight for the player
     *
     * @param weight weight to be removed
     */
    void reduceWeight(int weight);

    /**
     * Return's the current weight of the player
     *
     * @return weight
     */
    int getWeight();

    /**
     * Set's the weight for the player
     *
     * @param weight weight to be set
     */
    void setWeight(int weight);
    //Internal start(Don't use this)

    /**
     * Return's the weight currently set by the API
     * Don't mess with this use getWeight.
     *
     * @return apiWeight
     */
    int getApiWeight();
}
