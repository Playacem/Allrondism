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
 * ItemDyeRose
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemDyeRose extends ItemMulti {

    public ItemDyeRose(int id) {

        super(id);
        setMaxDamage(0);
        this.setMaxStackSize(64);
        setUnlocalizedName(Strings.DYE_ROSE_NAME);
        setNames(Strings.ROSES);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean advancedToolTips) {

        int metadata = stack.getItemDamage();
        infoList.add("Do not waste your " + Text.add(getItemNameByMetadata(metadata), Text.COLOR_LIGHT_GREEN) + " as " + Text.add(getColorByMetadata(metadata) + " Dye", Text.COLOR_ORANGE) + "!");
        infoList.add("Use this renewable " + Text.add(getColorByMetadata(metadata) + " Dye", Text.COLOR_LIGHT_GREEN) + " instead!");
        super.addInformation(stack, player, infoList, advancedToolTips);
    }

    private String getColorByMetadata(int meta) {

        if (meta == 1) return "White";
        return "Black";
    }

    private String getItemNameByMetadata(int meta) {

        if (meta == 1) return "Bone Meal";
        return "Ink Sacs";
    }
}
