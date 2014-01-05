package playacem.allrondism.client.texture;

import java.io.File;
import java.util.HashMap;

import playacem.allrondism.core.util.ComparableMergableImage;
import playacem.allrondism.lib.Strings;
import playacem.allrondism.lib.Textures;

import com.google.common.hash.HashCode;

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


    public static ComparableMergableImage multiFurnaceCoreFrontUnlit;
    public static ComparableMergableImage multiFurnaceCoreFrontLit;

    public static ComparableMergableImage multiFurnaceSlotInput;
    public static ComparableMergableImage multiFurnaceSlotFuel;
    public static ComparableMergableImage multiFurnaceSlotOutput;

    public static ComparableMergableImage multiFurnaceAutomationInput;
    public static ComparableMergableImage multiFurnaceAutomationFuel;
    public static ComparableMergableImage multiFurnaceAutomationOutput;


    public static HashMap<String, HashCode> map;

    private static String storageCobbleFileName = Strings.STORAGE_BLOCKS_NAME + Strings.STORAGE_BLOCKS[1]; // storageBlockCobble

    public static void init(File dir) {

        // TODO add real File names;
        // TODO add system to store hashcodes

        // This solution works for a normal minecraft installation, but not in Eclipse!
        File resourcePath = new File(dir,"");
        File path = new File(resourcePath, Textures.BLOCKS_LOCATION);
        multiFurnaceCoreFrontUnlit = new ComparableMergableImage(path, storageCobbleFileName, "TODO");
        multiFurnaceCoreFrontLit = new ComparableMergableImage(path, storageCobbleFileName, "TODO");

        multiFurnaceSlotInput = new ComparableMergableImage(path, storageCobbleFileName, "TODO");
        multiFurnaceSlotFuel = new ComparableMergableImage(path, storageCobbleFileName, "TODO");
        multiFurnaceSlotOutput = new ComparableMergableImage(path, storageCobbleFileName, "TODO");

        multiFurnaceAutomationInput = new ComparableMergableImage(path, storageCobbleFileName, "TODO");
        multiFurnaceAutomationFuel = new ComparableMergableImage(path, storageCobbleFileName, "TODO");
        multiFurnaceAutomationOutput = new ComparableMergableImage(path, storageCobbleFileName, "TODO");



        // fillMap();

        /*
         * For later reference:
         * mods/allrondism/textures/blocks/multiFurnaceExtensionSlotInput.png
         * mods/allrondism/textures/blocks/multiFurnaceExtensionSlotFuel.png
         * mods/allrondism/textures/blocks/multiFurnaceExtensionSlotOutput.png
         * mods/allrondism/textures/blocks/multiFurnaceCoreFront_Unlit.png
         * mods/allrondism/textures/blocks/multiFurnaceCoreFront_Lit.png
         * (Textures i still need)
         */
    }

    @SuppressWarnings("unused")
    private static void fillMap() {

        map.put(storageCobbleFileName, multiFurnaceSlotInput.getHashBG());

        map.put("TODO", multiFurnaceCoreFrontUnlit.getHashOverlay());
        map.put("TODO", multiFurnaceCoreFrontLit.getHashOverlay());

        map.put("TODO", multiFurnaceSlotInput.getHashOverlay());
        map.put("TODO", multiFurnaceSlotFuel.getHashOverlay());
        map.put("TODO", multiFurnaceSlotOutput.getHashOverlay());
        
        map.put("TODO", multiFurnaceAutomationInput.getHashOverlay());
        map.put("TODO", multiFurnaceAutomationFuel.getHashOverlay());
        map.put("TODO", multiFurnaceAutomationOutput.getHashOverlay());


    }
}
