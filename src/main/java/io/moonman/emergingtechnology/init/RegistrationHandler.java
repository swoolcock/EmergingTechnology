package io.moonman.emergingtechnology.init;

import java.util.ArrayList;

import io.moonman.emergingtechnology.EmergingTechnology;
import io.moonman.emergingtechnology.block.blocks.ClearPlasticBlock;
import io.moonman.emergingtechnology.block.blocks.Frame;
import io.moonman.emergingtechnology.block.blocks.Ladder;
import io.moonman.emergingtechnology.block.blocks.MachineCase;
import io.moonman.emergingtechnology.block.blocks.PlasticBlock;
import io.moonman.emergingtechnology.block.blocks.ShreddedPlantBlock;
import io.moonman.emergingtechnology.block.blocks.ShreddedPlasticBlock;
import io.moonman.emergingtechnology.block.blocks.ShreddedStarchBlock;
import io.moonman.emergingtechnology.item.electrics.Biomass;
import io.moonman.emergingtechnology.item.hydroponics.BlueBulb;
import io.moonman.emergingtechnology.item.hydroponics.GreenBulb;
import io.moonman.emergingtechnology.item.hydroponics.PurpleBulb;
import io.moonman.emergingtechnology.item.hydroponics.RedBulb;
import io.moonman.emergingtechnology.item.polymers.PlasticRod;
import io.moonman.emergingtechnology.item.polymers.PlasticSheet;
import io.moonman.emergingtechnology.item.polymers.PlasticTissueScaffold;
import io.moonman.emergingtechnology.item.polymers.PlasticWaste;
import io.moonman.emergingtechnology.item.polymers.Filament;
import io.moonman.emergingtechnology.item.polymers.ShreddedPlant;
import io.moonman.emergingtechnology.item.polymers.ShreddedPlastic;
import io.moonman.emergingtechnology.item.polymers.ShreddedStarch;
import io.moonman.emergingtechnology.item.synthetics.SampleItemBase;
import io.moonman.emergingtechnology.item.synthetics.SyringeItemBase;
import io.moonman.emergingtechnology.item.synthetics.consumables.SyntheticChickenCooked;
import io.moonman.emergingtechnology.item.synthetics.consumables.SyntheticChickenRaw;
import io.moonman.emergingtechnology.item.synthetics.consumables.SyntheticCowCooked;
import io.moonman.emergingtechnology.item.synthetics.consumables.SyntheticCowRaw;
import io.moonman.emergingtechnology.item.synthetics.consumables.SyntheticPigCooked;
import io.moonman.emergingtechnology.item.synthetics.consumables.SyntheticPigRaw;
import io.moonman.emergingtechnology.item.synthetics.products.SyntheticLeather;
import io.moonman.emergingtechnology.item.synthetics.products.SyntheticSilk;
import io.moonman.emergingtechnology.item.synthetics.products.SyntheticSlime;
import io.moonman.emergingtechnology.item.synthetics.syringes.EmptySyringe;
import io.moonman.emergingtechnology.machines.battery.Battery;
import io.moonman.emergingtechnology.machines.battery.BatteryTileEntity;
import io.moonman.emergingtechnology.machines.biomass.BiomassGenerator;
import io.moonman.emergingtechnology.machines.biomass.BiomassGeneratorTileEntity;
import io.moonman.emergingtechnology.machines.bioreactor.Bioreactor;
import io.moonman.emergingtechnology.machines.bioreactor.BioreactorTileEntity;
import io.moonman.emergingtechnology.machines.collector.Collector;
import io.moonman.emergingtechnology.machines.collector.CollectorTileEntity;
import io.moonman.emergingtechnology.machines.cooker.Cooker;
import io.moonman.emergingtechnology.machines.cooker.CookerTileEntity;
import io.moonman.emergingtechnology.machines.fabricator.Fabricator;
import io.moonman.emergingtechnology.machines.fabricator.FabricatorTileEntity;
import io.moonman.emergingtechnology.machines.filler.Filler;
import io.moonman.emergingtechnology.machines.filler.FillerTileEntity;
import io.moonman.emergingtechnology.machines.harvester.Harvester;
import io.moonman.emergingtechnology.machines.harvester.HarvesterTileEntity;
import io.moonman.emergingtechnology.machines.hydroponic.Hydroponic;
import io.moonman.emergingtechnology.machines.hydroponic.HydroponicTESR;
import io.moonman.emergingtechnology.machines.hydroponic.HydroponicTileEntity;
import io.moonman.emergingtechnology.machines.light.Light;
import io.moonman.emergingtechnology.machines.light.LightTileEntity;
import io.moonman.emergingtechnology.machines.piezoelectric.Piezoelectric;
import io.moonman.emergingtechnology.machines.piezoelectric.PiezoelectricTileEntity;
import io.moonman.emergingtechnology.machines.processor.Processor;
import io.moonman.emergingtechnology.machines.processor.ProcessorTileEntity;
import io.moonman.emergingtechnology.machines.scaffolder.Scaffolder;
import io.moonman.emergingtechnology.machines.scaffolder.ScaffolderTileEntity;
import io.moonman.emergingtechnology.machines.shredder.Shredder;
import io.moonman.emergingtechnology.machines.shredder.ShredderTileEntity;
import io.moonman.emergingtechnology.machines.solar.Solar;
import io.moonman.emergingtechnology.machines.solar.SolarTileEntity;
import io.moonman.emergingtechnology.machines.tidal.TidalGenerator;
import io.moonman.emergingtechnology.machines.tidal.TidalGeneratorTileEntity;
import io.moonman.emergingtechnology.providers.ModTissueProvider;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Registers blocks, items and models for Emerging Technology TODO: Improve and
 * organise
 */
