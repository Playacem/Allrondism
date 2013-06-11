package playacem.allrondism.block;

import playacem.allrondism.item.ModItems;
import playacem.allrondism.lib.BlockIDs;
import playacem.allrondism.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Allrondism
 * 
 * ModBlocks
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit pahimar
 */
public class ModBlocks {

    /* Mod block instances */
    public static Block oreAllrondium;
    public static Block storageDirt;
    public static Block storageCobble;
    public static Block storageAllrondium;

    public static void init() {

        oreAllrondium = new BlockOreAllrondium(BlockIDs.ORE_ALLRONDIUM);
        storageDirt = new BlockStorageDirt(BlockIDs.STORAGE_DIRT);
        storageCobble = new BlockStorageCobble(BlockIDs.STORAGE_COBBLE);
        storageAllrondium = new BlockStorageAllrondium(BlockIDs.STORAGE_ALLRONDIUM);

        GameRegistry.registerBlock(oreAllrondium, Strings.ORE_ALLRONDIUM_NAME);
        GameRegistry.registerBlock(storageDirt, Strings.STORAGE_DIRT_NAME);
        GameRegistry.registerBlock(storageCobble, Strings.STORAGE_COBBLE_NAME);
        GameRegistry.registerBlock(storageAllrondium,Strings.STORAGE_ALLRONDIUM_NAME);

        LanguageRegistry.addName(oreAllrondium, "Allrondium Ore");
        LanguageRegistry.addName(storageDirt, "Storage Dirt");
        LanguageRegistry.addName(storageCobble, "Storage Cobble");
        LanguageRegistry.addName(storageAllrondium, "Storage Allrondium");
        
        setupBlockHarvestLevel();
        initBlockRecipes();
    }

    private static void setupBlockHarvestLevel(){
        //0 == wood, 1 == stone, 2 == iron, 3 == diamond
        MinecraftForge.setBlockHarvestLevel(oreAllrondium, "pickaxe", 3);
    }
    private static void initBlockRecipes() {

        // AllrondiumOre recipe (maybe temporary; WorldGen being optional?)
        GameRegistry.addRecipe(new ItemStack(oreAllrondium), 
                new Object[] {"ddd", "dsd", "ddd", 
            Character.valueOf('d'),Block.blockDiamond, 
            Character.valueOf('s'), Block.stone });

        // StorageBlock recipes
        addStorageRecipe(new ItemStack(storageDirt), new ItemStack(Block.dirt));
        addStorageRecipe(new ItemStack(storageCobble), new ItemStack(Block.cobblestone));
        addStorageRecipe(new ItemStack(storageAllrondium), new ItemStack(ModItems.gemAllrondium));

        // Smelting recipes
        GameRegistry.addSmelting(BlockIDs.ORE_ALLRONDIUM, new ItemStack(ModItems.gemAllrondium, 3), 15.0F);
    }

    private static void addStorageRecipe(ItemStack storageBlock,ItemStack component) {
        // addRecipe(output , firstLine, secondLine, thirdLine, [variable,
        // ItemStack] (more possible))
        GameRegistry.addRecipe(storageBlock, "xxx", "xxx", "xxx",Character.valueOf('x'), component);
        // Shape is not necessary
        ItemStack componentStack = new ItemStack(component.itemID, 9, 0);
        GameRegistry.addShapelessRecipe(componentStack, storageBlock);
    }
}
