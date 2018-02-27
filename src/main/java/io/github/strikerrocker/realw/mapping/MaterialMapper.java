package io.github.strikerrocker.realw.mapping;

import io.github.strikerrocker.realw.api.ItemWeight;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

/**
 * This is experimental
 */
public class MaterialMapper {
    public static void init(Item item) {
        Block block = ((ItemBlock) item).getBlock();
        Material material = block.getMaterial(block.getDefaultState());
        if (material == Material.AIR) {
            ItemWeight.setWeight(item, 0);
        }
        if (material == Material.ANVIL) {
            ItemWeight.setWeight(item, 1000);
        }
        if (material == Material.BARRIER) {
            ItemWeight.setWeight(item, 10000000);
        }
        if (material == Material.CACTUS) {
            ItemWeight.setWeight(item, 100);
        }
        if (material == Material.CAKE) {
            ItemWeight.setWeight(item, 100);
        }
        if (material == Material.CARPET) {
            ItemWeight.setWeight(item, 50);
        }
        if (material == Material.CIRCUITS) {
            ItemWeight.setWeight(item, 100);
        }
        if (material == Material.CLAY) {
            ItemWeight.setWeight(item, 300);
        }
        if (material == Material.CLOTH) {
            ItemWeight.setWeight(item, 50);
        }
        if (material == Material.CORAL) {
            ItemWeight.setWeight(item, 150);
        }
        if (material == Material.CRAFTED_SNOW) {
            ItemWeight.setWeight(item, 200);
        }
        if (material == Material.DRAGON_EGG) {
            ItemWeight.setWeight(item, 1000);
        }
        if (material == Material.GLASS) {
            ItemWeight.setWeight(item, 150);
        }
        if (material == Material.GOURD) {
            ItemWeight.setWeight(item, 100);
        }
        if (material == Material.GRASS) {
            ItemWeight.setWeight(item, 30);
        }
        if (material == Material.GROUND) {
            ItemWeight.setWeight(item, 200);
        }
        if (material == Material.ICE) {
            ItemWeight.setWeight(item, 150);
        }
        if (material == Material.IRON) {
            ItemWeight.setWeight(item, 400);
        }
        if (material == Material.LEAVES) {
            ItemWeight.setWeight(item, 75);
        }
        if (material == Material.PACKED_ICE) {
            ItemWeight.setWeight(item, 300);
        }
        if (material == Material.PISTON) {
            ItemWeight.setWeight(item, 150);
        }
        if (material == Material.PLANTS) {
            ItemWeight.setWeight(item, 40);
        }
        if (material == Material.REDSTONE_LIGHT) {
            ItemWeight.setWeight(item, 200);
        }
        if (material == Material.ROCK) {
            ItemWeight.setWeight(item, 200);
        }
        if (material == Material.SAND) {
            ItemWeight.setWeight(item, 75);
        }
        if (material == Material.SNOW) {
            ItemWeight.setWeight(item, 100);
        }
        if (material == Material.SPONGE) {
            ItemWeight.setWeight(item, 250);
        }
        if (material == Material.STRUCTURE_VOID) {
            ItemWeight.setWeight(item, 1000000);
        }
        if (material == Material.TNT) {
            ItemWeight.setWeight(item, 150);
        }
        if (material == Material.VINE) {
            ItemWeight.setWeight(item, 50);
        }
        if (material == Material.WEB) {
            ItemWeight.setWeight(item, 100);
        }
        if (material == Material.WOOD) {
            ItemWeight.setWeight(item, 200);
        }

    }
}
