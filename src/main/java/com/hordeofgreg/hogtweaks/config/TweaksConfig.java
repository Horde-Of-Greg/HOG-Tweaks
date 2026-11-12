package com.hordeofgreg.hogtweaks.config;

import net.minecraftforge.common.config.Config;

import com.hordeofgreg.hogtweaks.Tags;

@Config(modid = Tags.MODID)
public class TweaksConfig {

    @Config.Name("advanced")
    public static Advanced advanced = new Advanced();

    @Config.Name("oreDictExport")
    public static OreDictExport oreDictExport = new OreDictExport();

    public static class Advanced {

        @Config.Comment({
                "Activate verbose logging.",
                "This is useful for debugging and development.",
                "[Default: false]"
        })
        @Config.Name("activateVerboseLogging")
        @Config.RequiresMcRestart
        public boolean activateVerboseLogging = false;
    }

    public static class OreDictExport {

        @Config.Comment("Enable OreDictionary export on server startup. [Default: false]")
        @Config.Name("enableExport")
        public boolean enableExport = false;

        @Config.Comment("Output path for the OreDictionary export file. [Default: hogtweaks/storage/oredic_dump.txt]")
        @Config.Name("outputPath")
        public String outputPath = "hogtweaks/storage/oredic_dump.txt";
    }
}
