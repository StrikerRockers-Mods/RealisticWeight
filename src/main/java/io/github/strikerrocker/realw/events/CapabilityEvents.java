package io.github.strikerrocker.realw.events;

import io.github.strikerrocker.realw.Constants;
import io.github.strikerrocker.realw.api.player_weight.WeightProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityEvents {

    private static final ResourceLocation WEIGHT_CAP = new ResourceLocation(Constants.MOD_ID, "weight");

    @SubscribeEvent
    public void attachCapabilityEntity(AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof EntityPlayer)) return;
        event.addCapability(WEIGHT_CAP, new WeightProvider());
    }
}