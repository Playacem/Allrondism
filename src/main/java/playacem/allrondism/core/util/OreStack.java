package playacem.allrondism.core.util;

import java.util.Comparator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Allrondism
 * 
 * OreStack
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit pahimar
 */
public class OreStack implements Comparator<OreStack> {

    public String oreName;
    public int stackSize;

    public OreStack() {

        oreName = null;
        stackSize = 0;
    }

    public OreStack(String oreName, int stackSize) {

        this.oreName = oreName;
        this.stackSize = stackSize;
    }

    public OreStack(String oreName) {

        this(oreName, 1);
    }

    public OreStack(int oreID) {

        this(OreDictionary.getOreName(oreID));
    }

    public OreStack(int oreID, int stackSize) {

        this(OreDictionary.getOreName(oreID), stackSize);
    }

    public OreStack(ItemStack itemStack) {

        this(OreDictionary.getOreID(itemStack), itemStack.stackSize);
    }

    public int getOreID() {

        return OreDictionary.getOreID(oreName);
    }

    @Override
    public String toString() {

        return "" + stackSize + "xoreDictionary." + oreName;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof OreStack))
            return false;

        OreStack oreStackObject = (OreStack) object;
        return oreName.equals(oreStackObject.oreName) && stackSize == oreStackObject.stackSize;
    }

    @Override
    public int compare(OreStack oreStack1, OreStack oreStack2) {

        if (oreStack1 != null && oreStack2 != null) {
            if (oreStack1.oreName.equals(oreStack2.oreName))
                return 0;
        }
        return -1;
    }

    public static boolean compareStacks(OreStack oreStack1, OreStack oreStack2) {

        return oreStack1.compareToStack(oreStack2);
    }

    public boolean compareToStack(OreStack oreStack) {

        return compare(this, oreStack) == 0;
    }
}
