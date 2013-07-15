package playacem.allrondism.block;

import java.util.List;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Allrondism
 * 
 * ItemBlockBasic
 * 
 * provides ToolTips for non-metadata Blocks
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBlockBasic extends ItemBlock {

    public ItemBlockBasic(int id) {
        super(id);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean advancedToolTips) {
        int id = stack.itemID;
        
        if(id == ModBlocks.oreAllrondium.blockID) {
            infoList.add("This ore cannot be");
            infoList.add("found underground");
            if(advancedToolTips) {
                infoList.add("Hint: The Recipe involves Diamonds, stone, and 2 opposite colors");
            }
        }
        
        if(id == ModBlocks.glassSunBlocker.blockID) {
            infoList.add("This glass filters any light");
            infoList.add("which passes through it");
            if(advancedToolTips) {
                infoList.add("Tip: Use it for your mob traps");
            }
        }
    }
}