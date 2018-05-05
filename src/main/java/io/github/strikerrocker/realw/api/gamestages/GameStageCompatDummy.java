package io.github.strikerrocker.realw.api.gamestages;

import net.minecraft.entity.player.EntityPlayer;

import java.util.Collection;

/**
 * Created by StrikerRocker on 4/5/18.
 */
public class GameStageCompatDummy implements IGameStageCompat {
    @Override
    public boolean doesPlayerHave(EntityPlayer player, String stage) {
        return false;
    }

    @Override
    public Collection<String> getStages(EntityPlayer player) {
        return null;
    }
}
