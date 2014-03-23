package playacem.allrondism.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

/**
 * Allrondism
 * 
 * SlotFurnaceLocked
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit CoFH
 */
public class SlotFurnaceLocked extends SlotFurnace {

    public SlotFurnaceLocked(EntityPlayer player, IInventory inventory, int slotIndex, int posX, int posY) {

        super(player, inventory, slotIndex, posX, posY);
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
