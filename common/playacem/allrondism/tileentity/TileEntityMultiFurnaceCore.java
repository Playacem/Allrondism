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

    public int furnaceBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int furnaceCookTime = 0;
    
    private boolean isValidMultiblock = false;
    
    public TileEntityMultiFurnaceCore() {
    }

    public boolean getIsValid() {
        return isValidMultiblock;
    }
    
    public void invalidateMultiBlock() {
        isValidMultiblock = false;
        
        int metadata = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, metadata - 1, 2);
        
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
    public boolean isStackValidForSlot(int i, ItemStack itemstack) {
        // TODO Auto-generated method stub
        return false;
    }

    /* ISidedInventory stuff */
    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        return null;
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j) {
        return false;
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        return false;
    }

}
