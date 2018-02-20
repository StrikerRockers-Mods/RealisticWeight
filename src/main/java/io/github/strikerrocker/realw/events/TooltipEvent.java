package io.github.strikerrocker.realw.events;

import io.github.strikerrocker.realw.api.IWeight;
import io.github.strikerrocker.realw.capability.WeightProvider;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TooltipEvent {
    @SubscribeEvent
    public void tooltip(ItemTooltipEvent event) {
        if (event.getItemStack().getItem() instanceof ItemArrow) {
            ItemStack stack = event.getItemStack();
            IWeight weight = stack.getCapability(WeightProvider.WEIGHT_CAP, null);
            int we = weight.getStackWeight(stack);
            event.getToolTip().add(TextFormatting.YELLOW + "Weight" + "  " + we);
        }
    }
}
