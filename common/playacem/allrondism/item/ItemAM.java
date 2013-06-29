package playacem.allrondism.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import playacem.allrondism.Allrondism;
import playacem.allrondism.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Allrondism
 * 
 * ItemAM
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class ItemAM extends Item {

    public ItemAM(int id) {
        super(id - Reference.SHIFTED_ID_RANGE_CORRECTION);
        this.setMaxStackSize(1);
        this.setNoRepair();
        this.setCreativeTab(Allrondism.tabsAM);

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
        // advanced ToolTips are only shown if in F3 + H mode.
        // This message is overwritten by other Items.
        if(advancedToolTips) {
            infoList.add("You are in a Debug mode!");
            infoList.add("Press F3 + H to disable it");
        }
    }
}
