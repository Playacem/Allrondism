package de.playacem.allrondism.item;

import de.playacem.allrondism.AllrondismMod;
import de.playacem.allrondism.lib.Strings;

public class ItemAllrondiumGem extends ItemAM {

	public ItemAllrondiumGem(int id) {
		
		super(id);
		this.setUnlocalizedName(Strings.ALLRONDIUM_GEM);
		this.setCreativeTab(AllrondismMod.tabsAM);
		setMaxStackSize(64);
		setIconIndex(0);
	}

	
}
