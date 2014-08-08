/*******************************************************************************************************************
 * Authors:   SanAndreasP
 * Copyright: SanAndreasP, SilverChiren and CliffracerX
 * License:   Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International
 *                http://creativecommons.org/licenses/by-nc-sa/4.0/
 *******************************************************************************************************************/
package de.sanandrew.mods.crystalbiome.block;

import de.sanandrew.mods.crystalbiome.util.CRB_Main;
import de.sanandrew.mods.crystalbiome.util.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IShearable;

import java.util.ArrayList;
import java.util.Random;

public class BlockCrystalTallGrass
    extends BlockBush
    implements IShearable
{
    public IIcon[][] icons;

    public BlockCrystalTallGrass() {
        super(Material.vine);
        this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.8F, 0.9F);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return null;
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icons[meta & 0x7][(meta >> 3) & 0x1];
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
        return false;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
        return null;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.icons = new IIcon[1][2];

        this.icons[0][0] = iconRegister.registerIcon(CRB_Main.MOD_ID + ":tiberium_grass_tall_1");
        this.icons[0][1] = iconRegister.registerIcon(CRB_Main.MOD_ID + ":tiberium_grass_tall_2");
    }

    @Override
    protected boolean canPlaceBlockOn(Block block) {
        return block == ModBlocks.crystalGrass;
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        return (world.getBlockMetadata(x, y, z) & 0x8) == 0x8 ? 10 : 5;
    }
}
