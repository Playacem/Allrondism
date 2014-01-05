package playacem.allrondism.core.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import playacem.allrondism.configuration.Settings;
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

    public static void log(Level logLevel, Object object) {

        amLogger.log(logLevel, object.toString());
    }

    public static void info(Object object) {

        log(Level.INFO, object);
    }

    /** Uses WARNING level. */
    public static void alert(Object object) {

        log(Level.WARNING, object);
    }

    /**
     * Uses INFO level and links to
     * {@link playacem.allrondism.core.util.LogHelper#debug(String, boolean)
     * this}
     */
    public static void debug(Object object) {

        debug(object, false);
    }

    /** if true: WARNING, if false: INFO */
    public static void debug(Object object, boolean isWarningLevel) {

        if (Settings.DEBUG_MODE) {
            if (isWarningLevel) {
                log(Level.WARNING, "[DEBUG] " + object.toString());
            } else {
                log(Level.INFO, "[DEBUG] " + object.toString());
            }
        }
    }

    public static void severe(Object object) {

        log(Level.SEVERE, object);
    }

    public static void config(Object object) {

        log(Level.CONFIG, object);
    }

    public static void fine(Object object) {

        log(Level.FINE, object);
    }

    public static void finer(Object object) {

        log(Level.FINER, object);
    }

    public static void finest(Object object) {

        log(Level.FINEST, object);
    }

    /**
     * Use {@link playacem.allrondism.core.util.LogHelper#alert(String) alert}
     * instead
     */
    public static void warning(Object object) {

        log(Level.WARNING, object);
    }

}
