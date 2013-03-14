package de.playacem.allrondism.block;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import de.playacem.allrondism.AllrondismMod;
import de.playacem.allrondism.lib.Sprites;

public class BlockAM extends Block {

	public BlockAM(int id, int texture, Material material) {
		
		super(id, texture, material);
		setCreativeTab(AllrondismMod.tabsAM);
		setHardness(0.5F);
	}

	@Override
	public String getTextureFile(){
		return Sprites.BLOCK_PNG;
	}
	
}
