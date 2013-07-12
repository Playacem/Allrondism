package playacem.allrondism.core.util;

import net.minecraft.world.World;


/**
 * Allrondism
 * 
 * UtilBlock
 * 
 * Functions for easier interaction with blocks
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class UtilBlock {

    public static float getLightValueFromInt(int lightLevel) {
        return lightLevel / 15.0F;
    }
    
    /**
     * Compares coordinates of a block with the given block(id + metadata)
     * @param w - world
     * @param blockID - id of the given Block
     * @param meta - metadata of the given block
     * @return true - if the blocks are identical
     */
    public static boolean isValidBlock(World w, int x, int y, int z, int blockID, int meta) {
        if(w.getBlockId(x, y, z) == blockID && w.getBlockMetadata(x, y, z) == meta) return true;
        return false;
    }
}
