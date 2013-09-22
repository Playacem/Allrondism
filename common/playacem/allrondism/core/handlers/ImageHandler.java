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
        
        String baseFileName = Strings.STORAGE_BLOCKS_NAME + Strings.STORAGE_BLOCKS[1];
        
        multiFurnaceSlotInput = new ComparableMergableImage(new File(Textures.BLOCKS_LOCATION), baseFileName, "TODO");
        multiFurnaceSlotFuel = new ComparableMergableImage(new File(Textures.BLOCKS_LOCATION), baseFileName, "TODO");
        multiFurnaceSlotOutput = new ComparableMergableImage(new File(Textures.BLOCKS_LOCATION), baseFileName, "TODO");
    }
}
