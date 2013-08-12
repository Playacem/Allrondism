package playacem.allrondism.tileentity;

import playacem.allrondism.block.BlockMultiFurnace;
import playacem.allrondism.lib.Strings;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

/**
 * Allrondism
 * 
 * TileEntityMultiFurnaceCore
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit pahimar, Minalien
 */
public class TileEntityMultiFurnaceCore extends TileAM implements ISidedInventory {

    private ItemStack[] inventory;
    private static int[] inputSlots = {0, 1, 2};
    private static int[] fuelSlots = {3, 4, 5};
    private static int[] outputSlots = {6, 7, 8};
    
    public static final int INVENTORY_SIZE = 9;
    
    public int furnaceBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int furnaceCookTime = 0;
    
    private boolean isValidMultiblock = false;
    
    public TileEntityMultiFurnaceCore() {
        super();
        inventory = new ItemStack[INVENTORY_SIZE];
    }

    public boolean getIsValid() {
        return isValidMultiblock;
    }
    
    public boolean isActive() {
        int metadata = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
        if(metadata > 6) return true;
        return false;
    }
    
    public void invalidateMultiBlock() {
        isValidMultiblock = false;
        
        int metadata = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
        if ( isActive() ) metadata -= 4;
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, metadata, 2);
        
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
       
        ItemStack itemStack = getStackInSlot(slot);
        if(itemStack != null) {
            if(itemStack.stackSize <= amount) {
                setInventorySlotContents(slot, null);
            } else {
                itemStack = itemStack.splitStack(amount);
                if(itemStack.stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }
        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack itemStack = getStackInSlot(slot);
        if(itemStack != null) {
            inventory[slot] = null;
            return itemStack;
        } else return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemstack) {
        inventory[slot] = itemstack;
        
        if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
            itemstack.stackSize = this.getInventoryStackLimit();
    }

    @Override
    public String getInvName() {
        return this.hasCustomName() ? this.getCustomName() : Strings.CONTAINER_MULTI_FURNACE_NAME;
    }

    @Override
    public boolean isInvNameLocalized() {
        return this.hasCustomName();
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
        for(int i = 0; i < outputSlots.length; ++i) {
            if( outputSlots[i] == slot) return false;
        }
        for(int i = 0; i < fuelSlots.length; ++i) {
            if( fuelSlots[i] == slot) return TileEntityFurnace.isItemFuel(itemstack);
        }
        for(int i = 0; i < inputSlots.length; ++i) {
            if( inputSlots[i] == slot) return true;
        }
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
