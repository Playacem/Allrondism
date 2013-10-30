package playacem.allrondism.item;

import java.lang.reflect.Method;
import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import playacem.allrondism.core.util.LogHelper;
import playacem.allrondism.lib.Reference;
import playacem.allrondism.lib.Strings;
import playacem.allrondism.lib.Text;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Allrondism
 * 
 * ItemAppleGoldZombie
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit powercrystals
 */
public class ItemAppleGoldZombie extends ItemAM {

    public ItemAppleGoldZombie(int id) {

        super(id);
        this.setUnlocalizedName(Strings.APPLE_GOLD_ZOMBIE_NAME);
        this.setMaxStackSize(64);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {

        itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName()
                .substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean advancedToolTips) {

        infoList.add("This golden Apple is good enough");
        infoList.add("for Zombies, especially " + Text.COLOR_LIGHT_RED + "Villager Zombies");
        super.addInformation(stack, player, infoList, advancedToolTips);
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack s, EntityLiving e) {

        if (!e.worldObj.isRemote && canBeUsed(e.worldObj, e, s)) {
            if (use(e.worldObj, e, s)) {
                s.stackSize--;
                return true;
            }
        }
        return false;
    }

    private boolean canBeUsed(World world, EntityLiving entity, ItemStack stack) {

        return entity instanceof EntityZombie && ((EntityZombie) entity).isVillager();
    }

    private boolean use(World world, EntityLiving entity, ItemStack stack) {

        Method startConversion = null;
        try {
            startConversion = EntityZombie.class.getDeclaredMethod("startConversion", int.class);
        } catch (Exception e) {
            try {
                startConversion = EntityZombie.class.getDeclaredMethod("sj.a", int.class);
            } catch (Exception e1) {
                LogHelper.severe("Reflection was not working.");
                e1.printStackTrace();
                return false;
            }
        } finally {
            startConversion.setAccessible(true);
            try {
                startConversion.invoke((EntityZombie) entity, 300);
            } catch (Exception e) {
                // should never happen
                LogHelper.severe("You shall not see this message.");
                e.printStackTrace();
            }
        }
        // ((EntityZombie)entity).startConversion(300);
        return true;
    }
}
