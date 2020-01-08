package io.moonman.emergingtechnology.util;

import io.moonman.emergingtechnology.helpers.enums.ResourceTypeEnum;
import net.minecraft.util.text.TextComponentTranslation;

public class Lang {

    private static final String SOURCE = "info.emergingtechnology.";

    // Machine descriptions for tooltips
    public static final TextComponentTranslation BIOMASS_DESC = new TextComponentTranslation(SOURCE + "light.description");
    public static final TextComponentTranslation BIOREACTOR_DESC = new TextComponentTranslation(SOURCE + "bioreactor.description");
    public static final TextComponentTranslation COLLECTOR_DESC = new TextComponentTranslation(SOURCE + "collector.description");
    public static final TextComponentTranslation COOKER_DESC = new TextComponentTranslation(SOURCE + "cooker.description");
    public static final TextComponentTranslation FABRICATOR_DESC = new TextComponentTranslation(SOURCE + "fabricator.description");
    public static final TextComponentTranslation FILLER_DESC = new TextComponentTranslation(SOURCE + "filler.description");
    public static final TextComponentTranslation HARVESTER_DESC = new TextComponentTranslation(SOURCE + "harvester.description");
    public static final TextComponentTranslation HYDROPONIC_DESC = new TextComponentTranslation(SOURCE + "hydroponic.description");
    public static final TextComponentTranslation LIGHT_DESC = new TextComponentTranslation(SOURCE + "light.description");
    public static final TextComponentTranslation PIEZOELECTRIC_DESC = new TextComponentTranslation(SOURCE + "piezoelectric.description");
    public static final TextComponentTranslation PROCESSOR_DESC = new TextComponentTranslation(SOURCE + "processor.description");
    public static final TextComponentTranslation SCAFFOLDER_DESC = new TextComponentTranslation(SOURCE + "scaffolder.description");
    public static final TextComponentTranslation SHREDDER_DESC = new TextComponentTranslation(SOURCE + "shredder.description");
    public static final TextComponentTranslation TIDAL_DESC = new TextComponentTranslation(SOURCE + "tidal.description");
    
    // Block descriptions for tooltips
    public static final TextComponentTranslation FRAME_DESC = new TextComponentTranslation(SOURCE + "frame.description");

    // Bulb descriptions for tooltips
    public static final TextComponentTranslation BULB_DESC = new TextComponentTranslation(SOURCE + "bulb.description");
    public static final TextComponentTranslation EMPTY_SYRINGE_DESC = new TextComponentTranslation(SOURCE + "emptysyringe.description");

    // Interaction descriptions
    public static final TextComponentTranslation INTERACT_RIGHT_CLICK = new TextComponentTranslation(SOURCE + "interaction.rightclick");

    // Items
    public static String getMeatName(String name, boolean cooked) {
        String type = cooked ? "cooked" : "raw";
        return new TextComponentTranslation(SOURCE + type + "meat.name", name).getFormattedText();
    }

    public static String getMeatDescription(String name, boolean cooked) {
        String type = cooked ? "cooked" : "raw";
        return new TextComponentTranslation(SOURCE + type + "meat.description", name).getFormattedText();
    }

    public static String getTissueName(String name, boolean isSample) {
        String type = isSample ? "sample" : "syringe";
        return new TextComponentTranslation(SOURCE + type + "name", name).getFormattedText();
    }

    public static String getTissueDescription(String name, boolean isSample) {
        String type = isSample ? "sample" : "syringe";
        return new TextComponentTranslation(SOURCE + type + "description", name).getFormattedText();
    }

    // Special requirements
    public static final TextComponentTranslation BIOME_REQUIREMENT = new TextComponentTranslation(SOURCE + "biome.required");
    public static final TextComponentTranslation WATER_SURFACE_REQUIREMENT = new TextComponentTranslation(SOURCE + "watersurface.required");

    public static String getWaterBlocksRequired(int required) {
        return new TextComponentTranslation(SOURCE + "waterblocks.required", required).getFormattedText();
    }

    public static String getDepthBoost(int min, int max) {
        return new TextComponentTranslation(SOURCE + "waterdepth.required", min, max).getFormattedText();
    }

    public static String getHeatGainLoss(int gain, int loss) {
        return new TextComponentTranslation(SOURCE + "cookerheat.generated", gain, loss).getFormattedText();
    }

    public static String getLightRange(int range) {
        return new TextComponentTranslation(SOURCE + "lightrange.generated", range).getFormattedText();
    }

    // Resource 
    public static String getRequired(int required, ResourceTypeEnum type) {
        return new TextComponentTranslation(SOURCE + type.toString().toLowerCase() + ".required", required).getFormattedText();
    }

    public static String getGenerated(int required, ResourceTypeEnum type) {
        return new TextComponentTranslation(SOURCE + type.toString().toLowerCase() + ".generated", required).getFormattedText();
    }

    public static String get(TextComponentTranslation translation) {
        return translation.getFormattedText();
    }

}