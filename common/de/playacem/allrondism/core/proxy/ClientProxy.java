package de.playacem.allrondism.core.proxy;

//import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Allrondism-Mod
 * 
 * ClientProxy Handles the client stuff.
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenderers() {
        // Loading textures
        // MinecraftForgeClient.preloadTexture(ITEMS_PNG);
        // MinecraftForgeClient.preloadTexture(BLOCKS_PNG);
    }
}
