package io.github.strikerrocker.realw.integrations.crafttweaker;

import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import io.github.strikerrocker.realw.api.ItemWeight;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@SuppressWarnings("unused")
@ZenClass("mods.realisticweight")
public class CrafttweakerSupport
{
    @ZenMethod
    public static void setWeight(IIngredient item, int weight) {
        for (IItemStack stack : item.getItems()) {
            ItemWeight.setWeight(CraftTweakerMC.getItemStack(stack), weight);
        }
    }
}
