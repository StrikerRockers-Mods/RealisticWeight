package io.github.strikerrocker.realw.mapping;

import io.github.strikerrocker.realw.api.ItemWeight;
import io.github.strikerrocker.realw.handlers.ConfigHandler;
import io.github.strikerrocker.realw.utils.JSONUtils;
import javafx.util.Pair;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAir;
import net.minecraft.nbt.NBTTagCompound;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import static net.minecraftforge.fml.common.registry.ForgeRegistries.ITEMS;

public class Mapper
{
    public static void init(File file) {
        for (Item item : ITEMS.getValuesCollection()) {
            if (ConfigHandler.doMapping) {
                ItemWeight.setWeight(item, 1);

                if (item instanceof ItemAir) {
                    ItemWeight.setWeight(item, 0);
                }
            } else {
                try {
                    Map<String, Map<Pair<Integer, NBTTagCompound>, Integer>> newMap = JSONUtils.readFromJson(file);
                    newMap.get(item).get(new Pair<>(0, null));
                } catch (FileNotFoundException e) {
                    System.out.print(e);
                }
            }
        }
    }
}