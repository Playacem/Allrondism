package de.playacem.allrondism.block;

import de.playacem.allrondism.lib.Strings;
import net.minecraft.block.material.Material;

public class BlockStorageDirt extends BlockAM {

	private static int textureID = 0;
				
	public BlockStorageDirt(int id) {
		super(id, textureID, Material.ground);
		this.setHardness(10F);
		this.setStepSound(soundGrassFootstep);
		this.setBlockName(Strings.STORAGE_DIRT_NAME);
		this.setLightValue(0.8F);
	}

}
