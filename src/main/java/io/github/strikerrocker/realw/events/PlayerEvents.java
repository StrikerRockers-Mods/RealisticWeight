package io.github.strikerrocker.realw.events;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PlayerEvents {
    @SubscribeEvent
    public void playerLoggedin(PlayerEvent.PlayerLoggedInEvent event) {
        event.player.inventoryContainer.addListener(new InventoryListener((EntityPlayerMP) event.player));
    }

    public void livingupdate(LivingEvent.LivingUpdateEvent event) {

    }
}
