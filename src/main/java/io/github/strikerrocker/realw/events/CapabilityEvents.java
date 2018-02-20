package io.github.strikerrocker.realw.events;

import com.google.common.eventbus.Subscribe;
import io.github.strikerrocker.realw.Constants;
import io.github.strikerrocker.realw.capability.ItemWeightProvider;
import io.github.strikerrocker.realw.capability.WeightProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class CapabilityEvents {

    public static final ResourceLocation WEIGHT_CAP = new ResourceLocation(Constants.MOD_ID, "weight");
    public static final ResourceLocation ITEM_WEIGHT_CAP = new ResourceLocation(Constants.MOD_ID, "item_weight");

    @Subscribe
    public void attachCap(AttachCapabilitiesEvent<ItemStack> event) {
        event.addCapability(ITEM_WEIGHT_CAP, new ItemWeightProvider());
    }

    @Subscribe
    public void attachCapa(AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof EntityPlayer)) return;
        event.addCapability(WEIGHT_CAP, new WeightProvider());
    }
}
