/*******************************************************************************************************************
 * Authors:   SanAndreasP
 * Copyright: SanAndreasP, SilverChiren and CliffracerX
 * License:   Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International
 *                http://creativecommons.org/licenses/by-nc-sa/4.0/
 *******************************************************************************************************************/
package de.sanandrew.mods.crystalbiome.world.biome;

import de.sanandrew.mods.crystalbiome.util.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeGreenCrystal
    extends BiomeGenBase
{
    public BiomeGreenCrystal(int id) {
        super(id);

        this.topBlock = ModBlocks.crystalGrass;
        this.fillerBlock = ModBlocks.crystalDirt;

        this.setTemperatureRainfall(0.7F, 0.8F);

        spawnableCreatureList.clear();

        this.flowers.clear();

        this.theBiomeDecorator.grassPerChunk = 10;
    }

    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random rand) {
        return new WorldGenTallGrass(ModBlocks.crystalTallGrass, (rand.nextInt(2) << 3) & 0x8);
    }

    @Override
    public int getSkyColorByTemp(float p_76731_1_) {
        return 0x00FF00;
    }

    @Override
    public int getWaterColorMultiplier() {
        return 0x00FF00;
    }

    public void genTerrainBlocks(World world, Random rand, Block[] chunkBlocks, byte[] chunkMetas, int blockX, int blockZ, double stoneNoise)
    {
        this.genCrystalBiomeTerrain(world, rand, chunkBlocks, chunkMetas, blockX, blockZ, stoneNoise);
    }

    public final void genCrystalBiomeTerrain(World world, Random rand, Block[] chunkBlocks, byte[] chunkMeta, int blockX, int blockZ, double p_150560_7_)
    {
        byte fillerMeta = 0;
        byte topMeta = 0;

        int stoneNoiseVal = (int)(p_150560_7_ / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int chunkBlockX = blockX & 15;
        int chunkBlockZ = blockZ & 15;
        Block blockTop = this.topBlock;
        Block blockFiller = this.fillerBlock;
        int k = -1;
        int k1 = chunkBlocks.length / 256;

        for( int y = 255; y >= 0; --y )
        {
            int arrInd = (chunkBlockZ * 16 + chunkBlockX) * k1 + y;

            if( y <= rand.nextInt(5) ) {
                chunkBlocks[arrInd] = Blocks.bedrock;
            } else {
                Block genBlock = chunkBlocks[arrInd];

                if( genBlock != null && genBlock.getMaterial() != Material.air ) {
                    if( genBlock == Blocks.stone ) {
                        if (k == -1) {
                            if( stoneNoiseVal <= 0 ) {
                                blockTop = null;
                                blockFiller = Blocks.stone;
                            } else if (y >= 59 && y <= 64) {
                                blockTop = this.topBlock;
                                blockFiller = this.fillerBlock;
                            }

                            if( y < 63 && (blockTop == null || blockTop.getMaterial() == Material.air) ) {
                                if (this.getFloatTemperature(chunkBlockX, y, chunkBlockZ) < 0.15F) {
                                    blockTop = Blocks.ice;
                                } else {
                                    blockTop = Blocks.water;
                                }
                            }

                            k = stoneNoiseVal;

                            if (y >= 62) {
                                chunkBlocks[arrInd] = blockTop;
                                chunkMeta[arrInd] = topMeta;
                            } else if (y < 56 - stoneNoiseVal) {
                                blockTop = null;
                                blockFiller = Blocks.stone;
                                chunkBlocks[arrInd] = Blocks.gravel;
                            } else {
                                chunkBlocks[arrInd] = blockFiller;
                                chunkMeta[arrInd] = fillerMeta;
                            }
                        } else if (k > 0) {
                            --k;
                            chunkBlocks[arrInd] = blockFiller;
                            chunkMeta[arrInd] = fillerMeta;
                        }
                    }
                } else {
                    k = -1;
                }
            }
        }
    }
}
