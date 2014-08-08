/*******************************************************************************************************************
 * Authors:   SanAndreasP
 * Copyright: SanAndreasP, SilverChiren and CliffracerX
 * License:   Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International
 *                http://creativecommons.org/licenses/by-nc-sa/4.0/
 *******************************************************************************************************************/
package de.sanandrew.mods.crystalbiome.util;

import de.sanandrew.core.manpack.item.ItemBlockNamedMeta;
import de.sanandrew.core.manpack.util.SAPUtils;
import de.sanandrew.mods.crystalbiome.block.BlockCrystalDirt;
import de.sanandrew.mods.crystalbiome.block.BlockCrystalGrass;
import de.sanandrew.mods.crystalbiome.block.BlockCrystalTallGrass;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public final class ModBlocks
{
    public static Block crystalDirt = new BlockCrystalDirt();
    public static Block crystalGrass = new BlockCrystalGrass();
    public static Block crystalTallGrass = new BlockCrystalTallGrass();

    public static void initialize() {
        crystalDirt.setCreativeTab(CreativeTabs.tabBlock)
                   .setBlockName(CRB_Main.MOD_ID + ":crystalDirt")
                   .setHardness(0.5F)
                   .setStepSound(Block.soundTypeGravel);
        crystalGrass.setCreativeTab(CreativeTabs.tabBlock)
                    .setBlockName(CRB_Main.MOD_ID + ":crystalGrass")
                    .setHardness(0.6F)
                    .setStepSound(Block.soundTypeGrass);
        crystalTallGrass.setCreativeTab(CreativeTabs.tabBlock)
                    .setBlockName(CRB_Main.MOD_ID + ":crystalTallGrass")
                    .setHardness(0.0F)
                    .setStepSound(Block.soundTypeGrass);


        SAPUtils.registerBlockWithItem(crystalDirt, ItemBlockNamedMeta.class);
        SAPUtils.registerBlockWithItem(crystalGrass, ItemBlockNamedMeta.class);
        SAPUtils.registerBlockWithItem(crystalTallGrass, ItemBlockNamedMeta.class);
    }
}
