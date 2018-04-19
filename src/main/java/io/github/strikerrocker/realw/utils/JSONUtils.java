package io.github.strikerrocker.realw.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import io.github.strikerrocker.realw.api.ItemWeight;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.TreeMap;

public class JSONUtils
{
    public static void writeDefaults(File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Map<String, Integer> map = new TreeMap<>(ItemWeight.getMap());
            String json = gson.toJson(map);
            writer.print(json);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static Map<String, Integer> readFromJson(File file) throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type map = new TypeToken<Map<String, Integer>>()
        {
        }.getType();
        return gson.fromJson(new FileReader(file), map);
    }
}