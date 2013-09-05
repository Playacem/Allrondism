package playacem.allrondism.block;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import playacem.allrondism.lib.Strings;

public class ItemBlockMultiFurnaceExtension extends ItemBlockExtended {

    public ItemBlockMultiFurnaceExtension(int id) {
        super(id);
        setMaxDamage(0);
        setHasSubtypes(true);
        setNames(Strings.MULTI_FURNACE_EXTENSIONS);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubItems(int itemId, CreativeTabs creativeTab, List subTypes) {
        for (int i = 1; i < names.length; i++) { // disables dummy block in the CreativeTab
            subTypes.add(new ItemStack(itemId, 1, i));
        }
    }
}
