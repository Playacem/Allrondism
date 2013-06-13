package playacem.allrondism.core.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import playacem.allrondism.lib.Reference;
import cpw.mods.fml.common.FMLLog;

/**
 * Allrondism
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

    /**
     * Logs a message.
     * 
     * @see info
     * @see alert
     * @param logLevel
     * @param message
     */
    public static void log(Level logLevel, String message) {

        amLogger.log(logLevel, message);
    }

    /**
     * Logs a message. Uses INFO level
     * 
     * @param message
     */
    public static void info(String message) {

        amLogger.log(Level.INFO, message);
    }

    /**
     * Logs a message Uses WARNING level
     * 
     * @param message
     */
    public static void alert(String message) {

        amLogger.log(Level.WARNING, message);
    }
}
