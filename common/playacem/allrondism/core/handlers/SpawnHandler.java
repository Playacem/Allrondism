package playacem.allrondism.core.handlers;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

/**
 * Allrondism
 * 
 * SpawnHandler
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class SpawnHandler {


    @ForgeSubscribe
    public void onEntitySpawn(LivingSpawnEvent event) {
        // TODO disable Spawns for certain blocks
    }

}
