package io.github.strikerrocker.realw.api;

import net.minecraft.entity.player.EntityPlayer;

public interface IEffect {
    public void applyEffect(EntityPlayer player, int weight, int maxWeight);

    public void clearEffect(EntityPlayer player);

    public int maxWeight();
}
