package playacem.allrondism.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import playacem.allrondism.Allrondism;
import playacem.allrondism.lib.BlockIDs;
import playacem.allrondism.lib.ExtensionData;
import playacem.allrondism.lib.Reference;
import playacem.allrondism.tileentity.TileAM;
import playacem.allrondism.tileentity.TileEntityMultiFurnaceCore;
import playacem.allrondism.tileentity.TileEntityMultiFurnaceDummy;
import playacem.allrondism.tileentity.TileEntityMultiFurnaceSlotFuel;
import playacem.allrondism.tileentity.TileEntityMultiFurnaceSlotInput;
import playacem.allrondism.tileentity.TileEntityMultiFurnaceSlotOutput;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
        setCreativeTab(Allrondism.tabsAM);
        setHardness(0.5F);
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
        int facing = MathHelper.floor_double((double) entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

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

        world.setBlockMetadataWithNotify(x, y, z, direction, 2);

        if (itemStack.hasDisplayName()) {
            ((TileAM) world.getBlockTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
        }

        ((TileAM) world.getBlockTileEntity(x, y, z)).setOrientation(direction);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {

        world.setBlockTileEntity(x, y, z, this.createNewTileEntity(world, world.getBlockId(x, y, z), world.getBlockMetadata(x, y, z)));
    }

    public TileEntity createNewTileEntity(World world, int blockID, int meta) {

        if (blockID == BlockIDs.MULTI_FURNACE_CORE)
            return new TileEntityMultiFurnaceCore();
        if (blockID == BlockIDs.MULTI_FURNACE_EXTENSION) {
            switch (meta) {
                case ExtensionData.DUMMY_META:
                    return new TileEntityMultiFurnaceDummy();
                case ExtensionData.SLOT_INPUT_META:
                    return new TileEntityMultiFurnaceSlotInput();
                case ExtensionData.SLOT_FUEL_META:
                    return new TileEntityMultiFurnaceSlotFuel();
                case ExtensionData.SLOT_OUTPUT_META:
                    return new TileEntityMultiFurnaceSlotOutput();
                default:
                    return new TileEntityMultiFurnaceDummy();
            }
        }
        return null;
    }

}
