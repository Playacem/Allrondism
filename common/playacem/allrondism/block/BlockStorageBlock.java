package playacem.allrondism.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import playacem.allrondism.Allrondism;
import playacem.allrondism.lib.Reference;
import playacem.allrondism.lib.Strings;

/**
 * Allrondism
 * 
 * BlockStorageBlock
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class BlockStorageBlock extends Block {

    private String[] _names = Strings.STORAGE_BLOCKS;
    private Icon[] _icons = new Icon[_names.length];
            
    public BlockStorageBlock(int id, Material material) {
        super(id, material);
        setHardness(0.5F);
        setResistance(11.0F);
        setStepSound(soundStoneFootstep);
        setUnlocalizedName("storage");
        setCreativeTab(Allrondism.tabsAM);
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister iconReg) { 
        for(int i = 0; i < _icons.length; i++) {
            _icons[i] = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + getUnlocalizedName() + _names[i]);
        }
    }
    
    @Override
    public Icon getIcon(int side, int meta) {
        
        return _icons[Math.min(meta, _icons.length)];
    }
    
}