public class RegistrationHandler {

    public static void registerBlocks(Register<Block> event) {
        final Block[] blocks = { new Hydroponic(), new Harvester(), new Filler(), new Light(), new Frame(),
                new Processor(), new Shredder(), new PlasticBlock(), new ClearPlasticBlock(), new MachineCase(),
                new Fabricator(), new Collector(), new Cooker(), new Ladder(), new Piezoelectric(), new TidalGenerator(), new BiomassGenerator(), new Solar(), new Battery(),
                new ShreddedPlasticBlock(), new ShreddedPlantBlock(), new ShreddedStarchBlock(), new Bioreactor(),
                new Scaffolder() };

        GameRegistry.registerTileEntity(HydroponicTileEntity.class, getResourceLocation("hydroponic"));
        GameRegistry.registerTileEntity(HarvesterTileEntity.class, getResourceLocation("harvester"));
        GameRegistry.registerTileEntity(FillerTileEntity.class, getResourceLocation("filler"));
        GameRegistry.registerTileEntity(LightTileEntity.class, getResourceLocation("light"));
        GameRegistry.registerTileEntity(ProcessorTileEntity.class, getResourceLocation("processor"));
        GameRegistry.registerTileEntity(ShredderTileEntity.class, getResourceLocation("shredder"));
        GameRegistry.registerTileEntity(FabricatorTileEntity.class, getResourceLocation("fabricator"));
        GameRegistry.registerTileEntity(CollectorTileEntity.class, getResourceLocation("collector"));
        GameRegistry.registerTileEntity(CookerTileEntity.class, getResourceLocation("cooker"));
        GameRegistry.registerTileEntity(PiezoelectricTileEntity.class, getResourceLocation("piezoelectric"));
        GameRegistry.registerTileEntity(BioreactorTileEntity.class, getResourceLocation("bioreactor"));
        GameRegistry.registerTileEntity(ScaffolderTileEntity.class, getResourceLocation("scaffolder"));
        GameRegistry.registerTileEntity(TidalGeneratorTileEntity.class, getResourceLocation("tidalgenerator"));
        GameRegistry.registerTileEntity(BiomassGeneratorTileEntity.class, getResourceLocation("biomassgenerator"));
        GameRegistry.registerTileEntity(SolarTileEntity.class, getResourceLocation("solar"));
        GameRegistry.registerTileEntity(BatteryTileEntity.class, getResourceLocation("battery"));

        event.getRegistry().registerAll(blocks);
    }

