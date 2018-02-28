package io.github.strikerrocker.realw.events;

import io.github.strikerrocker.realw.api.IWeight;
import io.github.strikerrocker.realw.capability.WeightProvider;
import io.github.strikerrocker.realw.handlers.ConfigHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PlayerEvents {
    @SubscribeEvent
    public void playerLoggedin(PlayerEvent.PlayerLoggedInEvent event) {
        event.player.inventoryContainer.addListener(new InventoryListener((EntityPlayerMP) event.player));
    }

    @SubscribeEvent
    public void livingUpdate(LivingEvent.LivingUpdateEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof EntityPlayer) {
            IWeight weight = entity.getCapability(WeightProvider.WEIGHT_CAP, null);
            if (weight.getWeight() > ConfigHandler.weight) {
                if (ConfigHandler.gamemode) {

                } else {
                    entity.setDead();
                }
            }
        }
    }
}
