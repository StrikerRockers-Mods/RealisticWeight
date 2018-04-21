package io.github.strikerrocker.realw.mapping;

import io.github.strikerrocker.realw.api.ItemWeight;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nonnull;

/**
 * Created by StrikerRocker on 20/4/18.
 */
public class FluidMapper
{
    public static void mapFluids(Item item) {
        ItemStack stack = new ItemStack(item);
        if (isBucket(stack)) {
            FluidStack fluidStack = FluidUtil.getFluidContained(stack);
            int density = 0;
            if(fluidStack!=null) density = fluidStack.getFluid().getDensity();
            ItemWeight.setWeight(item, density);
        }
    }

    public static boolean isBucket(@Nonnull ItemStack itemStack) {
        IFluidHandler fluidHandler = FluidUtil.getFluidHandler(itemStack);
        if (fluidHandler == null) {
            return false;
        }
        return true;
    }
}

