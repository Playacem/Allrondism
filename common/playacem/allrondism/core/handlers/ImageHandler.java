package playacem.allrondism.core.handlers;

import java.io.File;

import playacem.allrondism.core.util.ComparableMergableImage;
import playacem.allrondism.lib.Strings;
import playacem.allrondism.lib.Textures;


/**
 * Allrondism
 * 
 * ImageHandler
 * 
 * for some Image magic.
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ImageHandler {

    public static ComparableMergableImage multiFurnaceSlotInput;
    public static ComparableMergableImage multiFurnaceSlotFuel;
    public static ComparableMergableImage multiFurnaceSlotOutput;
    
    public static void init() {
        // TODO add real File names;
        // TODO add system to store hashcodes
        
        String storageCobbleFileName = Strings.STORAGE_BLOCKS_NAME + Strings.STORAGE_BLOCKS[1]; // storageBlockCobble
        
        multiFurnaceSlotInput = new ComparableMergableImage(new File(Textures.BLOCKS_LOCATION), storageCobbleFileName, "TODO");
        multiFurnaceSlotFuel = new ComparableMergableImage(new File(Textures.BLOCKS_LOCATION), storageCobbleFileName, "TODO");
        multiFurnaceSlotOutput = new ComparableMergableImage(new File(Textures.BLOCKS_LOCATION), storageCobbleFileName, "TODO");
        
        /*
         * For later reference: 
         * 
         *  mods/allrondism/textures/blocks/multiFurnaceExtensionSlotInput.png
         *  mods/allrondism/textures/blocks/multiFurnaceExtensionSlotFuel.png
         *  mods/allrondism/textures/blocks/multiFurnaceExtensionSlotOutput.png
         *   
         *  mods/allrondism/textures/blocks/multiFurnaceCoreFront_Unlit.png
         *  mods/allrondism/textures/blocks/multiFurnaceCoreFront_Lit.png
         *  
         *  (Textures i still need)
         */
    }
}
