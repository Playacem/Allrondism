package playacem.allrondism.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
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
        this.setStepSound(soundStoneFootstep);
    }

    @Override
    public int idDropped(int par1, Random random, int zero) {
        return ItemIDs.GEM_ALLRONDIUM;
    }

    public void dropBlockAsItemWithChance(World world, int x, int y, int z, int par5, float par6, int par7) {
        super.dropBlockAsItemWithChance(world, x, y, z, par5, par6, par7);
        int xp = 45 + world.rand.nextInt(45);
        this.dropXpOnBlockBreak(world, x, y, z, xp);
    }
}
