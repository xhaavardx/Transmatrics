package at.korti.transmatrics.registry;

import at.korti.transmatrics.api.crafting.PulverizerCraftingRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import static at.korti.transmatrics.api.Constants.TransmatricsItem.PULVERIZED_DUST;
import static at.korti.transmatrics.api.Constants.TransmatricsBlock.ORE_BLOCK;
import static at.korti.transmatrics.api.Constants.TransmatricsItem.INGOT;

/**
 * Created by Korti on 16.03.2016.
 */
public final class Crafting {

    public static void register() {
        registerPulverizerCrafting();
        registerFurnaceCrafting();
    }

    private static void registerPulverizerCrafting() {
        PulverizerCraftingRegistry.getInstance().register(new ItemStack(Blocks.cobblestone), 20 * 6, 0.25f, new ItemStack(Blocks.gravel), new ItemStack(Blocks.gravel));
        PulverizerCraftingRegistry.getInstance().register(new ItemStack(Blocks.gravel), 20 * 6, 0.25f, new ItemStack(Blocks.sand), new ItemStack(Blocks.sand));
        PulverizerCraftingRegistry.getInstance().register(new ItemStack(Blocks.diamond_ore), 20 * 12, 0.05f, new ItemStack(Items.diamond, 2), new ItemStack(Items.diamond, 1));
        PulverizerCraftingRegistry.getInstance().register(new ItemStack(Blocks.redstone_ore), 20 * 11, 0.15f, new ItemStack(Items.redstone, 8), new ItemStack(Items.redstone, 2));
        PulverizerCraftingRegistry.getInstance().register(new ItemStack(Blocks.lapis_ore), 20 * 10, 0.20f, new ItemStack(Items.dye, 8, 4), new ItemStack(Items.dye, 2, 4));

        PulverizerCraftingRegistry.getInstance().register(new ItemStack(Blocks.iron_ore), 20 * 7, new ItemStack(PULVERIZED_DUST.getItem(), 2, 0));
        PulverizerCraftingRegistry.getInstance().register(new ItemStack(Blocks.gold_ore), 20 * 9, new ItemStack(PULVERIZED_DUST.getItem(), 2, 1));

        PulverizerCraftingRegistry.getInstance().register(new ItemStack(ORE_BLOCK.getBlock(), 1, 0), 20 * 8, new ItemStack(PULVERIZED_DUST.getItem(), 2, 2));
        PulverizerCraftingRegistry.getInstance().register(new ItemStack(ORE_BLOCK.getBlock(), 1, 1), 20 * 8, new ItemStack(PULVERIZED_DUST.getItem(), 2, 3));
        PulverizerCraftingRegistry.getInstance().register(new ItemStack(ORE_BLOCK.getBlock(), 1, 2), 20 * 10, new ItemStack(PULVERIZED_DUST.getItem(), 2, 4));
        PulverizerCraftingRegistry.getInstance().register(new ItemStack(ORE_BLOCK.getBlock(), 1, 3), 20 * 10, new ItemStack(PULVERIZED_DUST.getItem(), 2, 5));
    }

    private static void registerFurnaceCrafting() {
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(PULVERIZED_DUST.getItem(), 1, 0), new ItemStack(Items.iron_ingot), 0.7F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(PULVERIZED_DUST.getItem(), 1, 1), new ItemStack(Items.gold_ingot), 1.0F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(PULVERIZED_DUST.getItem(), 1, 2), new ItemStack(INGOT.getItem(), 1, 0), 0.5F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(PULVERIZED_DUST.getItem(), 1, 3), new ItemStack(INGOT.getItem(), 1, 1), 0.6F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(PULVERIZED_DUST.getItem(), 1, 4), new ItemStack(INGOT.getItem(), 1, 2), 0.9F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(PULVERIZED_DUST.getItem(), 1, 5), new ItemStack(INGOT.getItem(), 1, 3), 0.9F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ORE_BLOCK.getBlock(), 1, 0), new ItemStack(INGOT.getItem(), 1, 0), 0.5F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ORE_BLOCK.getBlock(), 1, 1), new ItemStack(INGOT.getItem(), 1, 1), 0.6F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ORE_BLOCK.getBlock(), 1, 2), new ItemStack(INGOT.getItem(), 1, 2), 0.9F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ORE_BLOCK.getBlock(), 1, 3), new ItemStack(INGOT.getItem(), 1, 3), 0.9F);
    }

}
