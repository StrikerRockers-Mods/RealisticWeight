package io.github.strikerrocker.realw;

import io.github.strikerrocker.realw.proxies.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static io.github.strikerrocker.realw.Constants.*;

@Mod(modid = MOD_ID, name = NAME, version = VERSION)
public class RealisticWeight {

    @SidedProxy(serverSide = PACKAGE_LOCATION + ".proxies.CommonProxy", clientSide = PACKAGE_LOCATION + ".proxies.ClientProxy", modId = MOD_ID)
    public static CommonProxy proxy;

    @Mod.Instance(MOD_ID)
    public static RealisticWeight instance;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        proxy.init(event);
        Mapper.init();
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
    }
}
