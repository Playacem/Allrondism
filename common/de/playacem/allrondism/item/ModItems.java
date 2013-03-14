package de.playacem.allrondism.item;

//import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;

import de.playacem.allrondism.lib.ItemIDs;
import de.playacem.allrondism.lib.Strings;

//import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Allrondism-Mod
 * 
 * ModItems
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class ModItems {

	/* Mod item instances*/
	public static Item allrondiumGem;
	
	public static void init(){
		
		/* Initialize each mod item individually */
		allrondiumGem = new ItemAllrondiumGem(ItemIDs.ALLRONDIUM_GEM);
		
		GameRegistry.registerItem(allrondiumGem, Strings.ALLRONDIUM_GEM);
		LanguageRegistry.addName(allrondiumGem, "Allrondium");
	}
	
}
