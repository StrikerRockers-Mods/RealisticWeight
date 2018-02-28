package io.github.strikerrocker.realw.handlers;

import net.minecraftforge.common.config.Config;

import static io.github.strikerrocker.realw.Constants.MOD_ID;
import static io.github.strikerrocker.realw.Constants.NAME;

@Config(modid = MOD_ID, name = NAME + "/" + NAME)
public class ConfigHandler {
    @Config.Comment("Set's the game-mode of the mod. True = normal mode ,False = HardCoreMode")
    @Config.Name("GameMode")
    public static boolean gamemode = true;
    @Config.Comment("Set this to false if u want to only run the mapping once. Reduces the loading time")
    @Config.RequiresMcRestart
    @Config.Name("Mapping's")
    public static boolean doMapping = true;
    @Config.Comment("Maximum weight a player can handle before he/she get's de-buff")
    @Config.RangeInt(min = 0)
    @Config.Name("Max player weight")
    public static int weight = 10000;
}
