package playacem.allrondism.item;

//import net.minecraft.block.Block;
import net.minecraft.item.Item;
import playacem.allrondism.lib.ItemIDs;
import playacem.allrondism.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

//import cpw.mods.fml.common.registry.GameRegistry;

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

    public static void init() {

        /* Initialize each mod item individually */
        gemAllrondium = new ItemGemAllrondium(ItemIDs.GEM_ALLRONDIUM);

        GameRegistry.registerItem(gemAllrondium, Strings.GEM_ALLRONDIUM);
        LanguageRegistry.addName(gemAllrondium, "Allrondium");
    }

}
