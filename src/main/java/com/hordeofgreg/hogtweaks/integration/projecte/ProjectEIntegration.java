package com.hordeofgreg.hogtweaks.integration.projecte;

import net.minecraftforge.common.MinecraftForge;

public class ProjectEIntegration {

    public static EmcSyncManager register() {
        EmcSyncManager syncManager = new EmcSyncManager();
        MinecraftForge.EVENT_BUS.register(syncManager);

        return syncManager;
    }
}
