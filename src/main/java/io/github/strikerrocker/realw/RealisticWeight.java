package io.github.strikerrocker.realw;

import io.github.strikerrocker.realw.mapping.Mapper;
import io.github.strikerrocker.realw.proxies.CommonProxy;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
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
    public static File CONFIG_DIR;
    public static File PREGENERATED_WEIGHT_FILE;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        CONFIG_DIR = new File(event.getModConfigurationDirectory(), NAME);
        if (!CONFIG_DIR.exists()) CONFIG_DIR.mkdirs();
        PREGENERATED_WEIGHT_FILE = new File(CONFIG_DIR, "Weight.json");
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        proxy.init(event);
        Mapper.init();
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(MOD_ID))
            ConfigManager.sync(MOD_ID, Config.Type.INSTANCE);
    }
}
