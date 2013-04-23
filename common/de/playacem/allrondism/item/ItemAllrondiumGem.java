package de.playacem.allrondism.item;



import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.playacem.allrondism.AllrondismMod;
import de.playacem.allrondism.lib.Strings;

public class ItemAllrondiumGem extends ItemAM {

    public ItemAllrondiumGem(int id) {

        super(id);
        this.setUnlocalizedName(Strings.ALLRONDIUM_GEM);
        this.setCreativeTab(AllrondismMod.tabsAM);
        setMaxStackSize(64);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons (IconRegister iconRegister){
        this.itemIcon = iconRegister.registerIcon("allrondism:gemAllrondium");
    }
}
