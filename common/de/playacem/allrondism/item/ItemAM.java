package de.playacem.allrondism.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import de.playacem.allrondism.lib.Reference;

public class ItemAM extends Item {

    public ItemAM(int id) {
        super(id - Reference.SHIFTED_ID_RANGE_CORRECTION);
        maxStackSize = 1;
        setNoRepair();

    }

    public void updateIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
                + ":"
                + this.getUnlocalizedName().substring(
                        this.getUnlocalizedName().indexOf(".") + 1));
    }
}
