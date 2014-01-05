package playacem.allrondism.tileentity;

import net.minecraft.item.ItemStack;


/**
 * Allrondism
 * 
 * TileEntityMultiFurnaceAutomationInput
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityMultiFurnaceAutomationInput extends TileEntityMultiFurnaceDummy {

    
    /* ISidedInventory stuff */
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {

        return TileEntityMultiFurnaceCore.inputSlots;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int side) {
        

        for (int i = 0; i < TileEntityMultiFurnaceCore.inputSlots.length; ++i) {
            if (TileEntityMultiFurnaceCore.inputSlots[i] == slot)
                return true;
        }

        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemstack, int side) {
        
        for (int i = 0; i < TileEntityMultiFurnaceCore.inputSlots.length; ++i) {
            if (TileEntityMultiFurnaceCore.inputSlots[i] == slot)
                return true;
        }

        return false;
    }
}
