package de.playacem.allrondism;

//Importing my classes
import de.playacem.allrondism.lib.Reference;
import de.playacem.allrondism.core.proxy.*;

//General modloading imports
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

/** @Mod
Tells Forge that this is the Base Mod class. Takes three parameters.

modid
	A unique name for the mod.
name
	Human readable name for the mod.
version
	The version of the mod.


*/
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

/** @NetworkMod
*
*Tells Forge how to handle what happens when the client or the server has the client installed. Takes two parameters.
*
* clientSideRequired
* 	Asks if you need this on the client to use this mod.
* serverSideRequired
* 	Asks if you need this on the server for the client to be able to connect. This should always be false, else you can't join a server if the server doesn't have the mod installed, but you do.
*
*
**/
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
/**
 * Allrondism-Mod
 * 
 * AllrondismMod
 * 
 * Main class for the Minecraft mod "Allrondism"
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AllrondismMod {

	@Instance(Reference.MOD_ID)
	public static AllrondismMod instance;
	/**
	 * @SidedProxy 
     * This proxy is where Forge decides which class to load depending on 
     * whether or not the client or server is running. 
     * 
	 */
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
            // Stub Method
    }
   
    @Init
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderers();
    }
   
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }	
}