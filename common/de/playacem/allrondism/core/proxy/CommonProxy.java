package de.playacem.allrondism.core.proxy;

import de.playacem.allrondism.lib.Sprites;

/**
 * Allrondism-Mod
 * 
 * CommonProxy
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class CommonProxy {

    public static String ITEMS_PNG = Sprites.SPRITE_SHEET_LOCATION
            + Sprites.ITEM_SPRITE_SHEET;
    public static String BLOCKS_PNG = Sprites.SPRITE_SHEET_LOCATION
            + Sprites.BLOCK_SPRITE_SHEET;

    // Client stuff
    public void registerRenderers() {
        // Nothing here as the server doesn't render graphics!
    }
}
