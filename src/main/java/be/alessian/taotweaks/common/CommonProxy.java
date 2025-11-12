package be.alessian.taotweaks.common;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import be.alessian.taotweaks.Tags;
import be.alessian.taotweaks.config.TweaksConfig;
import be.alessian.taotweaks.helper.OreDictExporter;

@Mod.EventBusSubscriber(modid = Tags.MODID)
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {}

    public void init(FMLInitializationEvent event) {}

    public void postInit(FMLPostInitializationEvent event) {
        if (TweaksConfig.oreDictExport.enableExport) {
            OreDictExporter.export(TweaksConfig.oreDictExport.outputPath);
        }
    }
}
