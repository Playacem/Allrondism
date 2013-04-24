package playacem.allrondism.block;

import playacem.allrondism.lib.Strings;
import net.minecraft.block.material.Material;

public class BlockStorageAllrondium extends BlockAM {

    public BlockStorageAllrondium(int id) {
        super(id, Material.iron);
        this.setHardness(13F);
        this.setStepSound(soundMetalFootstep);
        this.setUnlocalizedName(Strings.STORAGE_ALLRONDIUM_NAME);
    }

}
