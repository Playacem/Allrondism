package playacem.allrondism.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import playacem.allrondism.Allrondism;
import playacem.allrondism.core.util.LogHelper;
import playacem.allrondism.lib.Reference;
import playacem.allrondism.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

/**
 * Allrondism
 * 
 * BlockPlantRose
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class BlockPlantRose extends BlockFlower {

    private String[] names = Strings.ROSES;
    private Icon[] icons = new Icon[names.length];
    
    public BlockPlantRose(int id) {
        super(id, Material.plants);
        setHardness(0.0F);
        setStepSound(soundGrassFootstep);
        setUnlocalizedName(Strings.PLANT_ROSE_NAME);
        setCreativeTab(Allrondism.tabsAM);
        this.setTickRandomly(true);
        
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return super.canPlaceBlockAt(world, x, y, z) && canBlockStay(world, x, y, z);
    }
    
    @Override
    public boolean canBlockStay(World world, int x, int y, int z) {
        Block soil = blocksList[world.getBlockId(x, y - 1, z)];
        return (soil != null && soil.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this));
    }
    
    @Override
    public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
        int id = world.getBlockId(x, y, z);
        return canThisPlantGrowOnThisBlockID(id);
    }
    
    @Override
    public boolean canThisPlantGrowOnThisBlockID(int id) {
        return id == Block.grass.blockID || id == Block.dirt.blockID || id == Block.tilledField.blockID || id == ModBlocks.storageBlock.blockID;
    }
    
    /* GameUpdate relevant stuff */

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID) {
        super.onNeighborBlockChange(world, x, y, z, neighborBlockID);
        this.checkRoseChange(world, x, y, z);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random par5Random) {
        this.checkRoseChange(world, x, y, z);
    }

    private void checkRoseChange(World world, int x, int y, int z) {
        int lightVal = world.getBlockLightValue(x, y, z);
        int oldMetadata = world.getBlockMetadata(x, y, z);
        int newMetadata = 0;
        
        /*if (!this.canBlockStay(world, x, y, z)) {
            LogHelper.debug("Rose cannot stay, dropping it!",  true);
            //this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            //world.setBlockToAir(x, y, z);
        }*/
        if(this.canBlockStay(world, x, y, z)) {
            if(lightVal > 7) { newMetadata = 1; }
            if(oldMetadata != newMetadata) {
            
                /** Flag 1 will cause a block update. 
                 *  Flag 2 will send the change to clients (you almost always want this). 
                 *  Flag 4 prevents the block from being re-rendered, if this is a client world. 
                 *  Flags can be added together. */
                world.setBlockMetadataWithNotify(x, y, z, newMetadata , 3);
            }
        }
    }
    
    
    /* Render relevant stuff */
    
    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube() {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, flowers, etc)
     */
    public boolean renderAsNormalBlock() {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType() {
        return 1;
    }
    
    /** Returns the collision box. Returning null means no collision box ==> You can walk through this block. */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }
    
    /* Game and texture relevant stuff */
    @Override 
    public int idDropped(int par1, Random random, int zero) {
        return blockID;   
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }
    
    public int quantityDropped(Random random) {
        short f = 0;
        int i = random.nextInt(100);
        LogHelper.debug("Random int for dropping Roses: " + i + ", drops bonus: " + (i < 25 ? "yes" : "no"));
        if(i < 25) f = 1;
        return 1 + f;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister iconReg) {
        for (int i = 0; i < icons.length; i++) {
            icons[i] = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + getUnlocalizedName2() + names[i]);
        }
    }
    
    @Override
    public Icon getIcon(int side, int meta) {
        return icons[Math.min(meta, icons.length)];
    }

}
