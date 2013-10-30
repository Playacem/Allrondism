package playacem.allrondism.configuration;

/**
 * Allrondism
 * 
 * ConfigurationSettings
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit pahimar
 */
public class ConfigurationSettings {

    /* Debug setting */
    public static boolean DEBUG_MODE;
    public static final String DEBUG_MODE_CONFIGNAME = "debug_mode";
    public static final boolean DEBUG_MODE_DEFAULT = false;

    /* Doubling Recipes related settings */

    public static boolean DOUBLING_COPPER;
    public static final String DOUBLING_COPPER_CONFIGNAME = "doublingRecipes.enable_copper";
    public static final boolean DOUBLING_COPPER_DEFAULT = true;

    public static boolean DOUBLING_GOLD;
    public static final String DOUBLING_GOLD_CONFIGNAME = "doublingRecipes.enable_gold";
    public static final boolean DOUBLING_GOLD_DEFAULT = true;

    public static boolean DOUBLING_LEAD;
    public static final String DOUBLING_LEAD_CONFIGNAME = "doublingRecipes.enable_lead";
    public static final boolean DOUBLING_LEAD_DEFAULT = true;

    public static boolean DOUBLING_SILVER;
    public static final String DOUBLING_SILVER_CONFIGNAME = "doublingRecipes.enable_silver";
    public static final boolean DOUBLING_SILVER_DEFAULT = true;

    public static boolean DOUBLING_TIN;
    public static final String DOUBLING_TIN_CONFIGNAME = "doublingRecipes.enable_tin";
    public static final boolean DOUBLING_TIN_DEFAULT = true;

    public static boolean DOUBLING_STEEL;
    public static final String DOUBLING_STEEL_CONFIGNAME = "doublingRecipes.enable_steel";
    public static final boolean DOUBLING_STEEL_DEFAULT = true;

    public static boolean DOUBLING_HSLA;
    public static final String DOUBLING_HSLA_CONFIGNAME = "doublingRecipes.enable_hsla";
    public static final boolean DOUBLING_HSLA_DEFAULT = true;
}
