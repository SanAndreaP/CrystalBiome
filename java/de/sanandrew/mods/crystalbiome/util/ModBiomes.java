/*******************************************************************************************************************
 * Authors:   SanAndreasP
 * Copyright: SanAndreasP, SilverChiren and CliffracerX
 * License:   Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International
 *                http://creativecommons.org/licenses/by-nc-sa/4.0/
 *******************************************************************************************************************/
package de.sanandrew.mods.crystalbiome.util;

import de.sanandrew.mods.crystalbiome.world.biome.BiomeGreenCrystal;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

public class ModBiomes
{
    public static BiomeGenBase greenCrystalBiome;

    public static void initialize() {
        greenCrystalBiome = new BiomeGreenCrystal(50);

        BiomeDictionary.registerBiomeType(greenCrystalBiome, Type.FOREST);
        BiomeManager.coolBiomes.add(new BiomeEntry(greenCrystalBiome, 100));
        BiomeManager.warmBiomes.add(new BiomeEntry(greenCrystalBiome, 100));
    }
}
