package playacem.allrondism.lib;

/**
 * Allrondism
 * 
 * Reference
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class Reference {

    /* General Mod related constants */
    public static final String MOD_ID = "Allrondism";
    public static final String MOD_NAME = "Allrondism";
    // @ Stuff will be replaced by an Apache Ant Build script soon(tm)
    public static final String VERSION_NUMBER = "@VERSION@ (build @BUILD_NUMBER@)";
    public static final String DEPENDENCIES = "required-after:Forge@[7.8.1.737,);after:IC2;after:Forestry;after:ThermalExpansion";
    public static final int SHIFTED_ID_RANGE_CORRECTION = 256;

    public static final String SERVER_PROXY_CLASS = "playacem.allrondism.core.proxy.CommonProxy";
    public static final String CLIENT_PROXY_CLASS = "playacem.allrondism.core.proxy.ClientProxy";
}
