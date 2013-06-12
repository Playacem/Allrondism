package playacem.allrondism.block;

import playacem.allrondism.core.util.UtilBlock;
import playacem.allrondism.lib.Strings;
import net.minecraft.block.material.Material;

/**
 * Allrondism
 * 
 * BlockStorageDirt
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockStorageDirt extends BlockAM {

    public BlockStorageDirt(int id) {
        
        super(id, Material.ground);
        this.setHardness(0.5F);
        this.setStepSound(soundGrassFootstep);
        this.setUnlocalizedName(Strings.STORAGE_DIRT_NAME);
        this.setLightValue(UtilBlock.getLightValueFromInt(8));
    }

}
