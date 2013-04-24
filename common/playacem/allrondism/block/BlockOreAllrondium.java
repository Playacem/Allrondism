package playacem.allrondism.block;

import java.util.Random;

import playacem.allrondism.lib.ItemIDs;
import playacem.allrondism.lib.Strings;

import net.minecraft.block.material.Material;

public class BlockOreAllrondium extends BlockAM {

    public BlockOreAllrondium(int id) {
        super(id, Material.rock);
        this.setHardness(15F);
        this.setUnlocalizedName(Strings.ORE_ALLRONDIUM_NAME);
    }

    @Override
    public int idDropped(int par1, Random random, int zero) {
        return ItemIDs.GEM_ALLRONDIUM;
    }

}
