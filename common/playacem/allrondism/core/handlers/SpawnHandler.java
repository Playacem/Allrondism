package playacem.allrondism.core.handlers;

import playacem.allrondism.lib.BlockIDs;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.CheckSpawn;

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
    public void onEntitySpawn(CheckSpawn event) {
        int x = (int)Math.floor((double)event.x);
        int y = (int)Math.floor((double)event.y);
        int z = (int)Math.floor((double)event.z);
        y--;//block below the spawn place of the mob

        if (event.world.getBlockId(x, y, z) == BlockIDs.STORAGE_BLOCKS) {
            event.setResult(Result.DENY);
        }else {
            event.setResult(Result.DEFAULT);
        }
    }
}
