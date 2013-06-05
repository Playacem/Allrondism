package playacem.allrondism.creativetab;

import playacem.allrondism.lib.ItemIDs;
import playacem.allrondism.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


/**
 * Allrondism
 * 
 * CreativeTabAM
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit pahimar
 */
public class CreativeTabAM extends CreativeTabs {

    public CreativeTabAM(int par1, String par2Str) {

        super(par1, par2Str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex() {

        return ItemIDs.GEM_ALLRONDIUM;
    }
    
    @Override
    public String getTranslatedTabLabel() {
        
        return Reference.MOD_NAME;// the ingame name for the Tab
    }
}
