package playacem.allrondism.item;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import playacem.allrondism.block.ModBlocks;
import playacem.allrondism.core.util.LogHelper;
import playacem.allrondism.core.util.UtilOreDict;
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
        for(int i = 0; i < Strings.ROSES.length; i++) {
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
        
        //OreDictionary.registerOre("seedsAll", Item.seeds);
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
        addDoubleMetalRecipe("Copper", Item.appleRed, 3);
        // Gold
        addDoubleMetalRecipe("Gold", Block.sandStone, 5);
        // Lead
        addDoubleMetalRecipe("Lead", Block.chest , 2);
        // Silver
        if(addDoubleMetalRecipe("Silver", Item.egg, 2)) {
           addDoubleMetalRecipe("Silver", "seedsAll" , 7); 
        }
        // Tin
        addDoubleMetalRecipe("Tin", Block.thinGlass, 3);
        // Steel
        addDoubleMetalRecipe("Steel", new ItemStack(Item.coal, 1, 0), 7);
        
    }
    
    private static boolean addDoubleMetalRecipe(String metal, Object usedMat, int amount) {
        ArrayList<ItemStack> ingots = UtilOreDict.instance().getItemStackArray("ingot" + metal, 2);
        boolean isValidObj = false;
        
        if(ingots != null) {
            
            if(usedMat instanceof Block){ isValidObj = true; }
            if(usedMat instanceof Item) { isValidObj = true; }
            if(usedMat instanceof String) { isValidObj = true; }
            if(usedMat instanceof ItemStack) { isValidObj = true; }
            if(isValidObj == false) { LogHelper.alert("The given Object is not valid. Metal: " + metal); return false; }
            
            switch(amount) {
                case 1:
                    for(int i = 0; i < ingots.size(); i++) {
                        UtilRecipes.addVanillaRecipe("Shaped", ingots.get(i), new Object[] { "   ", "XOM", "   ",
                            Character.valueOf('X'), usedMat, Character.valueOf('O'), "oreIron", 
                            Character.valueOf('M'), ingots.get(i)});
                    }; break;
                case 2:
                    for(int i = 0; i < ingots.size(); i++) {
                        UtilRecipes.addVanillaRecipe("Shaped", ingots.get(i), new Object[] { " X ", " OM", " X ",
                            Character.valueOf('X'), usedMat, Character.valueOf('O'), "oreIron", 
                            Character.valueOf('M'), ingots.get(i)});
                    }; break;
                case 3:
                    for(int i = 0; i < ingots.size(); i++) {
                        UtilRecipes.addVanillaRecipe("Shaped", ingots.get(i), new Object[] { " X ", "XOM", " X ",
                            Character.valueOf('X'), usedMat, Character.valueOf('O'), "oreIron", 
                            Character.valueOf('M'), ingots.get(i)});
                    }; break;
                case 4:
                    for(int i = 0; i < ingots.size(); i++) {
                        UtilRecipes.addVanillaRecipe("Shaped", ingots.get(i), new Object[] { "XX ", " OM", "XX ",
                            Character.valueOf('X'), usedMat, Character.valueOf('O'), "oreIron", 
                            Character.valueOf('M'), ingots.get(i)});
                    }; break;
                case 5:
                    for(int i = 0; i < ingots.size(); i++) {
                        UtilRecipes.addVanillaRecipe("Shaped", ingots.get(i), new Object[] { "XX ", "XOM", "XX ",
                            Character.valueOf('X'), usedMat, Character.valueOf('O'), "oreIron", 
                            Character.valueOf('M'), ingots.get(i)});
                    }
                case 6:
                    for(int i = 0; i < ingots.size(); i++) {
                        UtilRecipes.addVanillaRecipe("Shaped", ingots.get(i), new Object[] { "XXX", " OM", "XXX",
                            Character.valueOf('X'), usedMat, Character.valueOf('O'), "oreIron", 
                            Character.valueOf('M'), ingots.get(i)});
                    }; break;
                case 7:
                    for(int i = 0; i < ingots.size(); i++) {
                        UtilRecipes.addVanillaRecipe("Shaped", ingots.get(i), new Object[] { "XXX", "XOM", "XXX",
                            Character.valueOf('X'), usedMat, Character.valueOf('O'), "oreIron", 
                            Character.valueOf('M'), ingots.get(i)});
                    }; break;
                default: break;
            }
        }else { LogHelper.info(getError(metal)); return false; }
        
        return true;
    }
    
    private static String getError(String metal) {
        StringBuilder sB = new StringBuilder();
        sB.append(String.format("Cannot find \"ingot%s\" in the OreDictionary! Cannot add %s \"Doubling Recipes\"", metal, metal));
        return sB.toString();
    }
}
