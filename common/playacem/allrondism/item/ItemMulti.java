package playacem.allrondism.item;

import java.util.List;

import playacem.allrondism.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

/**
 * Allrondism
 * 
 * ItemMulti
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit powercrystals
 */
public class ItemMulti extends ItemAM {

    protected String[] names;
    private Icon[] icons;
    
    public ItemMulti(int id) {
        super(id);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    protected void setNames(String... strings) {
        names = strings;
        icons = new Icon[names.length];
        setMetaMax(names.length);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIconFromDamage(int damage) {
        return icons[Math.min(damage, icons.length - 1)];
    }
    
    @Override
    public int getMetadata(int meta) {
        return meta;
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) 
                + names[Math.min(stack.getItemDamage(), names.length - 1)];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister ir) {
        for(int i = 0; i < icons.length; i++) {
            icons[i] = ir.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName()
                    .substring(this.getUnlocalizedName().indexOf(".") + 1) + names[i]);
        }
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubItems(int itemId, CreativeTabs creativeTab, List subTypes) {
        for(int i = 0; i < names.length; i++) {
            subTypes.add(new ItemStack(itemId, 1, i));
        }
    }
}
