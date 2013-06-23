package playacem.allrondism.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import playacem.allrondism.core.util.UtilRecipes;
import playacem.allrondism.item.ModItems;
import playacem.allrondism.lib.BlockIDs;
import playacem.allrondism.lib.Strings;
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
    public static Block storageBlock;
    public static Block glassSunBlocker;

    public static void init() {

        oreAllrondium = new BlockOreAllrondium(BlockIDs.ORE_ALLRONDIUM);
        storageBlock = new BlockStorageBlock(BlockIDs.STORAGE_BLOCKS);
        glassSunBlocker = new BlockGlassSunBlocker(BlockIDs.GLASS_SUN_BLOCKER);

        GameRegistry.registerBlock(oreAllrondium, Strings.ORE_ALLRONDIUM_NAME);
        GameRegistry.registerBlock(storageBlock, ItemBlockStorageBlock.class, storageBlock.getUnlocalizedName());
        GameRegistry.registerBlock(glassSunBlocker, Strings.GLASS_SUN_BLOCKER_NAME);

        LanguageRegistry.addName(oreAllrondium, "Allrondium Ore");
        for (int i = 0; i < Strings.STORAGE_BLOCKS.length; i++) {
            ItemStack storageBlockStack = new ItemStack(storageBlock, 1, i);
            LanguageRegistry.addName(storageBlockStack, "Storage " + Strings.STORAGE_BLOCKS[storageBlockStack.getItemDamage()]);
        }
        LanguageRegistry.addName(glassSunBlocker, "Sunblocking Glass");
        
        setupBlockHarvestLevel();
        initBlockRecipes();
    }

    private static void setupBlockHarvestLevel() {
        // 0 == wood, 1 == stone, 2 == iron, 3 == diamond
        MinecraftForge.setBlockHarvestLevel(oreAllrondium, "pickaxe", 3);
        MinecraftForge.setBlockHarvestLevel(glassSunBlocker, "pickaxe", 1);
    }

    private static void initBlockRecipes() {

        // AllrondiumOre recipe (maybe temporary; WorldGen being optional?)
        UtilRecipes.addVanillaRecipe("Shaped", new ItemStack(oreAllrondium), new Object[] { "ddd", "dsd", "ddd",
                Character.valueOf('d'), Block.blockDiamond, Character.valueOf('s'), Block.stone });

        // Storage Block Recipes
        UtilRecipes.addStorageRecipe(new ItemStack(storageBlock, 1, 0), new ItemStack(Block.dirt));
        UtilRecipes.addStorageRecipe(new ItemStack(storageBlock, 1, 1), new ItemStack(Block.cobblestone));
        UtilRecipes.addStorageRecipe(new ItemStack(storageBlock, 1, 2), new ItemStack(ModItems.gemAllrondium));
        
        // Recipe Sunblocking Glass
        UtilRecipes.addVanillaRecipe("Shaped", new ItemStack(glassSunBlocker, 4), new Object[] { "dgd", "gig", "dgd",
                Character.valueOf('d'), new ItemStack(Item.dyePowder, 1, 0), Character.valueOf('g'), Block.glass, Character.valueOf('i'), Item.ingotIron});
        
        // Smelting recipes
        UtilRecipes.addVanillaSmelting(BlockIDs.ORE_ALLRONDIUM, new ItemStack(ModItems.gemAllrondium, 3), 15.0F);
    }

}
