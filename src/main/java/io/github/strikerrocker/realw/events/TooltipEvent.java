package io.github.strikerrocker.realw.events;

import io.github.strikerrocker.realw.api.IWeight;
import io.github.strikerrocker.realw.api.ItemWeight;
import io.github.strikerrocker.realw.capability.WeightProvider;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TooltipEvent {
    @SubscribeEvent
    public void tooltip(ItemTooltipEvent event) {
        if (event.getItemStack().hasCapability(WeightProvider.WEIGHT_CAP, null)) {
            ItemStack stack = event.getItemStack();
            IWeight weight = stack.getCapability(WeightProvider.WEIGHT_CAP, null);
            int stackWeight = weight.getStackWeight(stack);
            int itemWeight = ItemWeight.getWeight(stack.getItem());
            if (stack.getItem() instanceof ItemBlock) {
                event.getToolTip().add(TextFormatting.YELLOW + "Block Weight" + " : " + TextFormatting.WHITE + itemWeight);
            } else
                event.getToolTip().add(TextFormatting.YELLOW + "Item Weight" + " : " + TextFormatting.WHITE + itemWeight);
            if (stack.getCount() > 1) {
                event.getToolTip().add(TextFormatting.YELLOW + "Stack Weight" + " : " + TextFormatting.WHITE + stackWeight);
            }
        }
    }
}
