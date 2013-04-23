package de.playacem.allrondism.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.playacem.allrondism.lib.ItemIDs;

/**
 * Allrondism-Mod
 * 
 * CreativeTabAM
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
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
}
