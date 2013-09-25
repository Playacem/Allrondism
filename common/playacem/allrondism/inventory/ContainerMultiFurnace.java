package playacem.allrondism.inventory;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import playacem.allrondism.tileentity.TileEntityMultiFurnaceCore;

/**
 * Allrondism
 * 
 * ContainerMultiFurnace
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ContainerMultiFurnace extends Container {
    private TileEntityMultiFurnaceCore tileCore;
    private int bonusSlotsInput, bonusSlotsFuel;
    private final int PLAYER_INVENTORY_ROWS = 3;
    private final int PLAYER_INVENTORY_COLUMNS = 9;
    
    public ContainerMultiFurnace(InventoryPlayer playerInventory, TileEntityMultiFurnaceCore tileEntity) {
        this.tileCore = tileEntity;
        // used in transferStackInSlot, removes shift clicking into locked slots
        this.bonusSlotsInput = tileCore.bonusSlotsInput;
        this.bonusSlotsFuel = tileCore.bonusSlotsFuel;
        
        //Input Slots
        for(int i = 0; i < TileEntityMultiFurnaceCore.inputSlots.length; ++i) {
            if(tileCore.bonusSlotsInput >= i) {
                addSlotToContainer(new Slot(tileCore, TileEntityMultiFurnaceCore.inputSlots[i], 21 + 16 * i, 17));  
            }else {
                addSlotToContainer(new SlotLocked(tileCore, TileEntityMultiFurnaceCore.inputSlots[i], 21 + 16 * i, 17));
            }
                
            
        }
        
        //Fuel Slots
        for(int i = 0; i < TileEntityMultiFurnaceCore.fuelSlots.length; ++i) {
            if(tileCore.bonusSlotsFuel >= i) {
                addSlotToContainer(new Slot(tileCore, TileEntityMultiFurnaceCore.fuelSlots[i], 21 + 16 * i, 53));  
            }else {
                addSlotToContainer(new SlotLocked(tileCore, TileEntityMultiFurnaceCore.fuelSlots[i], 21 + 16 * i, 53)); 
            }
            
        }
        
        //Output Slots
        for(int i = 0; i < TileEntityMultiFurnaceCore.outputSlots.length; ++i) {
            if(tileCore.bonusSlotsOutput >= i) {
                addSlotToContainer(new SlotFurnace(playerInventory.player, tileCore, TileEntityMultiFurnaceCore.outputSlots[i], 108 + 16 * i, 35)); 
            }else {
                addSlotToContainer(new SlotFurnaceLocked(playerInventory.player, tileCore, TileEntityMultiFurnaceCore.outputSlots[i], 108 + 16 * i, 35)); 
            }
            
        }
        
        bindPlayerInventory(playerInventory);
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {

        return tileCore.isUseableByPlayer(entityplayer);
    }
    
    private void bindPlayerInventory(InventoryPlayer playerInventory) {
        // Inventory
        for(int inventoryRowIndex = 0; inventoryRowIndex < PLAYER_INVENTORY_ROWS; ++inventoryRowIndex) {
            for(int inventoryColumnIndex = 0; inventoryColumnIndex < PLAYER_INVENTORY_COLUMNS; ++inventoryColumnIndex) {
                addSlotToContainer(new Slot(playerInventory, inventoryColumnIndex + inventoryRowIndex * 9 + 9, 8 + inventoryColumnIndex * 18 , 84 + inventoryRowIndex * 18));
            }
        }
        // Action Bar
        for(int actionBarSlotIndex = 0; actionBarSlotIndex < PLAYER_INVENTORY_COLUMNS; ++actionBarSlotIndex)
            addSlotToContainer(new Slot(playerInventory, actionBarSlotIndex, 8 + actionBarSlotIndex * 18, 142));
    }
    
    /**
     * based of EE3s Aludel
     * 
     * handles shiftclicking
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {

        ItemStack itemStack = null;
        Slot slot = (Slot) inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack()) {

            ItemStack slotItemStack = slot.getStack();
            itemStack = slotItemStack.copy();

            /**
             * If we are shift-clicking an item out of the Aludel's container,
             * attempt to put it in the first available slot in the player's
             * inventory
             */
            if (slotIndex < TileEntityMultiFurnaceCore.INVENTORY_SIZE) {
                /*
                 *  mergeItemStack attempts to merge the given ItemStack into the slots 
                 *  within the given range (x, y-1)
                 *  
                 *  Boolean flag: startingPosition, false for Beginning, true for the End
                 *  
                 *  mergeItemStack will return true if the stack can be merged and false if it can't
                 */
                if (!this.mergeItemStack(slotItemStack, TileEntityMultiFurnaceCore.INVENTORY_SIZE, inventorySlots.size(), false)) {
                    return null;
                }
            }
            else {

                /**
                 * If the stack being shift-clicked into the Aludel's container
                 * is a fuel, first try to put it in the fuel slot. If it cannot
                 * be merged into the fuel slot, try to put it in the input
                 * slot.
                 */
                if (TileEntityFurnace.isItemFuel(slotItemStack)) {
                    if (!this.mergeItemStack(slotItemStack, TileEntityMultiFurnaceCore.fuelSlots[0], TileEntityMultiFurnaceCore.fuelSlots[this.bonusSlotsFuel] + 1, false)) {
                        return null;
                    }
                }

                /**
                 * Finally, attempt to put stack into the input slot
                 */
                else if (!this.mergeItemStack(slotItemStack, TileEntityMultiFurnaceCore.inputSlots[0], TileEntityMultiFurnaceCore.inputSlots[this.bonusSlotsInput] + 1, false)) {
                    return null;
                }
            }

            if (slotItemStack.stackSize == 0) {
                slot.putStack((ItemStack) null);
            }
            else {
                slot.onSlotChanged();
            }
        }

        return itemStack;
    }
}
