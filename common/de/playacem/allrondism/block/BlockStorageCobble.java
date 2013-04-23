package de.playacem.allrondism.block;

import net.minecraft.block.material.Material;
import de.playacem.allrondism.lib.Strings;

public class BlockStorageCobble extends BlockAM {

    public BlockStorageCobble(int id) {
        super(id, Material.iron);
        this.setHardness(13F);
        this.setStepSound(soundMetalFootstep);
        this.setUnlocalizedName(Strings.STORAGE_COBBLE_NAME);
    }

}
