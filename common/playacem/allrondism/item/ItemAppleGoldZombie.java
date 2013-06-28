package playacem.allrondism.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import playacem.allrondism.lib.Colors;
import playacem.allrondism.lib.Reference;
import playacem.allrondism.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Allrondism
 * 
 * ItemAppleGoldZombie
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemAppleGoldZombie extends ItemAM {

    public ItemAppleGoldZombie(int id) {
        super(id);
        this.setUnlocalizedName(Strings.APPLE_GOLD_ZOMBIE_NAME);
        this.setMaxStackSize(64);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName()
                .substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean advancedToolTips) {
        infoList.add("This golden Apple is good enough");
        infoList.add("for Zombies, especially " + Colors.TEXT_COLOR_LIGHT_RED + "Villager Zombies");
    }
}
