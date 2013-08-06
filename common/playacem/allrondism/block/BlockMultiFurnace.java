package playacem.allrondism.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import playacem.allrondism.lib.Reference;
import playacem.allrondism.lib.Strings;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

/**
 * Allrondism
 * 
 * BlockMultiFurnace
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class BlockMultiFurnace extends BlockContainerAM {

    private String[] names = Strings.MULTI_FURNACE_BLOCKS;
    @SideOnly(Side.CLIENT)
    private Icon[] icons = new Icon[names.length];
    
    public BlockMultiFurnace(int id) {
        super(id, Material.rock);
        setHardness(3.0F);
        setResistance(10.0F);
        setStepSound(soundStoneFootstep);
        setUnlocalizedName(Strings.MULTI_FURNACE_NAME);
    }

    @Override
    public int damageDropped(int meta) {
        if(meta <= 8) return 0;
        return meta;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister iconReg) {
        for (int i = 0; i < icons.length; i++) {
            icons[i] = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + getUnlocalizedName2() + names[i]);
        }
    }

    @Override
    public Icon getIcon(int side, int meta) {

        return icons[Math.min(meta, icons.length)];
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {
        // TODO Auto-generated method stub
        return null;
    }

}
