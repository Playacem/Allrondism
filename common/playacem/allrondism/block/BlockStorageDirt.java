package playacem.allrondism.block;

import playacem.allrondism.lib.Strings;
import net.minecraft.block.material.Material;

public class BlockStorageDirt extends BlockAM {

    public BlockStorageDirt(int id) {
        super(id, Material.ground);
        this.setHardness(10F);
        this.setStepSound(soundGrassFootstep);
        this.setUnlocalizedName(Strings.STORAGE_DIRT_NAME);
        this.setLightValue(0.8F);
    }

}
