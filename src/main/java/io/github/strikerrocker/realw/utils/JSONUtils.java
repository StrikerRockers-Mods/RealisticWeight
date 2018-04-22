package io.github.strikerrocker.realw.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import io.github.strikerrocker.realw.api.ItemWeight;
import io.github.strikerrocker.realw.api.ItemWeight.Weight;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.TreeMap;

public class JSONUtils {
    private static final TypeAdapter<Weight> WEIGHT_TYPE_ADAPTER = new TypeAdapter<Weight>() {

        String WEIGHT = "weight";

        @Override
        public void write(JsonWriter out, Weight value) throws IOException {
            out.beginObject();
            out.name(WEIGHT);
            return;
        }

        @Override
        public Weight read(JsonReader in) throws IOException {
            Weight weight = null;
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            in.beginObject();
            while (in.peek() != JsonToken.END_OBJECT) {
                String name = in.nextName();
                String value = in.nextString();
                if (WEIGHT.equals(name)) {
                }
            }
            return weight;
        }
    };

    public static void writeDefaults(File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Map<String, Weight> map = new TreeMap<>(ItemWeight.getMap());
            String json = gson.toJson(map);
            writer.print(json);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static Map<String, Integer> readFromJson(File file) throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type map = new TypeToken<Map<String, Weight>>() {
        }.getType();
        return gson.fromJson(new FileReader(file), map);
    }
}