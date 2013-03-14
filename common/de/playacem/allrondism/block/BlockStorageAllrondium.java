package de.playacem.allrondism.block;

import de.playacem.allrondism.lib.Strings;

import net.minecraft.block.material.Material;

public class BlockStorageAllrondium extends BlockAM {

	private static int textureID = 2;
	
	public BlockStorageAllrondium(int id) {
		super(id, textureID, Material.iron);
		this.setHardness(13F);
		this.setStepSound(soundMetalFootstep);
		this.setBlockName(Strings.STORAGE_ALLRONDIUM_NAME);
	}

}
