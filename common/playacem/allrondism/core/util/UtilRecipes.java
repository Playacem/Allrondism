package playacem.allrondism.core.util;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Allrondism
 * 
 * UtilRecipes
 * 
 * provides alternate ways for adding recipes. The idea behind this is a central
 * location for all the recipe needs
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class UtilRecipes {

    public static void addVanillaRecipe(String type, boolean useOreDict, ItemStack output, Object... params) {

        if (type.toUpperCase().contains("SHAPED")) {
            if (useOreDict) {
                GameRegistry.addRecipe(new ShapedOreRecipe(output, params));
            }
            else {
                GameRegistry.addShapedRecipe(output, params);
            }
        } else if (type.toUpperCase().contains("SHAPELESS")) {
            if (useOreDict) {
                GameRegistry.addRecipe(new ShapelessOreRecipe(output, params));
            }
            else {
                GameRegistry.addShapelessRecipe(output, params);
            }
        } else {
            StringBuilder sB = new StringBuilder();
            sB.append(String.format("The crafting recipe for %s (%s) was not properly registered.", output.toString(), output.getDisplayName()));
            LogHelper.alert(sB.toString());
        }
    }

    /**
     * Adds a vanilla crafting recipe, supports OreDictionary
     * 
     * @param type
     *            - Shaped or Shapeless
     * @param output
     * @param params
     */
    public static void addVanillaRecipe(String type, ItemStack output, Object... params) {

        addVanillaRecipe(type, true, output, params);
    }

    public static void addVanillaSmelting(int inputID, ItemStack output, float xp) {

        addVanillaSmelting(inputID, 0, output, xp);
    }

    /**
     * Adds a Vanilla Smelting recipe Metadata compatible
     * 
     */
    public static void addVanillaSmelting(int id, int metadata, ItemStack output, float xp) {

        FurnaceRecipes.smelting().addSmelting(id, metadata, output, xp);
    }

    /**
     * Adds a 3x3 crafting recipe for the specified block and the matching
     * uncrafting recipe
     * 
     * @param storageBlock
     *            - result
     * @param component
     *            - a String or an ItemStack
     */
    public static void addStorageRecipe(ItemStack storageBlock, Object component) {

        if (!(component instanceof String || component instanceof ItemStack)) {
            StringBuilder sB = new StringBuilder();
            sB.append(String.format("Component is not valid! Block: %s Component: %s", storageBlock.getDisplayName(), component.toString()));
            LogHelper.alert(sB.toString());
            LogHelper.alert("The Recipe was not added.");
            return;
        }
        UtilRecipes.addVanillaRecipe("Shaped", storageBlock, "xxx", "xxx", "xxx",
                Character.valueOf('x'), component);

        ItemStack componentStack = null;
        if (component instanceof ItemStack) {
            componentStack = (ItemStack) component;
            componentStack.stackSize = 9;
        } else {
            componentStack = UtilOreDict.instance().getItemStack(component, 9);
        }

        UtilRecipes.addVanillaRecipe("Shapeless", componentStack, storageBlock);
    }

    public static boolean addDoubleRecipe(String oreDictObj, Object usedMat, int amount, Object centerObj) {

        ArrayList<ItemStack> results = UtilOreDict.instance().getItemStackArray(oreDictObj, 2);

        if (results != null) {

            if (!isValidObj(oreDictObj)) {
                LogHelper.alert("The given Object is not valid. OreDictObject: " + oreDictObj);
                return false;
            }
            if (!isValidObj(centerObj)) {
                LogHelper.alert("The given Object is not valid. CenterObject: " + oreDictObj);
                return false;
            }

            switch (amount) {
                case 1:
                    for (int i = 0; i < results.size(); i++) {
                        UtilRecipes.addVanillaRecipe("Shaped", results.get(i), new Object[] { "   ", "XCM", "   ",
                                Character.valueOf('X'), usedMat, Character.valueOf('C'), centerObj,
                                Character.valueOf('M'), results.get(i) });
                    }
                    ;
                    break;
                case 2:
                    for (int i = 0; i < results.size(); i++) {
                        UtilRecipes.addVanillaRecipe("Shaped", results.get(i), new Object[] { " X ", " CM", " X ",
                                Character.valueOf('X'), usedMat, Character.valueOf('C'), centerObj,
                                Character.valueOf('M'), results.get(i) });
                    }
                    ;
                    break;
                case 3:
                    for (int i = 0; i < results.size(); i++) {
                        UtilRecipes.addVanillaRecipe("Shaped", results.get(i), new Object[] { " X ", "XCM", " X ",
                                Character.valueOf('X'), usedMat, Character.valueOf('C'), centerObj,
                                Character.valueOf('M'), results.get(i) });
                    }
                    ;
                    break;
                case 4:
                    for (int i = 0; i < results.size(); i++) {
                        UtilRecipes.addVanillaRecipe("Shaped", results.get(i), new Object[] { "XX ", " CM", "XX ",
                                Character.valueOf('X'), usedMat, Character.valueOf('C'), centerObj,
                                Character.valueOf('M'), results.get(i) });
                    }
                    ;
                    break;
                case 5:
                    for (int i = 0; i < results.size(); i++) {
                        UtilRecipes.addVanillaRecipe("Shaped", results.get(i), new Object[] { "XX ", "XCM", "XX ",
                                Character.valueOf('X'), usedMat, Character.valueOf('C'), centerObj,
                                Character.valueOf('M'), results.get(i) });
                    }
                case 6:
                    for (int i = 0; i < results.size(); i++) {
                        UtilRecipes.addVanillaRecipe("Shaped", results.get(i), new Object[] { "XXX", " CM", "XXX",
                                Character.valueOf('X'), usedMat, Character.valueOf('C'), centerObj,
                                Character.valueOf('M'), results.get(i) });
                    }
                    ;
                    break;
                case 7:
                    for (int i = 0; i < results.size(); i++) {
                        UtilRecipes.addVanillaRecipe("Shaped", results.get(i), new Object[] { "XXX", "XCM", "XXX",
                                Character.valueOf('X'), usedMat, Character.valueOf('C'), centerObj,
                                Character.valueOf('M'), results.get(i) });
                    }
                    ;
                    break;
                default:
                    break;
            }
        } else {
            LogHelper.info(getError(oreDictObj));
            return false;
        }

        return true;
    }

    public static boolean addDoubleMetalRecipe(String metal, Object usedMat, int amount) {

        return addDoubleRecipe("ingot" + metal, usedMat, amount, "oreIron");
    }

    private static String getError(String oreDictObj) {

        StringBuilder sB = new StringBuilder();
        sB.append(String.format("Cannot find \"%s\" in the OreDictionary! Cannot add %s \"Doubling Recipes\"", oreDictObj, oreDictObj));
        return sB.toString();
    }

    private static boolean isValidObj(Object obj) {

        if (obj instanceof Block) return true;
        if (obj instanceof Item) return true;
        if (obj instanceof String) return true;
        if (obj instanceof ItemStack) return true;
        return false;
    }
}
