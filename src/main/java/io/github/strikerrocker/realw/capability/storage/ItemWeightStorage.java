package io.github.strikerrocker.realw.capability.storage;

import io.github.strikerrocker.realw.api.IItemWeight;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class ItemWeightStorage implements Capability.IStorage<IItemWeight> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IItemWeight> capability, IItemWeight instance, EnumFacing side) {
        return new NBTTagInt(instance.getWeight());
    }

    @Override
    public void readNBT(Capability<IItemWeight> capability, IItemWeight instance, EnumFacing side, NBTBase nbt) {
        instance.setWeight(((NBTPrimitive) nbt).getInt());
    }
}
