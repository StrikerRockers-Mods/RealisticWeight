package io.github.strikerrocker.realw.api;

import io.github.strikerrocker.realw.api.gamestages.GameStageCompat;
import io.github.strikerrocker.realw.api.gamestages.GameStageCompatDummy;
import io.github.strikerrocker.realw.api.gamestages.IGameStageCompat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"all"})
public class ItemWeight {
    private static boolean gamestage;

    static {
        gamestage = Loader.isModLoaded("gamestages");
    }

    /**
     * Stores the weight for all item's
     */
    private static Map<String, Integer> weights = new HashMap<>();

    /**
     * Return's the weight map
     *
     * @return the weight map
     */
    public static Map<String, Integer> getMap() {
        return new HashMap<>(weights);
    }


    /**
     * Returns the weight for the given item's
     *
     * @param item The item to return weight for
     * @return The weight of the item
     */
    public static int getWeight(Item item) {
        return getWeight(item, 0);
    }

    /**
     * Returns the weight for the given item's
     *
     * @param item The item to return weight for
     * @param meta The meta of the item to return weight for
     * @return The weight of the item
     */
    public static int getWeight(Item item, int meta) {
        Integer itemWeight = weights.get(item.getRegistryName().toString() + ":" + meta);
        return itemWeight == null ? 0 : itemWeight;
    }

    /**
     * Returns the weight for the given item's
     *
     * @param item  The item to return weight for
     * @param meta  The meta of the item to return weight for
     * @param stage The stage of the item
     * @return The weight of the item
     */
    public static int getWeight(Item item, int meta, String stage) {
        if (gamestage) {
            Integer itemWeight = weights.get(item.getRegistryName().toString() + ":" + meta + stage);
            return itemWeight == null ? 0 : itemWeight;
        }
        return 0;
    }

    /**
     * Returns the weight for the given item's
     *
     * @param item  The item to return weight for
     * @param stage The stage of the item
     * @return The weight of the item
     */
    public static int getWeight(Item item, String stage) {
        return getWeight(item, stage);
    }

    /**
     * Returns the weight of the item in the Itemstack
     *
     * @param itemStack The item to return weight for
     * @return The weight of the item
     */
    public static int getWeight(ItemStack itemStack) {
        return getWeight(itemStack.getItem(), itemStack.getMetadata());
    }

    /**
     * Return's the stack weight for the given stack
     *
     * @param stack The stack to return weight for
     * @return The weight of the stack
     */
    public static int getStackWeight(ItemStack stack, EntityPlayer player) {
        if (gamestage) {
            IGameStageCompat compat;
            if (gamestage) {
                compat = new GameStageCompat();
            } else {
                compat = new GameStageCompatDummy();
            }
            for (String stage : compat.getStages(player)) {
                ArrayList<Integer> weight = new ArrayList<>();
                weight.add(getWeight(stack.getItem(), stack.getMetadata(), stage));
                return Collections.max(weight);
            }
        }
        return 0;
    }

    /**
     * Return's the stack weight for the given stack
     *
     * @param stack The stack to return weight for
     * @return The weight of the stack
     */
    public static int getStackWeight(ItemStack stack) {
        return getWeight(stack) * stack.getCount();
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
        weights.put(item.getRegistryName().toString() + ":" + meta, weight);
    }

    /**
     * Set's the weight for the given item with game stage
     * <p>
     * Doesnt work if gamestage isn't present
     *
     * @param item   The item to set weight for
     * @param weight The weight to set for the item
     * @param meta   The Metadata of the item to set weight for
     * @param stage  The stage for the weight
     */
    public static void setWeight(Item item, int meta, String stage, int weight) {
        if (gamestage) weights.put(item.getRegistryName().toString() + ":" + meta + ":" + stage, weight);
    }

    /**
     * Set's the weight for the given item with game stage
     * <p>
     * Doesnt work if gamestage isn't present
     *
     * @param item   The item to set weight for
     * @param weight The weight to set for the item
     * @param stage  The stage for the weight
     */
    public static void setWeight(Item item, String stage, int weight) {
        setWeight(item, 0, stage, weight);
    }

    /**
     * Set's the weight for the given item
     * <p>
     * Don't use this during runtime may cause issue's
     *
     * @param itemStack The itemStack
     * @param weight    The weight
     */
    public static void setWeight(ItemStack itemStack, String stage, int weight) {
        setWeight(itemStack.getItem(), itemStack.getMetadata(), stage, weight);
    }
}