package playacem.allrondism.item;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
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

    public static void init() {

        /* Initialize each mod item individually */
        gemAllrondium = new ItemGemAllrondium(ItemIDs.GEM_ALLRONDIUM);
        appleGoldZombie = new ItemAppleGoldZombie(ItemIDs.APPLE_GOLD_ZOMBIE);

        GameRegistry.registerItem(gemAllrondium, Strings.GEM_ALLRONDIUM_NAME);
        GameRegistry.registerItem(appleGoldZombie, Strings.APPLE_GOLD_ZOMBIE_NAME);

        LanguageRegistry.addName(gemAllrondium, "Allrondium");
        LanguageRegistry.addName(appleGoldZombie, "Golden Apple");
        
        initOreDictItems();
        initItemRecipes();
    }

    private static void initOreDictItems() {
        OreDictionary.registerOre("ingotGold", Item.ingotGold);
        
        //OreDictionary.registerOre("seedsAll", Item.seeds);
        OreDictionary.registerOre("seedsAll", Item.melonSeeds);
        OreDictionary.registerOre("seedsAll", Item.pumpkinSeeds);
        OreDictionary.registerOre("seedsAll", Item.carrot);
        OreDictionary.registerOre("seedsAll", Item.potato);
    }
    
    private static void initItemRecipes() {
        // temporary Recipe, will use gold nuggets in 1.6
        UtilRecipes.addVanillaRecipe("Shaped", new ItemStack(ModItems.appleGoldZombie, 16), new Object[] {
                "III", "IAI", "III", Character.valueOf('I'), Item.ingotGold, Character.valueOf('A'), Item.appleRed });

        // Vanilla Blocks uncrafting recipes
        UtilRecipes.addVanillaRecipe("Shapeless", new ItemStack(Item.snowball, 4), new Object[] { Block.blockSnow });
        UtilRecipes.addVanillaRecipe("Shapeless", new ItemStack(Item.brick, 4), new Object[] { Block.brick });
        UtilRecipes.addVanillaRecipe("Shapeless", new ItemStack(Item.netherrackBrick, 4), new Object[] { Block.netherBrick });
    }
    
    public static void postInit() {
        // TODO Add more doubling recipes
        
        // Copper
        add2MetalRecipe("Copper", Item.appleRed, 3);
        // Gold
        add2MetalRecipe("Gold", Block.sandStone, 5);
        // Lead
        add2MetalRecipe("Lead", Block.chest , 2);
        // Silver
        add2MetalRecipe("Silver", Item.egg, 2);
        add2MetalRecipe("Silver", "seedsAll" , 7);
        // Tin
        add2MetalRecipe("Tin", Block.thinGlass, 3);
        
        
    }
    
    private static void add2MetalRecipe(String metal, Object usedMat, int amount) {
        ArrayList<ItemStack> ingots = UtilOreDict.instance().getItemStackArray("ingot"+ metal, 2);
        boolean isValidObj = false;
        if(ingots != null) {
            if(usedMat instanceof Block){ isValidObj = true; }
            if(usedMat instanceof Item) { isValidObj = true; }
            if(usedMat instanceof String) { isValidObj = true; }
            if(usedMat instanceof ItemStack) { isValidObj = true; }
            if(isValidObj == false) { LogHelper.alert("The given Object is not valid. Metal: " + metal); return;  }
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
        }else { LogHelper.info(getError(metal)); }
    }
    
    private static String getError(String metal) {
        StringBuilder sB = new StringBuilder();
        sB.append(String.format("Cannot find \"ingot%s\" in the OreDictionary! Cannot add %s \"Doubling Recipes\"", metal, metal));
        return sB.toString();
    }
}
