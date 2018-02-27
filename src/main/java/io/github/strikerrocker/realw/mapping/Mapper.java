package io.github.strikerrocker.realw.mapping;

import io.github.strikerrocker.realw.api.ItemWeight;
import io.github.strikerrocker.realw.handlers.ConfigHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import static net.minecraftforge.fml.common.registry.ForgeRegistries.ITEMS;

public class Mapper {
    public static void init() {
        for (Item item : ITEMS.getValuesCollection()) {
            if (ConfigHandler.doMapping) {
                ItemWeight.setWeight(item, 1);
                if (item instanceof ItemBlock) {
                    MaterialMapper.init(item);
                }
            }
        }
    }
}
