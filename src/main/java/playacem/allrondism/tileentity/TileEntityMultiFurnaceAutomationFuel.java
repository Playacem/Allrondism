package playacem.allrondism.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

/**
 * Allrondism
 * 
 * TileEntityMultiFurnaceAutomationFuel
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityMultiFurnaceAutomationFuel extends TileEntityMultiFurnaceDummy {


    /* ISidedInventory stuff */
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {

        return TileEntityMultiFurnaceCore.fuelSlots;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int side) {

        for (int i = 0; i < TileEntityMultiFurnaceCore.fuelSlots.length; ++i) {
            if (TileEntityMultiFurnaceCore.fuelSlots[i] == slot)
                return TileEntityFurnace.isItemFuel(itemstack);
        }
        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemstack, int side) {

        for (int i = 0; i < TileEntityMultiFurnaceCore.fuelSlots.length; ++i) {
            if (TileEntityMultiFurnaceCore.fuelSlots[i] == slot)
                return TileEntityFurnace.isItemFuel(itemstack);
        }
        return false;
    }
}
