package playacem.allrondism.block;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import playacem.allrondism.lib.Strings;

/**
 * Allrondism
 * 
 * ItemBlockMultiFurnace
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ItemBlockMultiFurnace extends ItemBlockExtended {

    public ItemBlockMultiFurnace(int id) {
        super(id);
        setMaxDamage(0);
        setHasSubtypes(true);
        setNames(Strings.MULTI_FURNACE_BLOCKS);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean advancedToolTips) {
        infoList.add("A MultiBlock!");
    }

}