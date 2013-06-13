package playacem.allrondism.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import playacem.allrondism.lib.ItemIDs;
import playacem.allrondism.lib.Strings;

/**
 * Allrondism
 * 
 * BlockOreAllrondium
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockOreAllrondium extends BlockAM {

    public BlockOreAllrondium(int id) {
        super(id, Material.rock);
        this.setHardness(5F);
        this.setUnlocalizedName(Strings.ORE_ALLRONDIUM_NAME);
    }

    @Override
    public int idDropped(int par1, Random random, int zero) {
        return ItemIDs.GEM_ALLRONDIUM;
    }

}
