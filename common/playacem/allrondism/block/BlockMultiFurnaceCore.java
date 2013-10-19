package playacem.allrondism.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import playacem.allrondism.Allrondism;
import playacem.allrondism.core.util.LogHelper;
import playacem.allrondism.lib.GuiIDs;
import playacem.allrondism.lib.Reference;
import playacem.allrondism.lib.Strings;
import playacem.allrondism.tileentity.TileEntityMultiFurnaceCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Allrondism
 * 
 * BlockMultiFurnaceCore
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class BlockMultiFurnaceCore extends BlockContainerAM {

    @SideOnly(Side.CLIENT)
    private Icon faceIconUnlit;
    @SideOnly(Side.CLIENT)
    private Icon faceIconLit;

    public BlockMultiFurnaceCore(int id) {

        super(id, Material.rock);
        setHardness(3.0F);
        setResistance(10.0F);
        setStepSound(soundStoneFootstep);
        setUnlocalizedName(Strings.MULTI_FURNACE_CORE_NAME);
    }

    @Override
    public int damageDropped(int meta) {

        return 0;
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {

        return ((world.getBlockMetadata(x, y, z) > 5) ? 15 : 0); 
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister iconReg) {

        blockIcon = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "storageBlockCobble");
        faceIconUnlit = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "multiFurnaceCoreFront_Unlit");
        faceIconLit = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "multiFurnaceCoreFront_Lit");
    }

    @Override
    public Icon getIcon(int side, int meta) {

        boolean isActive = meta > 5;
        int facing = isActive ? meta - 4 : meta;

        return (side == getSideFromFacing(facing) ? (isActive ? faceIconLit : faceIconUnlit ) : blockIcon);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {

        if (world.isRemote)
            return true;
        if (player.isSneaking())
            return false;

        TileEntityMultiFurnaceCore tileCore = (TileEntityMultiFurnaceCore) world.getBlockTileEntity(x, y, z);

        if (tileCore != null) {

            LogHelper.debug("oBA (Side: " + (world.isRemote ? "Client" : "Server") + "): Is valid? " + (tileCore.getIsValid() ? "yes" : "no") + " [SizeSaved:] " + tileCore.sizeMultiblock);
            
            // Determine if the Multiblock is currently known to be valid
            if (!tileCore.getIsValid()) {

                for (int i = 9; i >= 3; --i) {

                    if (i % 2 == 0) 
                        continue;

                    if (tileCore.checkIfProperlyFormed(i)) {
                        
                        tileCore.convertDummies(i);
                        player.sendChatToPlayer("Multi-Furnace Created!");
                        LogHelper.debug("Final Size MB: " + tileCore.sizeMultiblock);
                        break;
                    }
                }
            }
            
            // Check if the multi-block structure has been formed.
            if (tileCore.getIsValid()) 
                player.openGui(Allrondism.instance, GuiIDs.MULTI_FURNACE, world, x, y, z);
        }

        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {

        return new TileEntityMultiFurnaceCore();
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {

        TileEntityMultiFurnaceCore tileCore = (TileEntityMultiFurnaceCore) world.getBlockTileEntity(x, y, z);

        if (tileCore != null) {
            tileCore.invalidateMultiBlock(); 
        }
        dropItems(world, x, y, z);
        super.breakBlock(world, x, y, z, par5, par6);
    }

    private static int getSideFromFacing(int facing) {

        switch (facing) {
            case 4: // WEST
                return 4;

            case 5: // EAST
                return 5;

            case 2: // NORTH
                return 2;

            case 3: // SOUTH
                return 3;

            default:
                return 4;
        }
    }

    private void dropItems(World world, int x, int y, int z) {

        Random rand = new Random();

        TileEntityMultiFurnaceCore tileCore = (TileEntityMultiFurnaceCore) world.getBlockTileEntity(x, y, z);
        if (tileCore == null)
            return;

        for (int slot = 0; slot < tileCore.getSizeInventory(); slot++) {
            ItemStack item = tileCore.getStackInSlot(slot);

            if (item != null && item.stackSize > 0) {
                float rx = rand.nextFloat() * 0.8f + 0.1f;
                float ry = rand.nextFloat() * 0.8f + 0.1f;
                float rz = rand.nextFloat() * 0.8f + 0.1f;

                EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz, item.copy());
                world.spawnEntityInWorld(entityItem);
                item.stackSize = 0;
            }
        }
    }
}
