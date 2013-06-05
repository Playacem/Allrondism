package playacem.allrondism.configuration;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import playacem.allrondism.lib.BlockIDs;
import playacem.allrondism.lib.ItemIDs;
import playacem.allrondism.lib.Reference;
import playacem.allrondism.lib.Strings;
import cpw.mods.fml.common.FMLLog;

/**
 * Allrondism
 * 
 * ConfigurationHandler
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit pahimar
 */
public class ConfigurationHandler {

    public static Configuration configuration;

    public static void init(File configFile) {

        configuration = new Configuration(configFile);

        try {
            configuration.load();

            /* Block configs */
            BlockIDs.ORE_ALLRONDIUM = configuration.getBlock(Strings.ORE_ALLRONDIUM_NAME,BlockIDs.ORE_ALLRONDIUM_DEFAULT).getInt(BlockIDs.ORE_ALLRONDIUM_DEFAULT);
            BlockIDs.STORAGE_DIRT = configuration.getBlock(Strings.STORAGE_DIRT_NAME, BlockIDs.STORAGE_DIRT_DEFAULT).getInt(BlockIDs.STORAGE_DIRT_DEFAULT);
            BlockIDs.STORAGE_COBBLE = configuration.getBlock(Strings.STORAGE_COBBLE_NAME,BlockIDs.STORAGE_COBBLE_DEFAULT).getInt(BlockIDs.STORAGE_COBBLE_DEFAULT);
            BlockIDs.STORAGE_ALLRONDIUM = configuration.getBlock(Strings.STORAGE_ALLRONDIUM_NAME,BlockIDs.STORAGE_ALLRONDIUM_DEFAULT).getInt(BlockIDs.STORAGE_ALLRONDIUM_DEFAULT);

            /* Item configs */
            ItemIDs.GEM_ALLRONDIUM = configuration.getItem(Strings.GEM_ALLRONDIUM, ItemIDs.GEM_ALLRONDIUM_DEFAULT).getInt(ItemIDs.GEM_ALLRONDIUM_DEFAULT);

        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its configuration");
        } finally {
            configuration.save();
        }
    }
    /*
     * WORK IN PROGESS
     * 
     * public static void set(String categoryName, String propertyName, String
     * newValue) {
     * 
     * configuration.load(); if (configuration.hasCategory(categoryName)) { if
     * (configuration.getCategory(categoryName).containsKey(propertyName)) {
     * configuration
     * .getCategory(categoryName).get(propertyName).setName(newValue); } }
     * configuration.save(); }
     */
}
