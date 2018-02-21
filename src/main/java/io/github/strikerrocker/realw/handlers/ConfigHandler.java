package io.github.strikerrocker.realw.handlers;

import io.github.strikerrocker.realw.Constants;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID)
public class ConfigHandler {
    public static Configuration config;

    public static boolean gamemode;
    public static boolean doMapping;
    public static int weight;

    /**
     * Initializes the config handler for VanillaTweaks
     *
     * @param configFile The configuration file (fetched from the FMLPreInitializationEvent)
     */
    public static void init(File configFile) {
        config = new Configuration(configFile);
        config.load();
        syncConfig();
    }

    /**
     * Syncs the config file if it changes
     *
     * @param event The OnConfigChangedEvent
     */
    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Constants.MOD_ID))
            ConfigHandler.syncConfig();
    }

    private static void syncConfig() {
        String GeneralCategory = Configuration.CATEGORY_GENERAL;
        gamemode = get(GeneralCategory, "GameMode", true, "Set's the game-mode of the mod. True = normal mode ,False = HardCoreMode");
        doMapping = get(GeneralCategory, "mapping", true, "Set this to false if u want to only run the mapping once. Reduces the loading time");
        weight = get(GeneralCategory, "Max Player Weight", 10000, "Maximum weight a player can handle before he/she get's de-buff", true).setMinValue(100).setMaxValue(Integer.MAX_VALUE).getInt();
    }

    private static Property get(String category, String key, double defaultValue, String comment, boolean slider) {
        Property property = config.get(category, key, defaultValue, comment);
        if (slider && FMLCommonHandler.instance().getEffectiveSide().isClient())
            return property.setConfigEntryClass(GuiConfigEntries.NumberSliderEntry.class);
        return property;
    }

    private static Property get(String category, String key, int defaultValue, String comment, boolean slider) {
        Property property = config.get(category, key, defaultValue, comment);
        if (slider && FMLCommonHandler.instance().getEffectiveSide().isClient())
            return property.setConfigEntryClass(GuiConfigEntries.NumberSliderEntry.class);
        return property;
    }

    private static boolean get(String category, String key, boolean defaultValue, String comment) {
        return config.get(category, key, defaultValue, comment).getBoolean();
    }
}
