package com.hordeofgreg.hogtweaks.integration.betterbuilderswands.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.hordeofgreg.hogtweaks.config.TweaksConfig;
import com.hordeofgreg.hogtweaks.integration.projecte.EmcSyncManager;

import moze_intel.projecte.api.ProjectEAPI;
import moze_intel.projecte.api.capabilities.IKnowledgeProvider;
import portablejim.bbw.api.IContainerHandlerSpecial;

public class EmcContainerHandler implements IContainerHandlerSpecial {

    final EmcSyncManager syncManager;

    public EmcContainerHandler(EmcSyncManager syncManager) {
        this.syncManager = syncManager;
    }

    @Override
    public Object initCount(EntityPlayer player) {
        return new EmcOperation(player);
    }

    @Override
    public Object initUse(EntityPlayer player) {
        return new EmcOperation(player);
    }

    @Override
    public boolean matches(Object state, ItemStack requestedStack, ItemStack inventoryStack) {
        // This currently does nothing? Do open an issue if it ever does something and everything suddenly breaks.
        return false;
    }

    @Override
    public void handleInventorySlot(Object state, ItemStack requestedStack, ItemStack inventoryStack) {
        EmcOperation operation = (EmcOperation) state;
        operation.requestedStack = requestedStack;
    }

    @Override
    public int finalCount(Object state) {
        if (!TweaksConfig.BuilderWands.wandsCanUseEmc) {
            return 0;
        }

        EmcOperation operation = (EmcOperation) state;
        IKnowledgeProvider knowledge = getKnowledge(operation.player);
        ItemStack requestedStack = (operation.requestedStack);

        if (ignoreItem(requestedStack, knowledge)) {
            return 0;
        }

        long itemEmcValue = getItemEmcValue(requestedStack);

        if (itemEmcValue < 1) {
            return 0;
        }

        long availableEmc = getPlayerEmc(operation.player);

        if (itemEmcValue > availableEmc) {
            return 0;
        }

        long availableItems = availableEmc / itemEmcValue;

        return (int) Math.min(Integer.MAX_VALUE, availableItems);
    }

    @Override
    public int finalUse(Object state, int requestedItemAmount) {
        if (!TweaksConfig.BuilderWands.wandsCanUseEmc) {
            return requestedItemAmount;
        }

        EmcOperation operation = (EmcOperation) state;
        IKnowledgeProvider knowledge = getKnowledge(operation.player);
        ItemStack requestedStack = (operation.requestedStack);

        if (ignoreItem(requestedStack, knowledge)) {
            return requestedItemAmount;
        }

        long itemEmcValue = getItemEmcValue(requestedStack);

        if (itemEmcValue < 1) {
            return requestedItemAmount;
        }

        long availableEmc = getPlayerEmc(operation.player);
        int itemsCanAfford = (int) Math.min(Integer.MAX_VALUE, availableEmc / itemEmcValue);

        int itemsToUse = Math.min(requestedItemAmount, itemsCanAfford);
        long totalEmcCost = itemsToUse * itemEmcValue;

        knowledge.setEmc(availableEmc - totalEmcCost);
        if (itemsToUse > 0) {
            syncManager.markDirty((EntityPlayerMP) operation.player);
        }
        return requestedItemAmount - itemsToUse;
    }

    private static class EmcOperation {

        final EntityPlayer player;
        ItemStack requestedStack = ItemStack.EMPTY;

        EmcOperation(EntityPlayer player) {
            this.player = player;
        }
    }

    private boolean ignoreItem(ItemStack item, IKnowledgeProvider knowledge) {
        return item.isEmpty() || !(item.getItem() instanceof ItemBlock) || item.hasTagCompound() || knowledge == null ||
                !knowledge.hasKnowledge(item);
    }

    private IKnowledgeProvider getKnowledge(EntityPlayer player) {
        return player.getCapability(ProjectEAPI.KNOWLEDGE_CAPABILITY, null);
    }

    private long getPlayerEmc(EntityPlayer player) {
        IKnowledgeProvider knowledge = getKnowledge(player);
        return knowledge.getEmc();
    }

    private long getItemEmcValue(ItemStack item) {
        return ProjectEAPI.getEMCProxy().getValue(item);
    }
}
