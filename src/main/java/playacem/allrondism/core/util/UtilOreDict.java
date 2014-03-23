package playacem.allrondism.core.util;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Allrondism
 * 
 * UtilOreDict
 * 
 * some functions for ore dictionary work
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class UtilOreDict {

    private static UtilOreDict instance = null;

    private UtilOreDict() {

    }

    public static UtilOreDict instance() {

        if (instance == null) {
            instance = new UtilOreDict();
        }
        return instance;
    }

    // They all fall down to getItemStack(String, int , int)
    /* Object based */
    public ItemStack getItemStack(Object oreDictObject) {

        return getItemStack((String) oreDictObject);
    }

    public ItemStack getItemStack(Object oreDictObject, int stackSize) {

        return getItemStack((String) oreDictObject, stackSize);
    }

    public ItemStack getItemStack(Object oreDictObject, int stackSize, int position) {

        return getItemStack((String) oreDictObject, stackSize, position);
    }

    /* OreID based */
    public ItemStack getItemStack(int oreID) {

        return getItemStack(oreID, 1);
    }

    public ItemStack getItemStack(int oreID, int stackSize) {

        return getItemStack(oreID, stackSize, 0);
    }

    public ItemStack getItemStack(int oreID, int stackSize, int position) {

        return getItemStack(OreDictionary.getOreName(oreID), stackSize, position);
    }

    /* String based */
    public ItemStack getItemStack(String oreDictObject) {

        return getItemStack(oreDictObject, 1);
    }

    public ItemStack getItemStack(String oreDictObject, int stackSize) {

        return getItemStack(oreDictObject, stackSize, 0);
    }

    public ItemStack getItemStack(String oreDictObject, int stackSize, int position) {

        ArrayList<ItemStack> ores = OreDictionary.getOres(oreDictObject);
        if (position >= ores.size()) {
            if (position == ores.size()) {
                position--;
            }
            else {
                LogHelper.alert("Position: " + position + "is bigger than Array Size: " + ores.size());
                LogHelper.alert("Setting position to 0");
                position = 0;
            }
        }
        ItemStack itemStack = ores.get(position);
        itemStack.stackSize = stackSize;
        return itemStack;
    }

    public ArrayList<ItemStack> getItemStackArray(String oreDictObject, int stackSize) {

        ArrayList<ItemStack> ores = OreDictionary.getOres(oreDictObject);
        ArrayList<ItemStack> itemStackArray = new ArrayList<ItemStack>();
        if (ores.isEmpty())
            return null;

        for (int i = 0; i < ores.size(); i++) {
            ItemStack itemStack = ores.get(i);
            itemStack.stackSize = stackSize;
            itemStackArray.add(i, itemStack);
        }
        return itemStackArray;
    }

}
