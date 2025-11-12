package be.alessian.taotweaks.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import net.minecraftforge.oredict.OreDictionary;

import be.alessian.taotweaks.TaoTweaks;

public class OreDictExporter {

    public static void export(String outputPath) {
        try {
            new File(outputPath).getParentFile().mkdirs();
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

            String[] oreNames = OreDictionary.getOreNames();
            int total = oreNames.length;

            for (int i = 0; i < total; i++) {
                writer.write(oreNames[i]);
                writer.newLine();

                if (i % (total / 10) == 0) {
                    TaoTweaks.LOGGER.info("Progress: {}%", (i * 100) / total);
                }
            }

            writer.close();
            TaoTweaks.LOGGER.info("Export complete: {}", outputPath);
        } catch (Exception e) {
            TaoTweaks.LOGGER.error("Export failed", e);
        }
    }
}
