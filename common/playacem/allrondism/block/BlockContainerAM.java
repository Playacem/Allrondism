package playacem.allrondism.block;

import playacem.allrondism.lib.Reference;
import playacem.allrondism.tileentity.TileAM;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

/**
 * Allrondism
 * 
 * BlockContainerAM
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit pahimar
 */
public abstract class BlockContainerAM extends BlockContainer {

    public BlockContainerAM(int id, Material material) {
        super(id, material);
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg) {
        blockIcon = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName2());
    }

    /**
     * Sets the direction of the block when placed
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityLiving, ItemStack itemStack) {

        int direction = 0;
        int facing = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

        if (facing == 0) {
            direction = ForgeDirection.NORTH.ordinal(); // 2
        }
        else if (facing == 1) {
            direction = ForgeDirection.EAST.ordinal(); // 5
        }
        else if (facing == 2) {
            direction = ForgeDirection.SOUTH.ordinal(); // 3
        }
        else if (facing == 3) {
            direction = ForgeDirection.WEST.ordinal(); // 4
        }

        world.setBlockMetadataWithNotify(x, y, z, direction, 3);

        if (itemStack.hasDisplayName()) {
            ((TileAM) world.getBlockTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
        }

        ((TileAM) world.getBlockTileEntity(x, y, z)).setOrientation(direction);
    }
}
