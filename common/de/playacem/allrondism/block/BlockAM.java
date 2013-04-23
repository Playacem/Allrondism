package de.playacem.allrondism.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import de.playacem.allrondism.AllrondismMod;

public class BlockAM extends Block {

    public BlockAM(int id, Material material) {

        super(id, material);
        setCreativeTab(AllrondismMod.tabsAM);
        setHardness(0.5F);
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {

    }

}
