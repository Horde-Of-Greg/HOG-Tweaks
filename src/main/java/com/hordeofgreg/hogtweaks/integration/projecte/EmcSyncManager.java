package com.hordeofgreg.hogtweaks.integration.projecte;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import moze_intel.projecte.api.ProjectEAPI;
import moze_intel.projecte.api.capabilities.IKnowledgeProvider;

public class EmcSyncManager {

    private final Set<EntityPlayerMP> playersPendingSync = new HashSet<>();

    public void markDirty(EntityPlayerMP player) {
        playersPendingSync.add(player);
    }

    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        syncPlayers();
    }

    private void syncPlayers() {
        for (EntityPlayerMP player : playersPendingSync) {
            IKnowledgeProvider knowledge = player.getCapability(ProjectEAPI.KNOWLEDGE_CAPABILITY, null);
            if (knowledge == null) continue;
            knowledge.sync(player);
        }

        playersPendingSync.clear();
    }
}
