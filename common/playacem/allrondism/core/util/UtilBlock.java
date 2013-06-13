package playacem.allrondism.core.util;

/**
 * Allrondism
 * 
 * UtilBlock
 * 
 * Methodes for easier interaction with blocks
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class UtilBlock {

    public static float getLightValueFromInt(int lightLevel) {
        return lightLevel / 15.0F;
    }
}
