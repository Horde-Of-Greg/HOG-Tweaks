package com.hordeofgreg.hogtweaks.common;

import com.hordeofgreg.hogtweaks.integration.betterbuilderswands.BetterBuildersWandsIntegration;
import com.hordeofgreg.hogtweaks.integration.projecte.EmcSyncManager;
import com.hordeofgreg.hogtweaks.integration.projecte.ProjectEIntegration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.hordeofgreg.hogtweaks.Tags;
import com.hordeofgreg.hogtweaks.config.TweaksConfig;
import com.hordeofgreg.hogtweaks.helper.OreDictExporter;

@Mod.EventBusSubscriber(modid = Tags.MODID)
public class CommonProxy {
    EmcSyncManager emcSyncManager = null;

    public static void preInit(FMLPreInitializationEvent event) {}

    public static void init(FMLInitializationEvent event) {}

    public void postInit(FMLPostInitializationEvent event) {

        if (TweaksConfig.oreDictExport.enableExport) {
            OreDictExporter.export(TweaksConfig.oreDictExport.outputPath);
        }

        if (Loader.isModLoaded("projecte")) {
            emcSyncManager = ProjectEIntegration.register();
        }

        if (Loader.isModLoaded("betterbuilderswands")) {
            if (Loader.isModLoaded("projecte") && emcSyncManager != null) {
                BetterBuildersWandsIntegration.registerEmc(emcSyncManager);
            }
        }
    }
}
