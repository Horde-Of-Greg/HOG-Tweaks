package com.hordeofgreg.hogtweaks.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import net.minecraftforge.oredict.OreDictionary;

import com.hordeofgreg.hogtweaks.HOGTweaks;

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
                    HOGTweaks.LOGGER.info("Progress: {}%", (i * 100) / total);
                }
            }

            writer.close();
            HOGTweaks.LOGGER.info("Export complete: {}", outputPath);
        } catch (Exception e) {
            HOGTweaks.LOGGER.error("Export failed", e);
        }
    }
}
