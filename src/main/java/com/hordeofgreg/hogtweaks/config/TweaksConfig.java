package com.hordeofgreg.hogtweaks.config;

import net.minecraftforge.common.config.Config;

import com.hordeofgreg.hogtweaks.Tags;

@Config(modid = Tags.MODID)
public class TweaksConfig {

    @Config.Name("Better Builder's Wands")
    public static BuilderWands BuilderWands = new BuilderWands();

    @Config.Name("advanced")
    public static Advanced advanced = new Advanced();

    @Config.Name("oreDictExport")
    public static OreDictExport oreDictExport = new OreDictExport();

    public static class BuilderWands {

        @Config.Comment({
            "Allow Better Builder's Wands to pull items from a Project E network.",
            "This will only work if you have Project E installed, even if set to true.",
            "[Default: true]"
        })
        @Config.Name("wandsCanUseEMC")
        public boolean wandsCanUseEmc = true;
    }

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
