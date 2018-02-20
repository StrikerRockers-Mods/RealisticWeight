package io.github.strikerrocker.realw.proxies;

import io.github.strikerrocker.realw.api.IItemWeight;
import io.github.strikerrocker.realw.api.IWeight;
import io.github.strikerrocker.realw.capability.ItemWeight;
import io.github.strikerrocker.realw.capability.Weight;
import io.github.strikerrocker.realw.capability.storage.ItemWeightStorage;
import io.github.strikerrocker.realw.capability.storage.WeightStorage;
import io.github.strikerrocker.realw.events.CapabilityEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class CommonProxy {
    public void init(FMLInitializationEvent event) {
        CapabilityManager.INSTANCE.register(IWeight.class, new WeightStorage(), Weight.class);
        CapabilityManager.INSTANCE.register(IItemWeight.class, new ItemWeightStorage(), ItemWeight.class);
        MinecraftForge.EVENT_BUS.register(new CapabilityEvents());
    }
}
