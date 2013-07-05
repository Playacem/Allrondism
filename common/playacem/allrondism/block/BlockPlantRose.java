package playacem.allrondism.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import playacem.allrondism.Allrondism;
import playacem.allrondism.lib.Reference;
import playacem.allrondism.lib.Strings;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import static net.minecraftforge.common.EnumPlantType.*;

/**
 * Allrondism
 * 
 * BlockRose
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class BlockPlantRose extends BlockAM implements IPlantable {

    private String[] names = Strings.PLANT_ROSES;
    private Icon[] icons = new Icon[names.length];
    
    public BlockPlantRose(int id) {
        super(id, Material.plants);
        setHardness(0.0F);
        setResistance(0.0F);
        setUnlocalizedName(Strings.PLANT_ROSE_NAME);
        setCreativeTab(Allrondism.tabsAM);
        this.setTickRandomly(true); // TODO add needed methods and checks
        float f = 0.2F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
    }

    @Override
    public EnumPlantType getPlantType(World world, int x, int y, int z) {
        return Plains;
    }

    @Override
    public int getPlantID(World world, int x, int y, int z) {
        return blockID;
    }

    @Override
    public int getPlantMetadata(World world, int x, int y, int z) {
        return world.getBlockMetadata(x, y, z);
    }

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

    @Override
    public int damageDropped(int meta) {
        return meta;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister iconReg) {
        for (int i = 0; i < icons.length; i++) {
            icons[i] = iconReg.registerIcon(Reference.MOD_ID.toLowerCase()
                    + ":" + getUnlocalizedName2() + names[i]);
        }
    }
    
    @Override
    public Icon getIcon(int side, int meta) {
        return icons[Math.min(meta, icons.length)];
    }

}
