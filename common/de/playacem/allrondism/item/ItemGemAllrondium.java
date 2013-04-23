package de.playacem.allrondism.item;

import de.playacem.allrondism.AllrondismMod;
import de.playacem.allrondism.lib.Strings;

public class ItemGemAllrondium extends ItemAM {

    public ItemGemAllrondium(int id) {

        super(id);
        this.setUnlocalizedName(Strings.GEM_ALLRONDIUM);
        this.setCreativeTab(AllrondismMod.tabsAM);
        setMaxStackSize(64);
    }

}
