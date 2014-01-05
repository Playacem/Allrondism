package playacem.allrondism.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Allrondism
 * 
 * TileEntityMultiFurnaceDummy
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityMultiFurnaceDummy extends TileAM implements ISidedInventory, ICoreExtension {

    protected TileEntityMultiFurnaceCore tileEntityCore = null;
    protected int coreX;
    protected int coreY;
    protected int coreZ;

    @Override
    public void setCore(TileEntityMultiFurnaceCore core) {

        coreX = core.xCoord;
        coreY = core.yCoord;
        coreZ = core.zCoord;
        tileEntityCore = core;
    }

    @Override
    public TileEntityMultiFurnaceCore getCore() {

        if (tileEntityCore == null) {
            tileEntityCore = (TileEntityMultiFurnaceCore) worldObj.getBlockTileEntity(coreX, coreY, coreZ);
        }
        return tileEntityCore;
    }

    @Override
    public void readFromNBT(NBTTagCompound compund) {

        super.readFromNBT(compund);

        coreX = compund.getInteger("CoreX");
        coreY = compund.getInteger("CoreY");
        coreZ = compund.getInteger("CoreZ");
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {

        super.writeToNBT(compound);

        compound.setInteger("CoreX", coreX);
        compound.setInteger("CoreY", coreY);
        compound.setInteger("CoreZ", coreZ);
    }

    /* IInventory stuff */
    @Override
    public int getSizeInventory() {

        return tileEntityCore.getSizeInventory();
    }

    @Override
    public ItemStack getStackInSlot(int i) {

        return tileEntityCore.getStackInSlot(i);
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {

        return tileEntityCore.decrStackSize(i, j);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {

        return tileEntityCore.getStackInSlotOnClosing(i);
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {

        tileEntityCore.setInventorySlotContents(i, itemstack);
    }

    @Override
    public String getInvName() {

        return tileEntityCore.getInvName();
    }

    @Override
    public boolean isInvNameLocalized() {

        return tileEntityCore.isInvNameLocalized();
    }

    @Override
    public int getInventoryStackLimit() {

        return tileEntityCore.getInventoryStackLimit();
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {

        return tileEntityCore.isUseableByPlayer(entityplayer);
    }

    @Override
    public void openChest() {

    }

    @Override
    public void closeChest() {

    }

    @Override
    public boolean isStackValidForSlot(int i, ItemStack itemstack) {

        return tileEntityCore.isStackValidForSlot(i, itemstack);
    }

    /* ISidedInventory stuff */
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {

        return null;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int j) {

        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemstack, int j) {

        return false;
    }
}
