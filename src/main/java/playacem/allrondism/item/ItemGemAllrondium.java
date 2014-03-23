package playacem.allrondism.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import playacem.allrondism.lib.Strings;
import playacem.allrondism.lib.Text;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Allrondism
 * 
 * ItemGemAllrondium
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemGemAllrondium extends ItemAM {

    public ItemGemAllrondium(int id) {

        super(id);
        this.setUnlocalizedName(Strings.GEM_ALLRONDIUM_NAME);
        this.setMaxStackSize(64);
    }

    @Override
    public String getItemDisplayName(ItemStack stack) {

        return Text.COLOR_PURPLE + super.getItemDisplayName(stack);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean advancedToolTips) {

        infoList.add("This gem is impossible to ");
        infoList.add("obtain without using " + Text.add("Diamonds", Text.COLOR_LIGHT_GREEN));
        super.addInformation(stack, player, infoList, advancedToolTips);
    }
}
