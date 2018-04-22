package io.github.strikerrocker.realw;

import crafttweaker.CraftTweakerAPI;
import io.github.strikerrocker.realw.integrations.crafttweaker.CrafttweakerSupport;
import io.github.strikerrocker.realw.integrations.gamestages.GameStagesSupport;
import io.github.strikerrocker.realw.mapping.Mapper;
import io.github.strikerrocker.realw.proxies.CommonProxy;
import io.github.strikerrocker.realw.utils.JSONUtils;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

import static io.github.strikerrocker.realw.Constants.*;

@Mod(modid = MOD_ID, name = NAME, version = VERSION)
@Mod.EventBusSubscriber(modid = MOD_ID)
public class RealisticWeight {

    @SidedProxy(serverSide = PACKAGE_LOCATION + ".proxies.CommonProxy", clientSide = PACKAGE_LOCATION + ".proxies.ClientProxy", modId = MOD_ID)
    public static CommonProxy proxy;

    @Mod.Instance(MOD_ID)
    public static RealisticWeight instance;
    public static File PRE_GENERATED_WEIGHT_FILE;

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(MOD_ID)) {
            ConfigManager.sync(MOD_ID, Config.Type.INSTANCE);
            if (Loader.isModLoaded("gamestages")) GameStagesSupport.loadConfig();
        }
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        proxy.init(event);
        Mapper.init(PRE_GENERATED_WEIGHT_FILE);
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        JSONUtils.writeDefaults(PRE_GENERATED_WEIGHT_FILE);
    }

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        PRE_GENERATED_WEIGHT_FILE = new File(new File(event.getModConfigurationDirectory(), NAME), "Weight.json");
        if (Loader.isModLoaded("crafttweaker")) CraftTweakerAPI.registerClass(CrafttweakerSupport.class);
        if (Loader.isModLoaded("gamestages")) GameStagesSupport.load();
    }
}