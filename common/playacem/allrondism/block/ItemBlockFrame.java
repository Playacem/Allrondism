package playacem.allrondism.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Allrondism
 * 
 * ItemBlockFrame
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit powercrystals
 */
public class ItemBlockFrame extends ItemBlock {

    protected String[] _names;
    
    public ItemBlockFrame(int id) {
        super(id);
    }

    protected void setNames(String[] names) {
        _names = names;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIconFromDamage(int damage) {
        return Block.blocksList[getBlockID()].getIcon(2, damage);
    }
    
    @Override
    public int getMetadata(int meta) {
        return meta;
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return getUnlocalizedName() + "." + _names[Math.min(stack.getItemDamage(), _names.length - 1)];
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubItems(int itemId, CreativeTabs creativeTab, List subTypes)
    {
        for(int i = 0; i < _names.length; i++)
        {
            subTypes.add(new ItemStack(itemId, 1, i));
        }
    }
}