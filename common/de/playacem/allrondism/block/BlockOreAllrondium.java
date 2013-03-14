package de.playacem.allrondism.block;

import java.util.Random;

import de.playacem.allrondism.lib.ItemIDs;
import de.playacem.allrondism.lib.Strings;
import net.minecraft.block.material.Material;

public class BlockOreAllrondium extends BlockAM {

	private static int textureID = 1;
	
	public BlockOreAllrondium(int id) {
		
		super(id, textureID, Material.rock);
		this.setHardness(15F);
		this.setBlockName(Strings.ORE_ALLRONDIUM_NAME);
	}

	public int idDropped(int par1, Random random, int zero){
		return ItemIDs.ALLRONDIUM_GEM;
	}
	
}
