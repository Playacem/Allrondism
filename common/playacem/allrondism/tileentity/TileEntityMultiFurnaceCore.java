package playacem.allrondism.tileentity;

import playacem.allrondism.block.BlockMultiFurnace;
import playacem.allrondism.lib.Strings;
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

    private ItemStack[] inventory;
    
    public static final int INVENTORY_SIZE = 9;
    
    public int furnaceBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int furnaceCookTime = 0;
    
    private boolean isValidMultiblock = false;
    
    public TileEntityMultiFurnaceCore() {
        inventory = new ItemStack[INVENTORY_SIZE];
    }

    public boolean getIsValid() {
        return isValidMultiblock;
    }
    
    public void invalidateMultiBlock() {
        isValidMultiblock = false;
        
        int metadata = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, metadata - 4, 2);
        
        furnaceBurnTime = 0;
        currentItemBurnTime = 0;
        furnaceCookTime = 0;
        
        revertDummies();
    }
    
    public boolean checkIfProperlyFormed() {
        return false;
    }
    
    public void convertDummies() {
        
    }
    
    private void revertDummies() {
        
    }
    
    /* IInventory stuff */
    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemstack) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getInvName() {
        return this.hasCustomName() ? this.getCustomName() : Strings.CONTAINER_MULTI_FURNACE_NAME;
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }


    @Override
    public void openChest() { }

    @Override
    public void closeChest() { }

    @Override
    public boolean isStackValidForSlot(int slot, ItemStack itemstack) {
        // TODO Auto-generated method stub
        return false;
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
