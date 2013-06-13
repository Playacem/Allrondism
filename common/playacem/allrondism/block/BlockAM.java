package playacem.allrondism.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import playacem.allrondism.Allrondism;
import playacem.allrondism.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Allrondism
 * 
 * BlockAM
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockAM extends Block {

    public BlockAM(int id, Material material) {

        super(id, material);
        setCreativeTab(Allrondism.tabsAM);
        setHardness(0.5F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg) {
        blockIcon = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                + this.getUnlocalizedName2());
    }

}
