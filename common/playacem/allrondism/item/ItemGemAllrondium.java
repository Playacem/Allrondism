package playacem.allrondism.item;

import playacem.allrondism.AllrondismMod;
import playacem.allrondism.lib.Strings;

public class ItemGemAllrondium extends ItemAM {

    public ItemGemAllrondium(int id) {

        super(id);
        this.setUnlocalizedName(Strings.GEM_ALLRONDIUM);
        this.setCreativeTab(AllrondismMod.tabsAM);
        setMaxStackSize(64);
    }

}
