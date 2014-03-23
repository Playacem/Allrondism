package playacem.allrondism.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;


public abstract class ItemToolAM extends ItemAM {

    public ItemToolAM(int id) {
        super(id);
    }
    
    @Override
    public float getStrVsBlock(ItemStack stack, Block block, int meta) {
        return super.getStrVsBlock(stack, block, meta);
    }

}
