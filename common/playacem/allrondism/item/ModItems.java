package playacem.allrondism.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import playacem.allrondism.block.ModBlocks;
import playacem.allrondism.configuration.Settings;
import playacem.allrondism.core.util.UtilRecipes;
import playacem.allrondism.lib.ItemIDs;
import playacem.allrondism.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Allrondism
 * 
 * ModItems
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit pahimar
 */
public class ModItems {

    /* Mod item instances */
    public static Item gemAllrondium;
    public static Item appleGoldZombie;
    public static Item dyeRose;

    public static void init() {

        /* Initialize each mod item individually */
        gemAllrondium = new ItemGemAllrondium(ItemIDs.GEM_ALLRONDIUM);
        appleGoldZombie = new ItemAppleGoldZombie(ItemIDs.APPLE_GOLD_ZOMBIE);
        dyeRose = new ItemDyeRose(ItemIDs.DYE_ROSE);

        GameRegistry.registerItem(gemAllrondium, Strings.GEM_ALLRONDIUM_NAME);
        GameRegistry.registerItem(appleGoldZombie, Strings.APPLE_GOLD_ZOMBIE_NAME);
        GameRegistry.registerItem(dyeRose, Strings.DYE_ROSE_NAME);

        LanguageRegistry.addName(gemAllrondium, "Allrondium");
        LanguageRegistry.addName(appleGoldZombie, "Golden Apple");
        for (int i = 0; i < Strings.ROSES.length; i++) {
            ItemStack dyeRoseStack = new ItemStack(dyeRose, 1, i);
            LanguageRegistry.addName(dyeRoseStack, Strings.ROSES[i] + " Dye");
        }

        initOreDictItems();
    }

    private static void initOreDictItems() {

        OreDictionary.registerOre("gemAllrondium", gemAllrondium);
        OreDictionary.registerOre("dyeBlack", new ItemStack(dyeRose, 1, 0));
        OreDictionary.registerOre("dyeWhite", new ItemStack(dyeRose, 1, 1));

        /* Stuff for the DoubleMetalRecipes */
        OreDictionary.registerOre("ingotGold", Item.ingotGold);

        // OreDictionary.registerOre("seedsAll", Item.seeds);
        OreDictionary.registerOre("seedsAll", Item.melonSeeds);
        OreDictionary.registerOre("seedsAll", Item.pumpkinSeeds);
        OreDictionary.registerOre("seedsAll", Item.carrot);
        OreDictionary.registerOre("seedsAll", Item.potato);
    }

    public static void initItemRecipes() {

        // temporary Recipe, will use gold nuggets in 1.6
        UtilRecipes.addVanillaRecipe("Shaped", new ItemStack(ModItems.appleGoldZombie, 16), new Object[] {
                "III", "IAI", "III", Character.valueOf('I'), Item.ingotGold, Character.valueOf('A'), Item.appleRed });

        /* Rose --> Dye Recipes */
        UtilRecipes.addVanillaRecipe("Shapeless", new ItemStack(ModItems.dyeRose, 2, 0), new Object[] { new ItemStack(ModBlocks.plantRose, 1, 0) });
        UtilRecipes.addVanillaRecipe("Shapeless", new ItemStack(ModItems.dyeRose, 2, 1), new Object[] { new ItemStack(ModBlocks.plantRose, 1, 1) });

        /* Vanilla Blocks uncrafting recipes */
        UtilRecipes.addVanillaRecipe("Shapeless", new ItemStack(Item.snowball, 4), new Object[] { Block.blockSnow });
        UtilRecipes.addVanillaRecipe("Shapeless", new ItemStack(Item.brick, 4), new Object[] { Block.brick });
        UtilRecipes.addVanillaRecipe("Shapeless", new ItemStack(Item.netherrackBrick, 4), new Object[] { Block.netherBrick });

        /* Item Smelting recipes */

        // Black Rose --> 1 White Dye
        UtilRecipes.addVanillaSmelting(ModBlocks.plantRose.blockID, 0, new ItemStack(ModItems.dyeRose, 1, 1), 0.0F);
        // White Rose --> 1 Black Dye
        UtilRecipes.addVanillaSmelting(ModBlocks.plantRose.blockID, 1, new ItemStack(ModItems.dyeRose, 1, 0), 0.0F);
    }

    public static void postInit() {

        // TODO Add more doubling recipes

        // Copper
        if (Settings.DOUBLING_COPPER) {
            UtilRecipes.addDoubleMetalRecipe("Copper", Item.appleRed, 3);
        }

        // Gold
        if (Settings.DOUBLING_GOLD) {
            UtilRecipes.addDoubleMetalRecipe("Gold", Block.sandStone, 5);
        }

        // Lead
        if (Settings.DOUBLING_LEAD) {
            UtilRecipes.addDoubleMetalRecipe("Lead", Block.chest, 2);
        }

        // Silver
        if (Settings.DOUBLING_SILVER) {
            if (UtilRecipes.addDoubleMetalRecipe("Silver", Item.egg, 2)) {
                UtilRecipes.addDoubleMetalRecipe("Silver", "seedsAll", 7);
            }
        }

        // Tin
        if (Settings.DOUBLING_TIN) {
            UtilRecipes.addDoubleMetalRecipe("Tin", Block.thinGlass, 3);
        }

        // Steel
        if (Settings.DOUBLING_STEEL) {
            UtilRecipes.addDoubleMetalRecipe("Steel", new ItemStack(Item.coal, 1, 0), 7);
        }

        // HSLA
        if (Settings.DOUBLING_HSLA) {
            UtilRecipes.addDoubleRecipe("HSLA", new ItemStack(Item.coal, 1, 0), 7, Item.gunpowder);
        }

    }

}
