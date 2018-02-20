package io.github.strikerrocker.realw;

import io.github.strikerrocker.realw.proxies.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import static io.github.strikerrocker.realw.Constants.*;

@Mod(modid = MOD_ID, name = NAME, version = VERSION)
public class RealisticWeight {

    @SidedProxy(serverSide = PACKAGE_LOCATION + "proxies.CommonProxy", clientSide = PACKAGE_LOCATION + "proxies.ClientProxy", modId = MOD_ID)
    CommonProxy proxy;

    @Mod.Instance(MOD_ID)
    static RealisticWeight instance;
    private static Logger logger;

    public static void logInfo(String message) {
        logger.info("RealisticWeight : " + message);
    }

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        logInfo("Pre-Initialization Complete");
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        proxy.init(event);
        Mapper.init();
        logInfo("Initialization Complete");
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        logInfo("Post-Initialization Complete");
    }
}
