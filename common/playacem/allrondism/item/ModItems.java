package playacem.allrondism.item;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
        

        initItemRecipes();
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
        ArrayList<ItemStack> ingots = UtilOreDict.instance().getItemStackArray("ingotCopper", 2);
        if(!(ingots == null)) {
            for(int i = 0; i < ingots.size(); i++) {
                UtilRecipes.addVanillaRecipe("Shaped", ingots.get(i), new Object[] {" A ", "AOC", " A ",
                    Character.valueOf('A'), Item.appleRed, Character.valueOf('O'), "oreIron", 
                    Character.valueOf('C'), ingots.get(i)});
            }   
        }else { LogHelper.debug("No Copper found! Cannot add Copper Doubling Recipes."); }
        
    }
}
