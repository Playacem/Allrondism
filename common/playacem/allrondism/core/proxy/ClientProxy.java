package playacem.allrondism.core.proxy;

import net.minecraftforge.common.MinecraftForge;
import playacem.allrondism.client.audio.SoundHandler;

//import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Allrondism
 * 
 * ClientProxy
 * 
 * Handles the client stuff.
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

    @Override
    public void registerSoundHandler() {
        MinecraftForge.EVENT_BUS.register(new SoundHandler());
    }
}
