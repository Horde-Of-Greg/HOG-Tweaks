package com.hordeofgreg.hogtweaks.integration.betterbuilderswands;

import net.minecraftforge.fml.common.Loader;

import com.hordeofgreg.hogtweaks.integration.betterbuilderswands.handlers.EmcContainerHandler;
import com.hordeofgreg.hogtweaks.integration.projecte.EmcSyncManager;

import portablejim.bbw.BetterBuildersWandsMod;

public class BetterBuildersWandsIntegration {

    public static void registerEmc(EmcSyncManager syncManager) {
        if (!Loader.isModLoaded("projecte")) return;

        BetterBuildersWandsMod.instance.containerManager.registerSpecial(
                new EmcContainerHandler(syncManager));
    }
}
