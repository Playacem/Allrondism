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

    public static Configuration config;

    public static void init(File configFile) {

        config = new Configuration(configFile);

        try {
            config.load();

            /* Block configs */
            BlockIDs.ORE_ALLRONDIUM = config.getBlock(Strings.ORE_ALLRONDIUM_NAME,BlockIDs.ORE_ALLRONDIUM_DEFAULT).getInt(BlockIDs.ORE_ALLRONDIUM_DEFAULT);
            BlockIDs.STORAGE_DIRT = config.getBlock(Strings.STORAGE_DIRT_NAME, BlockIDs.STORAGE_DIRT_DEFAULT).getInt(BlockIDs.STORAGE_DIRT_DEFAULT);
            BlockIDs.STORAGE_COBBLE = config.getBlock(Strings.STORAGE_COBBLE_NAME,BlockIDs.STORAGE_COBBLE_DEFAULT).getInt(BlockIDs.STORAGE_COBBLE_DEFAULT);
            BlockIDs.STORAGE_ALLRONDIUM = config.getBlock(Strings.STORAGE_ALLRONDIUM_NAME,BlockIDs.STORAGE_ALLRONDIUM_DEFAULT).getInt(BlockIDs.STORAGE_ALLRONDIUM_DEFAULT);
            BlockIDs.STORAGE_BLOCKS = config.getBlock(Strings.STORAGE_BLOCKS_NAME, BlockIDs.STORAGE_BLOCKS_DEFAULT).getInt(BlockIDs.STORAGE_BLOCKS_DEFAULT);
            
            /* Item configs */
            ItemIDs.GEM_ALLRONDIUM = config.getItem(Strings.GEM_ALLRONDIUM, ItemIDs.GEM_ALLRONDIUM_DEFAULT).getInt(ItemIDs.GEM_ALLRONDIUM_DEFAULT);

        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its configuration");
        } finally {
            config.save();
        }
    }
    /*
     * WORK IN PROGESS
     * 
     * public static void set(String categoryName, String propertyName, String
     * newValue) {
     * 
     * config.load(); if (config.hasCategory(categoryName)) { if
     * (config.getCategory(categoryName).containsKey(propertyName)) {
     * config
     * .getCategory(categoryName).get(propertyName).setName(newValue); } }
     * config.save(); }
     */
}
