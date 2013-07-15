package playacem.allrondism.core.proxy;

import playacem.allrondism.core.handlers.SpawnHandler;
import net.minecraftforge.common.MinecraftForge;

/**
 * Allrondism
 * 
 * CommonProxy
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class CommonProxy {

    public void registerRenderers() {
        // Nothing here as the server doesn't render graphics!
    }

    public void registerSoundHandler() {
        // The Server doesn't manage sounds either.
    }
    
    public void registerSpawnHandler() {
        MinecraftForge.EVENT_BUS.register(new SpawnHandler());
    }
}
