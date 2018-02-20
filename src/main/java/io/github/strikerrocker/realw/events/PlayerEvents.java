package io.github.strikerrocker.realw.events;

import com.google.common.eventbus.Subscribe;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PlayerEvents {
    @Subscribe
    public void playerLoggedin(PlayerEvent.PlayerLoggedInEvent event) {
        event.player.inventoryContainer.addListener(new InventoryListener((EntityPlayerMP) event.player));
    }
}
