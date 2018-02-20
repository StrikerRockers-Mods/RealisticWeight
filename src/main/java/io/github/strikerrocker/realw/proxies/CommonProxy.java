package io.github.strikerrocker.realw.proxies;

import io.github.strikerrocker.realw.api.IWeight;
import io.github.strikerrocker.realw.capability.Weight;
import io.github.strikerrocker.realw.capability.storage.WeightStorage;
import io.github.strikerrocker.realw.events.CapabilityEvents;
import io.github.strikerrocker.realw.events.PlayerEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class CommonProxy {
    public void init(FMLInitializationEvent event) {
        CapabilityManager.INSTANCE.register(IWeight.class, new WeightStorage(), Weight.class);
        MinecraftForge.EVENT_BUS.register(new CapabilityEvents());
        MinecraftForge.EVENT_BUS.register(new PlayerEvents());
    }
}
