package playacem.allrondism.block;

import playacem.allrondism.lib.Strings;
import net.minecraft.block.material.Material;

/**
 * Allrondism
 * 
 * BlockStorageCobble
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockStorageCobble extends BlockAM {

    public BlockStorageCobble(int id) {
        super(id, Material.iron);
        this.setHardness(13F);
        this.setStepSound(soundMetalFootstep);
        this.setUnlocalizedName(Strings.STORAGE_COBBLE_NAME);
        
    }

}
