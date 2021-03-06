package io.moonman.emergingtechnology.recipes;

import java.util.ArrayList;
import java.util.List;

import io.moonman.emergingtechnology.config.EmergingTechnologyConfig;
import io.moonman.emergingtechnology.init.ModBlocks;
import io.moonman.emergingtechnology.init.ModItems;
import io.moonman.emergingtechnology.recipes.classes.EmptyRecipe;
import io.moonman.emergingtechnology.recipes.machines.BiomassRecipeBuilder;
import io.moonman.emergingtechnology.recipes.machines.BioreactorRecipeBuilder;
import io.moonman.emergingtechnology.recipes.machines.CollectorRecipeBuilder;
import io.moonman.emergingtechnology.recipes.machines.CookerRecipeBuilder;
import io.moonman.emergingtechnology.recipes.machines.FabricatorRecipeBuilder;
import io.moonman.emergingtechnology.recipes.machines.ProcessorRecipeBuilder;
import io.moonman.emergingtechnology.recipes.machines.ScaffolderRecipeBuilder;
import io.moonman.emergingtechnology.recipes.machines.ShredderRecipeBuilder;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistryModifiable;

/**
 * Builds recipes for Emerging Technology. Used by machines and JEI if present
 */
public class RecipeBuilder {

    public static void buildMachineRecipes() {

        BioreactorRecipeBuilder.build();
        CollectorRecipeBuilder.build();
        CookerRecipeBuilder.build();
        ShredderRecipeBuilder.build();
        ScaffolderRecipeBuilder.build();
        ProcessorRecipeBuilder.build();
        FabricatorRecipeBuilder.build();
        BiomassRecipeBuilder.build();

        registerFurnaceRecipes();
    }

    private static void registerFurnaceRecipes() {
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.plasticblock),
                new ItemStack(ModItems.filament), 0.1f);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.shreddedplant),
                new ItemStack(ModItems.biomass), 0.1f);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.shreddedstarch),
                new ItemStack(ModItems.biomass), 0.1f);

        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.syntheticchickenraw),
                new ItemStack(ModItems.syntheticchickencooked), 0.2f);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.syntheticcowraw),
                new ItemStack(ModItems.syntheticcowcooked), 0.2f);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.syntheticpigraw),
                new ItemStack(ModItems.syntheticpigcooked), 0.2f);
    }

    public static List<ItemStack> buildRecipeList(List<ItemStack> itemStacks, List<String> oreNames) {
        List<ItemStack> result = new ArrayList<ItemStack>();

        for (ItemStack itemStack : itemStacks) {
            result.add(itemStack);
        }

        for (String oreName : oreNames) {
            List<ItemStack> oreItemStacks = OreDictionary.getOres(oreName);
            for (ItemStack itemStack : oreItemStacks) {
                result.add(itemStack);
            }
        }

        return result;
    }

    /**
     * Removes recipes for Emerging Technology based on configuration file
     */
    public static void removeRecipes(IForgeRegistryModifiable<IRecipe> registry) {

        ArrayList<Block> disabledBlocks = new ArrayList<Block>();

        if (EmergingTechnologyConfig.ELECTRICS_MODULE.SOLAR.disabled) disabledBlocks.add(ModBlocks.solar);
        if (EmergingTechnologyConfig.ELECTRICS_MODULE.WIND.disabled) disabledBlocks.add(ModBlocks.wind);
        if (EmergingTechnologyConfig.ELECTRICS_MODULE.BATTERY.disabled) disabledBlocks.add(ModBlocks.battery);
        if (EmergingTechnologyConfig.ELECTRICS_MODULE.TIDALGENERATOR.disabled) disabledBlocks.add(ModBlocks.tidalgenerator);
        if (EmergingTechnologyConfig.ELECTRICS_MODULE.PIEZOELECTRIC.disabled) disabledBlocks.add(ModBlocks.piezoelectric);
        if (EmergingTechnologyConfig.ELECTRICS_MODULE.BIOMASSGENERATOR.disabled) disabledBlocks.add(ModBlocks.biomassgenerator);

        if (EmergingTechnologyConfig.POLYMERS_MODULE.SHREDDER.disabled) disabledBlocks.add(ModBlocks.shredder);
        if (EmergingTechnologyConfig.POLYMERS_MODULE.PROCESSOR.disabled) disabledBlocks.add(ModBlocks.processor);
        if (EmergingTechnologyConfig.POLYMERS_MODULE.COLLECTOR.disabled) disabledBlocks.add(ModBlocks.collector);
        if (EmergingTechnologyConfig.POLYMERS_MODULE.FABRICATOR.disabled) disabledBlocks.add(ModBlocks.fabricator);

        if (EmergingTechnologyConfig.SYNTHETICS_MODULE.COOKER.disabled) disabledBlocks.add(ModBlocks.cooker);
        if (EmergingTechnologyConfig.SYNTHETICS_MODULE.SCAFFOLDER.disabled) disabledBlocks.add(ModBlocks.scaffolder);
        if (EmergingTechnologyConfig.SYNTHETICS_MODULE.BIOREACTOR.disabled) disabledBlocks.add(ModBlocks.bioreactor);

        if (EmergingTechnologyConfig.HYDROPONICS_MODULE.GROWBED.disabled) disabledBlocks.add(ModBlocks.cooker);
        if (EmergingTechnologyConfig.HYDROPONICS_MODULE.GROWLIGHT.disabled) disabledBlocks.add(ModBlocks.light);
        if (EmergingTechnologyConfig.HYDROPONICS_MODULE.HARVESTER.disabled) disabledBlocks.add(ModBlocks.harvester);
        if (EmergingTechnologyConfig.HYDROPONICS_MODULE.FILLER.disabled) disabledBlocks.add(ModBlocks.filler);

        for (Block block : disabledBlocks) {
            removeBlockRecipe(registry, block);
        }
    }

    private static void removeBlockRecipe(IForgeRegistryModifiable<IRecipe> registry, Block block) {

        block.setCreativeTab(null);

        IRecipe p = (IRecipe) registry.getValue(block.getRegistryName());
        registry.remove(block.getRegistryName());
        registry.register(new EmptyRecipe(p));
    }
}