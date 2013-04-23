package de.playacem.allrondism.block;

import net.minecraft.block.material.Material;
import de.playacem.allrondism.lib.Strings;

public class BlockStorageDirt extends BlockAM {

    public BlockStorageDirt(int id) {
        super(id, Material.ground);
        this.setHardness(10F);
        this.setStepSound(soundGrassFootstep);
        this.setUnlocalizedName(Strings.STORAGE_DIRT_NAME);
        this.setLightValue(0.8F);
    }

}
