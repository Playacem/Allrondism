package playacem.allrondism.tileentity;

import net.minecraft.item.ItemStack;


/**
 * Allrondism
 * 
 * TileEntityMultiFurnaceAutomationOutput
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityMultiFurnaceAutomationOutput extends TileEntityMultiFurnaceDummy {


    /* ISidedInventory stuff */
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {

        return TileEntityMultiFurnaceCore.outputSlots;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int side) {

        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemstack, int side) {
        
        for (int i = 0; i < TileEntityMultiFurnaceCore.outputSlots.length; ++i) {
            if (TileEntityMultiFurnaceCore.outputSlots[i] == slot)
                return true;
        }
        return false;
    }
}
