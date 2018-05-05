package io.github.strikerrocker.realw.api.gamestages;

import net.minecraft.entity.player.EntityPlayer;

import java.util.Collection;

/**
 * Created by StrikerRocker on 4/5/18.
 */
public interface IGameStageCompat {
    boolean doesPlayerHave(EntityPlayer player, String stage);

    Collection<String> getStages(EntityPlayer player);
}
