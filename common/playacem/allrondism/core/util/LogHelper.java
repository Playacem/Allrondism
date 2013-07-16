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
 * @credit pahimar
 */
public class LogHelper {

    private static Logger amLogger = Logger.getLogger(Reference.MOD_ID);

    public static void init() {

        amLogger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, String message) {

        amLogger.log(logLevel, message);
    }

    public static void info(String message) {

        log(Level.INFO, message);
    }

    /** Uses WARNING level. */
    public static void alert(String message) {

        log(Level.WARNING, message);
    }

    public static void debug(String message) {

        log(Level.WARNING, "[DEBUG] " + message);
    }

    public static void severe(String message) {

        log(Level.SEVERE, message);
    }

    public static void config(String message) {

        log(Level.CONFIG, message);
    }

    public static void fine(String message) {

        log(Level.FINE, message);
    }

    public static void finer(String message) {

        log(Level.FINER, message);
    }

    public static void finest(String message) {

        log(Level.FINEST, message);
    }

    /**
     * Use {@link playacem.allrondism.core.util.LogHelper#alert(String) alert}
     * instead
     */
    public static void warning(String message) {

        log(Level.WARNING, message);
    }

}
