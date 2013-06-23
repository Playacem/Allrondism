package playacem.allrondism.core.util;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Allrondism
 * 
 * BlockAM
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class UtilOreDict {

    private static final UtilOreDict instance = new UtilOreDict();

    private UtilOreDict() {
    }

    public static UtilOreDict instance() {
        return instance;
    }

    public ItemStack getItemStack(String oreDictObject) {
        return getItemStack(oreDictObject, 1);
    }

    public ItemStack getItemStack(String oreDictObject, int stackSize) {
        ArrayList<ItemStack> ores = OreDictionary.getOres(oreDictObject);
        ItemStack iS = ores.get(0); // gets the first Ore
        iS.stackSize = stackSize;
        return iS;
    }

    public ItemStack getItemStack(int oreID) {
        return getItemStack(oreID, 1);

    }

    public ItemStack getItemStack(int oreID, int stackSize) {
        return getItemStack(OreDictionary.getOreName(oreID), stackSize);
    }
}
