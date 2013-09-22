package playacem.allrondism;

// inspired by Pahimar's EE3, some parts are nearly exact copies 
// (https://github.com/pahimar/Equivalent-Exchange-3/)
// Copying code is allowed due to LGPL
import java.io.File;

import net.minecraft.creativetab.CreativeTabs;


import playacem.allrondism.block.ModBlocks;
import playacem.allrondism.configuration.ConfigurationHandler;
import playacem.allrondism.core.handlers.FuelHandler;
import playacem.allrondism.core.handlers.ImageHandler;
import playacem.allrondism.core.proxy.CommonProxy;
import playacem.allrondism.core.util.LogHelper;
import playacem.allrondism.creativetab.CreativeTabAM;
import playacem.allrondism.item.ModItems;
import playacem.allrondism.lib.Reference;
import playacem.allrondism.network.PacketHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Allrondism
 * 
 * Allrondism
 * 
 * Main class for the Minecraft mod "Allrondism"
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER, dependencies = Reference.DEPENDENCIES)
@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class Allrondism {

    @Instance(Reference.MOD_ID)
    public static Allrondism instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static CreativeTabs tabsAM = new CreativeTabAM(CreativeTabs.getNextID(), Reference.MOD_ID);

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        // Here goes stuff like reading config files

        // Initialize the log helper
        LogHelper.init();

        // Initialize the configuration
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.MOD_NAME + ".cfg"));
        
        // Does some image magic, creates merged images.
        ImageHandler.init();

        // Register the Spawn Handler
        proxy.registerSpawnHandler();
        
        // Register the Sound Handler (Client only)
        proxy.registerSoundHandler();
        
        // Initialize mod blocks
        ModBlocks.init();
        // Initialize mod items
        ModItems.init();
       
        // Initialize mod block recipes
        ModBlocks.initBlockRecipes();
        // Initialize mod item recipes
        ModItems.initItemRecipes();
    }

    @Init
    public void load(FMLInitializationEvent event) {
        // Register the GuiHandler
        NetworkRegistry.instance().registerGuiHandler(instance, proxy);
        
        // Register the Renderers
        proxy.registerRenderers();
        
        // Initialize mod tile entities
        proxy.registerTileEntities();
        
        // Register the FuelHandler
        GameRegistry.registerFuelHandler(new FuelHandler());
    }

    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {
        // Adding cross-mod recipes
        ModItems.postInit();        
    }

}