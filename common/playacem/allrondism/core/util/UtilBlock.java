package playacem.allrondism.core.util;

public class UtilBlock {

    /**
     * Allrondism
     * 
     * UtilBlock
     * 
     * Methodes for easier interaction with blocks
     * @author Playacem
     * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
     * 
     */
    public UtilBlock() {
    }

    public static float getLightValueFromInt(int lightLevel) {
        //improve calculation, some values are getting lower than expected
        return (float)lightLevel / 15.0F;
    }
}
