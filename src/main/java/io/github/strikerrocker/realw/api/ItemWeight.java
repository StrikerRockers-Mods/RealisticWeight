package io.github.strikerrocker.realw.api;

import io.github.strikerrocker.realw.handlers.ConfigHandler;
import io.github.strikerrocker.realw.integrations.gamestages.GameStagesSupport;
import net.darkhax.gamestages.capabilities.PlayerDataHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"unused"})
public class ItemWeight {
    /**
     * Stores the weight for all item's
     */
    private static Map<String, Weight> weights = new HashMap<>();

    /**
     * Returns the weight for the given item's
     *
     * @param item The item to return weight for
     * @return The weight of the item
     */
    public static int getWeight(Item item, EntityPlayer player) {
        return getWeight(item, 0, player);
    }

    /**
     * Returns the weight for the given item's
     *
     * @param item The item to return weight for
     * @param meta The meta of the item to return weight for
     * @return The weight of the item
     */
    public static int getWeight(Item item, int meta, EntityPlayer player) {
        Weight itemWeight = weights.get(item.getRegistryName().toString() + ":" + meta);
        if (itemWeight == null) weights.get(item.getRegistryName().toString() + ":" + "0");
        return itemWeight == null ? 0 : itemWeight.getWeight(player);
    }

    /**
     * Returns the weight of the item in the Itemstack
     *
     * @param itemStack The item to return weight for
     * @return The weight of the item
     */
    public static int getWeight(ItemStack itemStack, EntityPlayer player) {
        return getWeight(itemStack.getItem(), itemStack.getMetadata(), player);
    }

    /**
     * Return's the stack weight for the given stack
     *
     * @param stack The stack to return weight for
     * @return The weight of the stack
     */
    public static int getStackWeight(ItemStack stack, EntityPlayer player) {
        return getWeight(stack, player) * stack.getCount();
    }

    /**
     * Return's the inventory weight for the given inventory
     *
     * @param inventory The inventory to return weight for
     * @return The weight of the inventory
     */
    public static int getInventoryWeight(IInventory inventory, EntityPlayer player) {
        int weight = 0;
        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            ItemStack stack = inventory.getStackInSlot(i);
            if (!(stack == ItemStack.EMPTY) && !(stack.isEmpty())) {
                weight += getStackWeight(stack, player);
            }
        }
        return weight;
    }

    /**
     * Set's the weight for the given item
     * <p>
     * Don't use this during runtime may cause issue's
     *
     * @param item   The item to set weight for
     * @param weight The weight to set
     */
    public static void setWeight(Item item, int weight) {
        setWeight(item, 0, weight);
    }

    /**
     * Set's the weight for the given item
     * <p>
     * Don't use this during runtime may cause issue's
     *
     * @param itemStack The itemStack
     * @param weight    The weight
     */
    public static void setWeight(ItemStack itemStack, int weight) {
        setWeight(itemStack.getItem(), itemStack.getMetadata(), weight);
    }

    /**
     * Set's the weight for the given item
     * <p>
     * Don't use this during runtime may cause issue's
     *
     * @param item   The item to set weight for
     * @param weight The weight to set for the item
     * @param meta   The Metadata of the item to set weight for
     */
    public static void setWeight(Item item, int meta, int weight) {
        String key = item.getRegistryName().toString() + ":" + meta;
        if (weights.containsKey(key)) {
            weights.get(key).setDefaultWeight(weight);
        } else {
            weights.put(key, new Weight(weight));
        }
    }

    /**
     * Set's the weight for the given item with a stage
     * <p>
     * Don't use this during runtime may cause issue's
     *
     * @param item   The item to set weight for
     * @param stage  the Stage to set the weight for
     * @param weight The weight to set
     */
    public static void setWeightWithStage(Item item, String stage, int weight) {
        setWeightWithStage(item, 0, stage, weight);
    }

    /**
     * Set's the weight for the given item withc a stage
     * <p>
     * Don't use this during runtime may cause issue's
     *
     * @param itemStack The itemStack
     * @param stage     the Stage to set the weight for
     * @param weight    The weight
     */
    public static void setWeightWithStage(ItemStack itemStack, String stage, int weight) {
        setWeightWithStage(itemStack.getItem(), itemStack.getMetadata(), stage, weight);
    }

    /**
     * Set's the weight for the given item with a stage
     * <p>
     * Don't use this during runtime may cause issue's
     *
     * @param item   The item to set weight for
     * @param meta   The Metadata of the item to set weight for
     * @param stage  the Stage to set the weight for
     * @param weight The weight to set for the item
     */
    public static void setWeightWithStage(Item item, int meta, String stage, int weight) {
        String key = item.getRegistryName().toString() + ":" + meta;
        if (weights.containsKey(key)) {
            weights.get(key).setWeight(stage, weight);
        } else {
            weights.put(key, new Weight(0).setWeight(stage, weight));
        }
    }

    /**
     * Return's the weight map
     *
     * @return Map
     */
    public static Map<String, Weight> getMap() {
        return new HashMap<>(weights);
    }

    public static class Weight {

        private Map<String, Integer> weights = new HashMap<>();
        private int defaultWeight;

        private Weight(int defaultWeight) {
            this.defaultWeight = defaultWeight;
        }

        public void setDefaultWeight(int weight) {
            this.defaultWeight = weight;
        }

        public int getDefaultWeight() {
            return defaultWeight;
        }

        public Weight setWeight(String stage, int weight) {
            weights.put(stage, weight);
            return new Weight(0).setWeight(stage, weight);
        }

        public Integer getWeight(String stage) {
            return weights.get(stage);
        }

        public int getWeight(EntityPlayer player) {
            String priorityMethod = ConfigHandler.gameStagesSupportConfig.priorityMethod;
            PlayerDataHandler.IStageData stageData = PlayerDataHandler.getStageData(player);
            int weight = getDefaultWeight();
            int priority = -1;
            for (String stage : stageData.getUnlockedStages()) {
                if (getWeight(stage) != null) {
                    if ("biggest".equals(priorityMethod)) {
                        if (getWeight(stage) > weight) weight = getWeight(stage);
                    } else if ("smallest".equals(priorityMethod)) {
                        if (getWeight(stage) < weight) weight = getWeight(stage);
                    } else if ("list".equals(priorityMethod)) {
                        if (GameStagesSupport.priorityList.indexOf(stage) > priority) weight = getWeight(stage);
                    }
                }
            }
            return weight;
        }
    }
}
