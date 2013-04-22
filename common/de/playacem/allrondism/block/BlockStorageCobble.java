package de.playacem.allrondism.block;

import de.playacem.allrondism.lib.Strings;
import net.minecraft.block.material.Material;

public class BlockStorageCobble extends BlockAM {

	private static int textureID = 3;

	public BlockStorageCobble(int id) {
		super(id, textureID, Material.iron);
		this.setHardness(13F);
		this.setStepSound(soundMetalFootstep);
		this.setUnlocalizedName(Strings.STORAGE_COBBLE_NAME);
	}

}
