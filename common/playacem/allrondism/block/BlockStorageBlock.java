package playacem.allrondism.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import playacem.allrondism.Allrondism;
import playacem.allrondism.lib.Reference;
import playacem.allrondism.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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

    public BlockStorageBlock(int id) {
        super(id, Material.iron);
        setHardness(4.0F);
        setResistance(10.0F);
        setStepSound(soundMetalFootstep);
        setUnlocalizedName(Strings.STORAGE_BLOCKS_NAME);
        setCreativeTab(Allrondism.tabsAM);
        setLightValue(0F);
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister iconReg) {
        for (int i = 0; i < _icons.length; i++) {
            _icons[i] = iconReg.registerIcon(Reference.MOD_ID.toLowerCase()
                    + ":" + getUnlocalizedName2() + _names[i]);
        }
    }

    @Override
    public Icon getIcon(int side, int meta) {

        return _icons[Math.min(meta, _icons.length)];
    }

}
