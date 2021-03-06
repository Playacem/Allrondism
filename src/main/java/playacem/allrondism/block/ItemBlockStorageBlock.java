package playacem.allrondism.block;

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
 * ItemBlockStorageBlock
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ItemBlockStorageBlock extends ItemBlockExtended {

    public ItemBlockStorageBlock(int id) {

        super(id);
        setMaxDamage(0);
        setHasSubtypes(true);
        setNames(Strings.STORAGE_BLOCKS);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean advancedToolTips) {

        infoList.add("Craftable using");
        infoList.add("9 " + Text.COLOR_LIGHT_GREEN + Strings.STORAGE_BLOCKS[stack.getItemDamage()]
                + getAdditionalInfo(stack.getItemDamage()));
    }

    private String getAdditionalInfo(int meta) {

        if (meta == 1)
            return "stone";
        return "";
    }
}
