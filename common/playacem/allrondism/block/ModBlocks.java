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
    public static Block plantRose;
    public static Block multiFurnaceCore;
    public static Block multiFurnaceExtension;

    public static void init() {

        oreAllrondium = new BlockOreAllrondium(BlockIDs.ORE_ALLRONDIUM);
        storageBlock = new BlockStorageBlock(BlockIDs.STORAGE_BLOCKS);
        glassSunBlocker = new BlockGlassSunBlocker(BlockIDs.GLASS_SUN_BLOCKER);
        plantRose = new BlockPlantRose(BlockIDs.PLANT_ROSE);
        multiFurnaceCore = new BlockMultiFurnaceCore(BlockIDs.MULTI_FURNACE_CORE);
        multiFurnaceExtension = new BlockMultiFurnaceExtension(BlockIDs.MULTI_FURNACE_EXTENSION);

        GameRegistry.registerBlock(oreAllrondium, ItemBlockBasic.class, Strings.ORE_ALLRONDIUM_NAME);
        GameRegistry.registerBlock(storageBlock, ItemBlockStorageBlock.class, storageBlock.getUnlocalizedName());
        GameRegistry.registerBlock(glassSunBlocker, ItemBlockBasic.class, Strings.GLASS_SUN_BLOCKER_NAME);
        GameRegistry.registerBlock(plantRose, ItemBlockPlantRose.class, plantRose.getUnlocalizedName());
        GameRegistry.registerBlock(multiFurnaceCore, ItemBlockBasic.class, Strings.MULTI_FURNACE_CORE_NAME);
        GameRegistry.registerBlock(multiFurnaceExtension, ItemBlockMultiFurnaceExtension.class, multiFurnaceExtension.getUnlocalizedName());

        LanguageRegistry.addName(oreAllrondium, "Allrondium Ore");

        for (int i = 0; i < Strings.STORAGE_BLOCKS.length; i++) {
            ItemStack storageBlockStack = new ItemStack(storageBlock, 1, i);
            LanguageRegistry.addName(storageBlockStack, "Storage " + Strings.STORAGE_BLOCKS[i]);
        }

        LanguageRegistry.addName(glassSunBlocker, "Sunblocking Glass");

        for (int i = 0; i < Strings.ROSES.length; i++) {
            ItemStack plantRoseStack = new ItemStack(plantRose, 1, i);
            LanguageRegistry.addName(plantRoseStack, Strings.ROSES[i] + " Rose");
        }

        LanguageRegistry.addName(multiFurnaceCore, "Multi-Furnace Core");

        setupBlockHarvestLevels();
        setupGrassEntries();
    }

    private static void setupBlockHarvestLevels() {

        // 0 == wood, 1 == stone, 2 == iron, 3 == diamond
        MinecraftForge.setBlockHarvestLevel(oreAllrondium, "pickaxe", 3);
        MinecraftForge.setBlockHarvestLevel(storageBlock, "pickaxe", 0);
        MinecraftForge.setBlockHarvestLevel(storageBlock, "shovel", 0);
        MinecraftForge.setBlockHarvestLevel(glassSunBlocker, "pickaxe", 0);
    }

    private static void setupGrassEntries() {

        // weight of plants:
        // red: 10, yellow: 20
        MinecraftForge.addGrassPlant(plantRose, 0, 10);
        MinecraftForge.addGrassPlant(plantRose, 1, 10);
    }

    public static void initBlockRecipes() {

        // AllrondiumOre recipe (maybe temporary; WorldGen being optional?)
        UtilRecipes.addVanillaRecipe("Shaped", new ItemStack(oreAllrondium), new Object[] { "bdw", "dsd", "wdb",
                Character.valueOf('d'), Block.blockDiamond, Character.valueOf('s'), Block.stone,
                Character.valueOf('b'), "dyeBlack", Character.valueOf('w'), "dyeWhite" });
        UtilRecipes.addVanillaRecipe("Shaped", new ItemStack(oreAllrondium), new Object[] { "wdb", "dsd", "bdw",
                Character.valueOf('d'), Block.blockDiamond, Character.valueOf('s'), Block.stone,
                Character.valueOf('b'), "dyeBlack", Character.valueOf('w'), "dyeWhite" });

        // Storage Block Recipes
        UtilRecipes.addStorageRecipe(new ItemStack(storageBlock, 1, 0), new ItemStack(Block.dirt));
        UtilRecipes.addStorageRecipe(new ItemStack(storageBlock, 1, 1), new ItemStack(Block.cobblestone));
        UtilRecipes.addStorageRecipe(new ItemStack(storageBlock, 1, 2), new ItemStack(ModItems.gemAllrondium));

        // Recipe Sunblocking Glass
        UtilRecipes.addVanillaRecipe("Shaped", new ItemStack(glassSunBlocker, 4), new Object[] { "dgd", "gig", "dgd",
                Character.valueOf('d'), "dyeBlack", Character.valueOf('g'), Block.glass, Character.valueOf('i'), Item.ingotIron });

        // Smelting recipes
        UtilRecipes.addVanillaSmelting(oreAllrondium.blockID, new ItemStack(ModItems.gemAllrondium, 3), 15.0F);
    }

}
