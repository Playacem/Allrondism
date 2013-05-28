package playacem.allrondism.core.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import playacem.allrondism.lib.Reference;

import cpw.mods.fml.common.FMLLog;

/**
 * Allrondism-Mod
 * 
 * LogHelper
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class LogHelper {

    private static Logger amLogger = Logger.getLogger(Reference.MOD_ID);

    public static void init() {

        amLogger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, String message) {

        amLogger.log(logLevel, message);
    }

}
