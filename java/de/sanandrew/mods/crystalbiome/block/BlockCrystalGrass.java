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
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.List;

public class BlockCrystalGrass
    extends Block
{
    private IIcon[][] icons;

    public BlockCrystalGrass() {
        super(Material.grass);
    }

    @Override
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        if( side == 0 ) {
            return ModBlocks.crystalDirt.getIcon(0, 0);
        } else {
            return this.icons[blockAccess.getBlockMetadata(x, y, z) >> 1][side == 1 ? 0 : 1];
        }
    }

    @Override
    protected ItemStack createStackedBlock(int meta) {
        return super.createStackedBlock(meta & 0xE);
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(this, 1, 0));
        list.add(new ItemStack(this, 1, 0));
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return side == 0 ? ModBlocks.crystalDirt.getIcon(0, 0) : this.icons[meta >> 1][side == 1 ? 0 : 1];
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.icons = new IIcon[1][2];

        this.icons[0][0] = iconRegister.registerIcon(CRB_Main.MOD_ID + ":tiberium_grass_top");
        this.icons[0][1] = iconRegister.registerIcon(CRB_Main.MOD_ID + ":tiberium_grass_side");
    }
}
