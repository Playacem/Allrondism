package playacem.allrondism.block;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import playacem.allrondism.Allrondism;
import playacem.allrondism.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Allrondism
 * 
 * BlockGlassSunBlocker
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class BlockGlassSunBlocker extends BlockAM {

    private boolean localFlag = false;

    public BlockGlassSunBlocker(int id) {
        super(id, Material.glass);
        this.setLightOpacity(100);
        this.setCreativeTab(Allrondism.tabsAM);
        this.setHardness(0.2F);
        this.setUnlocalizedName(Strings.GLASS_SUN_BLOCKER_NAME);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderBlockPass() {
        return 0;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess IBlockAccess, int x, int y, int z, int side)
    {
        int i1 = IBlockAccess.getBlockId(x, y, z);
        return !localFlag && i1 == blockID ? false : super.shouldSideBeRendered(IBlockAccess, x, y, z, side);
    }

}
