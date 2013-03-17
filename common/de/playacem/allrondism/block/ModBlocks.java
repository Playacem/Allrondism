package de.playacem.allrondism.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import de.playacem.allrondism.item.ModItems;
import de.playacem.allrondism.lib.BlockIDs;
import de.playacem.allrondism.lib.Strings;
/**
 * ModBlocks
 * @author Playacem
 *
 */
public class ModBlocks {

	/* Mod block instances */
	public static Block allrondiumOre;
	public static Block storageDirt;
	public static Block storageCobble;
	public static Block storageAllrondium;
	
	public static void init() {
		
		allrondiumOre = new BlockOreAllrondium(BlockIDs.ORE_ALLRONDIUM);
		storageDirt = new BlockStorageDirt(BlockIDs.STORAGE_DIRT);
		storageCobble = new BlockStorageCobble(BlockIDs.STORAGE_COBBLE);
		storageAllrondium = new BlockStorageAllrondium(BlockIDs.STORAGE_ALLRONDIUM);
		
		GameRegistry.registerBlock(allrondiumOre, Strings.ORE_ALLRONDIUM_NAME);
		GameRegistry.registerBlock(storageDirt, Strings.STORAGE_DIRT_NAME);
		GameRegistry.registerBlock(storageCobble, Strings.STORAGE_COBBLE_NAME);
		GameRegistry.registerBlock(storageAllrondium, Strings.STORAGE_ALLRONDIUM_NAME);
		
		LanguageRegistry.addName(allrondiumOre, "Allrondium Ore");
		LanguageRegistry.addName(storageDirt, "Storage Dirt");
		LanguageRegistry.addName(storageCobble, "Storage Cobble");
		LanguageRegistry.addName(storageAllrondium, "Storage Allrondium");
		
		initBlockRecipes();
	}
	
	private static void initBlockRecipes(){
		
		// AllrondiumOre recipe (maybe temporary; WorldGen being optional?)
		GameRegistry.addRecipe(new ItemStack(allrondiumOre), new Object[] {
			"ddd","dsd","ddd", Character.valueOf('d'), Block.blockDiamond,
			 Character.valueOf('s'), Block.stone });
		
		// StorageBlock recipes
		addStorageRecipe(new ItemStack(storageDirt), new ItemStack(Block.dirt));
		addStorageRecipe(new ItemStack(storageCobble), new ItemStack(Block.cobblestone));
		addStorageRecipe(new ItemStack(storageAllrondium), new ItemStack(ModItems.allrondiumGem));
		
		// Smelting recipes
		GameRegistry.addSmelting(BlockIDs.ORE_ALLRONDIUM, new ItemStack(ModItems.allrondiumGem, 3), 15.0F);
	}
	
	private static void addStorageRecipe(ItemStack storageBlock, ItemStack component) {
		// addRecipe(output , firstLine, secondLine, thirdLine, [variable, ItemStack] (more possible))
		GameRegistry.addRecipe(storageBlock, "xxx", "xxx", "xxx",
		Character.valueOf('x'), component);
		// Shape is not necessary
		ItemStack componentStack = new ItemStack(component.itemID, 9, 0);
		GameRegistry.addShapelessRecipe(componentStack, storageBlock);
		}
}


