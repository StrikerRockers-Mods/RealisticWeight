package io.github.strikerrocker.realw.events;

import io.github.strikerrocker.realw.api.IEffect;
import io.github.strikerrocker.realw.api.player_weight.IWeight;
import io.github.strikerrocker.realw.api.player_weight.WeightProvider;
import io.github.strikerrocker.realw.handlers.ConfigHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.LinkedList;
import java.util.List;

public class PlayerEvents {

    List<IEffect> effects = new LinkedList<IEffect>();

    @SubscribeEvent
    public void playerLoggedin(PlayerEvent.PlayerLoggedInEvent event) {
        event.player.inventoryContainer.addListener(new InventoryListener((EntityPlayerMP) event.player));
    }

    @SubscribeEvent
    public void livingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer entity = (EntityPlayer) event.getEntity();
            if (!entity.isCreative()) {
                IWeight pweight = entity.getCapability(WeightProvider.WEIGHT_CAP, null);
                float percent = pweight.getWeight() / ConfigHandler.weight;
                if (ConfigHandler.gamemode) {
                    if (percent <= 0.125) {
                        entity.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 200, 1, false, false));
                        entity.addPotionEffect(new PotionEffect(MobEffects.SPEED, 200, 1, false, false));
                    } else if (percent <= 0.25) {
                        entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 1, false, false));
                    } else if (percent <= 0.5) {
                        entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 2, false, false));
                    } else if (percent <= 0.75) {
                        entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 3, false, false));
                    } else {
                        entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 4, false, false));
                    }
                } else {
                    if (percent > 0.125 && percent <= 0.25) {
                        entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 2, false, false));
                    } else if (percent > 0.25 && percent <= 0.5) {
                        entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 3, false, false));
                    } else if (percent > 0.5 && percent <= 0.75) {
                        entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 4, false, false));
                    } else {
                        entity.setDead();
                    }
                }
            }
        }


    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        IWeight pWeight = event.player.getCapability(WeightProvider.WEIGHT_CAP, null);
        for (IEffect iEffect : effects) {
            iEffect.applyEffect(event.player, pWeight.getWeight(), pWeight.getMaxWeight());
        }
    }

    @SubscribeEvent
    public void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        IWeight pWeight = event.player.getCapability(WeightProvider.WEIGHT_CAP, null);
        for (IEffect iEffect : effects) {
            iEffect.clearEffect(event.player);
        }
    }
}