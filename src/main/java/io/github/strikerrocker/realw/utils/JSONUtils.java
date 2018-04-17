package io.github.strikerrocker.realw.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import io.github.strikerrocker.realw.api.ItemWeight;
import javafx.util.Pair;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.Map;

public class JSONUtils
{

    public static final TypeAdapter<Item> ITEM_TYPE_ADAPTER = new TypeAdapter<Item>()
    {
        String NAME = "item";

        @Override
        public void write(JsonWriter out, Item value) throws IOException {
            out.beginObject();
            out.name(NAME);
            out.value(value.getRegistryName().toString());
            return;
        }

        @Override
        public Item read(JsonReader in) throws IOException {
            Item item = null;
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            in.beginObject();
            while (in.peek() != JsonToken.END_OBJECT) {
                String name = in.nextName();
                String value = in.nextString();
                if (NAME.equals(name)) {
                    item = Item.getByNameOrId(value);
                }
            }
            return item;
        }
    };


    public static void writeDefaults(File file) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            System.out.print(e);
            return;
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(ItemWeight.getMap());
        writer.print(json);
        writer.close();
    }

    public static Map<Item, Map<Pair<Integer, NBTTagCompound>, Integer>> readFromJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type map = new TypeToken<Map<Item, Map<Pair<Integer, NBTTagCompound>, Integer>>>()
        {
        }.getType();
        Map<Item, Map<Pair<Integer, NBTTagCompound>, Integer>> newMap = gson.fromJson(, map);
        return newMap;
    }
}
