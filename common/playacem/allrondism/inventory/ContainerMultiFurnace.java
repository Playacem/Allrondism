package playacem.allrondism.inventory;

import playacem.allrondism.tileentity.TileEntityMultiFurnaceCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;

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
    private final int PLAYER_INVENTORY_ROWS = 3;
    private final int PLAYER_INVENTORY_COLUMNS = 9;
    
    public ContainerMultiFurnace(InventoryPlayer playerInventory, TileEntityMultiFurnaceCore tileEntity) {
        this.tileCore = tileEntity;
        
        //TODO add Slots coordinates
        
        //Input Slots
        for(int i = 0; i < tileCore.inputSlots.length; ++i) {
            addSlotToContainer(new Slot(tileCore, tileCore.inputSlots[i], 21 + 16 * i, 17)); 
        }
        
        //Fuel Slots
        for(int i = 0; i < tileCore.fuelSlots.length; ++i) {
            addSlotToContainer(new Slot(tileCore, tileCore.fuelSlots[i], 21 + 16 * i, 53)); 
        }
        
        //Output Slots
        for(int i = 0; i < tileCore.outputSlots.length; ++i) {
            addSlotToContainer(new SlotFurnace(playerInventory.player, tileCore, tileCore.outputSlots[i], 108 + 16 * i, 35)); 
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
}
