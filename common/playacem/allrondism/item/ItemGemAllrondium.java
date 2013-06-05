package playacem.allrondism.item;

import playacem.allrondism.AllrondismMod;
import playacem.allrondism.lib.Strings;

/**
* Allrondism
* 
* ItemGemAllrondium
* 
* @author Playacem
* @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
*/
public class ItemGemAllrondium extends ItemAM {


    public ItemGemAllrondium(int id) {

        super(id);
        this.setUnlocalizedName(Strings.GEM_ALLRONDIUM);
        this.setCreativeTab(AllrondismMod.tabsAM);
        setMaxStackSize(64);
    }

}
