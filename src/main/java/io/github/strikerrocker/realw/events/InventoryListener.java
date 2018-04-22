package io.github.strikerrocker.realw.events;

import io.github.strikerrocker.realw.api.ItemWeight;
import io.github.strikerrocker.realw.api.player_weight.IWeight;
import io.github.strikerrocker.realw.api.player_weight.WeightProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.ArrayList;
import java.util.List;

public class InventoryListener implements IContainerListener {

    private final EntityPlayerMP owner;

    InventoryListener(EntityPlayerMP owner) {
        this.owner = owner;
    }


    @Override
    public void sendAllContents(Container containerToSend, NonNullList<ItemStack> itemsList) {
    }

    @Override
    public void sendSlotContents(Container containerToSend, int slotInd, ItemStack stack) {
        updateWeight(owner);
    }

    @Override
    public void sendWindowProperty(Container containerIn, int varToUpdate, int newValue) {

    }

    @Override
    public void sendAllWindowProperties(Container containerIn, IInventory inventory) {

    }

    private void updateWeight(EntityPlayer player) {
        if (player != null) {
            IWeight pWeight = player.getCapability(WeightProvider.WEIGHT_CAP, null);
            List<ItemStack> inventory = new ArrayList<>(player.inventory.mainInventory);
            pWeight.setWeight(1);
            inventory.addAll(player.inventory.offHandInventory);
            inventory.addAll(player.inventory.armorInventory);
            int a = 1;
            for (ItemStack stack : inventory) {
                if (!(stack.getItem().isDamageable())) {
                    int i = ItemWeight.getStackWeight(stack, player);
                    a = a + i;
                } else {
                    int damage = (stack.getMaxDamage() - stack.getItemDamage()) / stack.getMaxDamage();
                    int w = ItemWeight.getWeight(stack.getItem(), player);
                    a = a + w + damage;
                }
            }
            int added = ((pWeight.getWeight() - pWeight.getApiWeight()) - a);
            pWeight.addWeight(added);
        }
    }
}