    public static void registerItems(Register<Item> event) {

        // Items
        final Item[] items = { new RedBulb(), new GreenBulb(), new BlueBulb(), new PurpleBulb(), new ShreddedPlastic(),
                new ShreddedPlant(), new ShreddedStarch(), new PlasticWaste(), new PlasticRod(), new PlasticSheet(),
                new Filament(), new PlasticTissueScaffold(), new EmptySyringe(), new SyntheticCowRaw(),
                new SyntheticChickenRaw(), new SyntheticPigRaw(), new SyntheticPigCooked(), new SyntheticCowCooked(),
                new SyntheticChickenCooked(), new SyntheticLeather(), new SyntheticSlime(), new SyntheticSilk(), new Biomass() };

        // Blocks
        Block[] blocks = { ModBlocks.hydroponic, ModBlocks.harvester, ModBlocks.filler, ModBlocks.light,
                ModBlocks.processor, ModBlocks.shredder, ModBlocks.fabricator, ModBlocks.collector, ModBlocks.cooker,
                ModBlocks.bioreactor, ModBlocks.scaffolder, ModBlocks.piezoelectric, ModBlocks.tidalgenerator, ModBlocks.biomassgenerator, ModBlocks.solar, ModBlocks.battery, ModBlocks.ladder,
                ModBlocks.plasticblock, ModBlocks.frame, ModBlocks.clearplasticblock, ModBlocks.machinecase,
                ModBlocks.shreddedplantblock, ModBlocks.shreddedplasticblock, ModBlocks.shreddedstarchblock };

        final Item[] itemBlocks = generateItemBlocks(blocks);

        for (Item item : ModTissueProvider.modSamples) {
            event.getRegistry().register(item);
        }

        for (Item item : ModTissueProvider.modSyringes) {
            event.getRegistry().register(item);
        }

        // Register
        event.getRegistry().registerAll(itemBlocks);
        event.getRegistry().registerAll(items);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {

        // Block Models
        registerModel(Item.getItemFromBlock(ModBlocks.hydroponic));
        registerModel(Item.getItemFromBlock(ModBlocks.harvester));
        registerModel(Item.getItemFromBlock(ModBlocks.filler));
        registerModel(Item.getItemFromBlock(ModBlocks.light));
        registerModel(Item.getItemFromBlock(ModBlocks.processor));
        registerModel(Item.getItemFromBlock(ModBlocks.shredder));
        registerModel(Item.getItemFromBlock(ModBlocks.fabricator));
        registerModel(Item.getItemFromBlock(ModBlocks.collector));
        registerModel(Item.getItemFromBlock(ModBlocks.cooker));
        registerModel(Item.getItemFromBlock(ModBlocks.bioreactor));
        registerModel(Item.getItemFromBlock(ModBlocks.scaffolder));
        registerModel(Item.getItemFromBlock(ModBlocks.piezoelectric));
        registerModel(Item.getItemFromBlock(ModBlocks.tidalgenerator));
        registerModel(Item.getItemFromBlock(ModBlocks.biomassgenerator));
        registerModel(Item.getItemFromBlock(ModBlocks.solar));
        registerModel(Item.getItemFromBlock(ModBlocks.battery));
        registerModel(Item.getItemFromBlock(ModBlocks.frame));
        registerModel(Item.getItemFromBlock(ModBlocks.ladder));
        registerModel(Item.getItemFromBlock(ModBlocks.machinecase));
        registerModel(Item.getItemFromBlock(ModBlocks.plasticblock));
        registerModel(Item.getItemFromBlock(ModBlocks.clearplasticblock));
        registerModel(Item.getItemFromBlock(ModBlocks.shreddedplantblock));
        registerModel(Item.getItemFromBlock(ModBlocks.shreddedplasticblock));
        registerModel(Item.getItemFromBlock(ModBlocks.shreddedstarchblock));

        // Item Models
        registerModel(ModItems.redbulb);
        registerModel(ModItems.greenbulb);
        registerModel(ModItems.bluebulb);
        registerModel(ModItems.purplebulb);

        registerModel(ModItems.shreddedplastic);
        registerModel(ModItems.shreddedplant);
        registerModel(ModItems.shreddedstarch);

        registerModel(ModItems.plasticrod);
        registerModel(ModItems.plasticsheet);
        registerModel(ModItems.filament);
        registerModel(ModItems.plastictissuescaffold);
        registerModel(ModItems.plasticwaste);

        registerModel(ModItems.emptysyringe);

        registerModel(ModItems.syntheticcowraw);
        registerModel(ModItems.syntheticchickenraw);
        registerModel(ModItems.syntheticpigraw);

        registerModel(ModItems.syntheticcowcooked);
        registerModel(ModItems.syntheticchickencooked);
        registerModel(ModItems.syntheticpigcooked);

        registerModel(ModItems.syntheticleather);
        registerModel(ModItems.syntheticslime);
        registerModel(ModItems.syntheticsilk);

        registerModel(ModItems.biomass);

        registerModTissueModels();

        // Hydroponic TESR
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.hydroponic), 0,
                new ModelResourceLocation(ModBlocks.hydroponic.getRegistryName(), "inventory"));
        ClientRegistry.bindTileEntitySpecialRenderer(HydroponicTileEntity.class, new HydroponicTESR());
    }

    private static Item[] generateItemBlocks(Block[] blocks) {
        ArrayList<Item> itemBlocks = new ArrayList<Item>();

        for (Block block : blocks) {
            itemBlocks.add(generateItemBlock(block));
        }

        return itemBlocks.toArray(new Item[0]);
    }

    private static Item generateItemBlock(Block block) {
        return new ItemBlock(block).setRegistryName(block.getRegistryName());
    }

    private static void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    private static void registerModTissueModels() {

        for (SyringeItemBase item : ModTissueProvider.modSyringes) {
            ModelLoader.setCustomModelResourceLocation(item, 0,
                    new ModelResourceLocation(EmergingTechnology.MODID + ":fullsyringe", "inventory"));
        }

        for (SampleItemBase item : ModTissueProvider.modSamples) {
            ModelLoader.setCustomModelResourceLocation(item, 0,
                    new ModelResourceLocation(EmergingTechnology.MODID + ":sample", "inventory"));
        }
    }

    private static ResourceLocation getResourceLocation(String location) {
        return new ResourceLocation(EmergingTechnology.MODID + ":" + location);
    }
}