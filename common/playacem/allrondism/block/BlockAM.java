package playacem.allrondism.block;

import playacem.allrondism.AllrondismMod;
import playacem.allrondism.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAM extends Block {

    public BlockAM(int id, Material material) {

        super(id, material);
        setCreativeTab(AllrondismMod.tabsAM);
        setHardness(0.5F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()+ ":" + this.getUnlocalizedName2());
    }

}
