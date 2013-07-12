package playacem.allrondism.block;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import playacem.allrondism.lib.Strings;
import playacem.allrondism.lib.Text;


/**
 * Allrondism
 * 
 * ItemBlockPlantRose
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ItemBlockPlantRose extends ItemBlockExtended {

    public ItemBlockPlantRose(int id) {
        super(id);
        setMaxDamage(0);
        setHasSubtypes(true);
        setNames(Strings.ROSES);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean advancedToolTips) {
        infoList.add("This Rose is based of Light and Time");
        infoList.add("either " + Text.i(Text.add("Black", Text.COLOR_ORANGE)) + " or " + Text.i(Text.add("White", Text.COLOR_ORANGE)));

    }
}
