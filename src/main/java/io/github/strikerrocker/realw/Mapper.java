package io.github.strikerrocker.realw;

import io.github.strikerrocker.realw.api.ItemWeight;
import net.minecraft.item.Item;

import static net.minecraftforge.fml.common.registry.ForgeRegistries.ITEMS;

public class Mapper {
    public static void init() {
        for (Item item : ITEMS.getValuesCollection()) {
            ItemWeight.setWeight(item, 1);
        }
    }
}
