package playacem.allrondism.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;

/**
 * Allrondism
 * 
 * TileEntityMultiFurnaceCore
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityMultiFurnaceCore extends TileAM implements ISidedInventory {

    public TileEntityMultiFurnaceCore() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public int getSizeInventory() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getInvName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isInvNameLocalized() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void openChest() {
        // TODO Auto-generated method stub

    }

    @Override
    public void closeChest() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isStackValidForSlot(int i, ItemStack itemstack) {
        // TODO Auto-generated method stub
        return false;
    }

    /* ISidedInventory stuff */
    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        // TODO Auto-generated method stub
        return false;
    }

}
