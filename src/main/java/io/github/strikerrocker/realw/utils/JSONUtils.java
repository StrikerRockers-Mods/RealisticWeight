package io.github.strikerrocker.realw.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import io.github.strikerrocker.realw.api.ItemWeight;
import javafx.util.Pair;
import net.minecraft.nbt.NBTTagCompound;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.Map;

public class JSONUtils
{
    public static void writeDefaults(File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(ItemWeight.getMap());
            writer.print(json);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static Map<String, Map<Pair<Integer, NBTTagCompound>, Integer>> readFromJson(File file) throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type map = new TypeToken<Map<String, Map<Pair<Integer, NBTTagCompound>, Integer>>>()
        {
        }.getType();
        Map<String, Map<Pair<Integer, NBTTagCompound>, Integer>> newMap = gson.fromJson(new FileReader(file), map);
        return newMap;
    }
}
