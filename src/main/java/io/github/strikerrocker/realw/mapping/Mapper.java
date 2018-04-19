package io.github.strikerrocker.realw.mapping;

import io.github.strikerrocker.realw.api.ItemWeight;
import io.github.strikerrocker.realw.handlers.ConfigHandler;
import io.github.strikerrocker.realw.utils.JSONUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import static net.minecraftforge.fml.common.registry.ForgeRegistries.ITEMS;

public class Mapper
{
    public static void init(File file) {
        for (Item item : ITEMS.getValuesCollection()) {
            NonNullList<ItemStack> list = NonNullList.create();
            item.getSubItems(CreativeTabs.SEARCH, list);
            for (ItemStack stack : list) {
                int meta = stack.getMetadata();
                if (ConfigHandler.doMapping) {
                    ItemWeight.setWeight(item, meta, 1);
                } else {
                    try {
                        Map<String, Integer> newMap = JSONUtils.readFromJson(file);
                        Integer itemWeight = newMap.get(item.getRegistryName().toString() + ":" + meta);
                        if (itemWeight != 0) {
                            ItemWeight.setWeight(item, meta, itemWeight);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.print(e);
                    }
                }
            }
        }
        ItemWeight.setWeight(Items.AIR, 0);
    }
}