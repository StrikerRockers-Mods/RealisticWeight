package io.github.strikerrocker.realw.events;

import com.google.common.eventbus.Subscribe;
import io.github.strikerrocker.realw.api.IWeight;
import io.github.strikerrocker.realw.capability.WeightProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class TooltipEvent {
    @Subscribe
    public void tooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        Item currentItem = stack.getItem();
        IWeight weight = stack.getCapability(WeightProvider.WEIGHT_CAP, null);
        int we = weight.getWeight(currentItem) * stack.getCount();
        if (stack.hasCapability(WeightProvider.WEIGHT_CAP, null)) {
            event.getToolTip().add(TextFormatting.YELLOW + "Weight" + "  " + we);
        }
    }
}
