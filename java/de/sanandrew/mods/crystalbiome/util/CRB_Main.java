/*******************************************************************************************************************
 * Authors:   SanAndreasP
 * Copyright: SanAndreasP, SilverChiren and CliffracerX
 * License:   Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International
 *                http://creativecommons.org/licenses/by-nc-sa/4.0/
 *******************************************************************************************************************/
package de.sanandrew.mods.crystalbiome.util;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CRB_Main.MOD_ID, version = CRB_Main.VERSION, name = "Crystal Biomes",
     dependencies = "required-after:sapmanpack@[2.0.0,)")
public class CRB_Main
{
    public static final String MOD_ID = "crystalbiome";
    public static final String VERSION = "1.0";
    public static final String MOD_LOG = "ClaySoldiers";
//    public static final String MOD_CHANNEL = "ClaySoldiersNWCH";
//    public static final String MOD_GUI_FACTORY = "de.sanandrew.mods.claysoldiers.client.gui.ModGuiFactory";

//    private static final String MOD_PROXY_CLIENT = "de.sanandrew.mods.claysoldiers.client.util.ClientProxy";
//    private static final String MOD_PROXY_COMMON = "de.sanandrew.mods.claysoldiers.util.CommonProxy";

    @Mod.Instance(CRB_Main.MOD_ID)
    public static CRB_Main instance;
//    @SidedProxy(modId = CRB_Main.MOD_ID, clientSide = CRB_Main.MOD_PROXY_CLIENT, serverSide = CRB_Main.MOD_PROXY_COMMON)
//    public static CommonProxy proxy;

    @EventHandler
    public void modPreInit(FMLPreInitializationEvent event) {
        ModBlocks.initialize();
        ModBiomes.initialize();
    }
}
