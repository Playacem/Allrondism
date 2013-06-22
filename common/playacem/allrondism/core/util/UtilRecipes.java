package playacem.allrondism.core.util;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Allrondism
 * 
 * UtilRecipes
 * 
 * provides alternate ways for adding recipes
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class UtilRecipes {

    /**
     * Adds a vanilla crafing recipe
     * 
     * @param type
     *            - Shaped or Shapeless
     * @param output
     *            - ItemStack
     * @param params
     *            - Object[]
     */
    public static void addVanillaRecipe(String type, ItemStack output, Object... params) {
        for(int i = 0; i < params.length; i++) {
                LogHelper.info("Recipe: "+ output.toString() +" Objectnr. " + i + ": " + params[i].toString());
            }
        if (type.toUpperCase().contains("SHAPED")) {
            GameRegistry.addShapedRecipe(output, params);
            return;
        } else if (type.toUpperCase().contains("SHAPELESS")) {
            GameRegistry.addShapelessRecipe(output, params);
            return;
        } else {
            LogHelper.alert("The crafting recipe for " + output.toString() + " was not properly registered.");
        }
    }

    /**
     * Adds a vanilla smelting recipe
     * 
     * @param input
     *            BlockID
     * @param output
     *            ItemStack
     * @param xp
     */
    public static void addVanillaSmelting(int input, ItemStack output, float xp) {
        GameRegistry.addSmelting(input, output, xp);
    }

    /**
     * Metadata sensitive version
     * 
     */
    public static void addVanillaSmelting(int id, int metadata, ItemStack output, float xp) {
        FurnaceRecipes.smelting().addSmelting(id, metadata, output, xp);
    }

    /**
     * Adds a 3x3 crafting recipe for the specified block and the matching uncrafting recipe
     * 
     * @param storageBlock - result
     * @param component -  input
     */
    public static void addStorageRecipe(ItemStack storageBlock, ItemStack component) {
        UtilRecipes.addVanillaRecipe("Shaped", storageBlock, "xxx", "xxx", "xxx",
                Character.valueOf('x'), component);
        // Shape is not necessary
        ItemStack componentStack = new ItemStack(component.itemID, 9, component.getItemDamage());
        UtilRecipes.addVanillaRecipe("Shapeless", componentStack, storageBlock);
    }
}
