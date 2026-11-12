package com.hordeofgreg.hogtweaks;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hordeofgreg.hogtweaks.common.CommonProxy;
import com.hordeofgreg.hogtweaks.config.TweaksConfig;

@Mod(modid = Tags.MODID,
     version = Tags.VERSION,
     name = Tags.MODNAME,
     acceptedMinecraftVersions = "[1.12.2]",
     acceptableRemoteVersions = "*")
public class HOGTweaks {

    public static final String MODID = Tags.MODID;
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @SidedProxy(modId = MODID,
                clientSide = "com.hordeofgreg.hogtweaks.common.CommonProxy",
                serverSide = "com.hordeofgreg.hogtweaks.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        if (TweaksConfig.advanced.activateVerboseLogging) {
            LOGGER.info("I am " + Tags.MODNAME + " + at version " + Tags.VERSION);
        }
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {}
}
