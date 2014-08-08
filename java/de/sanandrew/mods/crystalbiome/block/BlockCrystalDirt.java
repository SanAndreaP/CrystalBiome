/*******************************************************************************************************************
 * Authors:   SanAndreasP
 * Copyright: SanAndreasP, SilverChiren and CliffracerX
 * License:   Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International
 *                http://creativecommons.org/licenses/by-nc-sa/4.0/
 *******************************************************************************************************************/
package de.sanandrew.mods.crystalbiome.block;

import de.sanandrew.core.manpack.util.client.IconFlippedFixed;
import de.sanandrew.mods.crystalbiome.util.CRB_Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.List;

public class BlockCrystalDirt
    extends Block
{
    public IIcon icons[][];

    public BlockCrystalDirt() {
        super(Material.ground);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.icons = new IIcon[2][2];

        this.icons[0][0] = iconRegister.registerIcon(CRB_Main.MOD_ID + ":crystal_dirt_green");
        this.icons[0][1] = new IconFlippedFixed(this.icons[0][0], true, false);
        this.icons[1][0] = iconRegister.registerIcon(CRB_Main.MOD_ID + ":crystal_dirt_red");
        this.icons[1][1] = new IconFlippedFixed(this.icons[1][0], true, false);

        this.blockIcon = this.icons[0][0];
    }

    @Override
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        int index = getIconIndex(x, y, z);
        return this.icons[blockAccess.getBlockMetadata(x, y, z)][index];
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icons[meta][0];
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(this, 1, 0));
        list.add(new ItemStack(this, 1, 1));
    }

    private int getIconIndex(int x, int y, int z) {
        long i1 = (long)(x * 0x2FC20F) ^ (long)y * 0x06EBFFF5L ^ (long)z;
        i1 = i1 * i1 * 0x0285B825L + i1 * 11L;
        return (int) ((i1 >> 1) & Integer.MAX_VALUE) % 2;
    }
}
