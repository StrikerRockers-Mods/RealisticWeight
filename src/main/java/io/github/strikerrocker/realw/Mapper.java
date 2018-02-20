package io.github.strikerrocker.realw;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import static net.minecraftforge.fml.common.registry.ForgeRegistries.ITEMS;

public class Mapper {
    public static void init() {
        for (Item item : ITEMS.getValuesCollection()) {
            if (item instanceof ItemBlock) {
                Material mat = ((ItemBlock) item).getBlock().getMaterial(((ItemBlock) item).getBlock().getDefaultState());
            } else {

            }
        }
    }
}
