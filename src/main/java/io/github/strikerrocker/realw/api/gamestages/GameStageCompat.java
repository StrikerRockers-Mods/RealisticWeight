package io.github.strikerrocker.realw.api.gamestages;

import net.darkhax.gamestages.GameStageHelper;
import net.darkhax.gamestages.data.IStageData;
import net.minecraft.entity.player.EntityPlayer;

import java.util.Collection;

/**
 * Created by StrikerRocker on 4/5/18.
 */
public class GameStageCompat implements IGameStageCompat {
    @Override
    public boolean doesPlayerHave(EntityPlayer player, String stage) {
        return GameStageHelper.hasStage(player, stage);
    }

    @Override
    public Collection<String> getStages(EntityPlayer player) {
        final IStageData info = GameStageHelper.getPlayerData(player);
        return info.getStages();
    }
}
