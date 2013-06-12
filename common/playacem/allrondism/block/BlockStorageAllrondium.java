package playacem.allrondism.block;

import playacem.allrondism.lib.Strings;
import net.minecraft.block.material.Material;

/**
 * Allrondism
 * 
 * BlockStorageAllrondium
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockStorageAllrondium extends BlockAM {

    public BlockStorageAllrondium(int id) {
        super(id, Material.iron);
        this.setHardness(5F);
        this.setStepSound(soundMetalFootstep);
        this.setUnlocalizedName(Strings.STORAGE_ALLRONDIUM_NAME);
    }

}
