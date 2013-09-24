package playacem.allrondism.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Allrondism
 * 
 * SlotLocked
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit CoFH
 */
public class SlotLocked extends Slot {

    public SlotLocked(IInventory inventory, int slotIndex, int posX, int posY) {
        super(inventory, slotIndex, posX, posY);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {

        return false;
    }

    @Override
    public boolean canTakeStack(EntityPlayer player) {

        return false;
    }
}
