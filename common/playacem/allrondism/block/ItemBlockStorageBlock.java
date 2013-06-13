package playacem.allrondism.block;

import playacem.allrondism.lib.Strings;

/**
 * Allrondism
 * 
 * ItemBlockStorageBlock
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ItemBlockStorageBlock extends ItemBlockFrame {

    public ItemBlockStorageBlock(int id) {
        super(id);
        setMaxDamage(0);
        setHasSubtypes(true);
        setNames(Strings.STORAGE_BLOCKS);
    }

}
