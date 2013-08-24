package playacem.allrondism.tileentity;

import playacem.allrondism.lib.Strings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

//import de.playacem.allrondism.lib.Strings;

/**
 * Allrondism
 * 
 * TileAM
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit pahimar
 */
public class TileAM extends TileEntity {

    protected ForgeDirection orientation;
    protected String owner;
    protected String customName;

    public TileAM() {

        orientation = ForgeDirection.SOUTH;
        owner = "";
        customName = "";
    }

    public ForgeDirection getOrientation() {

        return orientation;
    }

    public void setOrientation(ForgeDirection orientation) {

        this.orientation = orientation;
    }

    public void setOrientation(int orientation) {

        this.orientation = ForgeDirection.getOrientation(orientation);
    }

    public String getOwner() {

        return owner;
    }

    public boolean hasOwner() {

        return owner != null && owner.length() > 0;
    }

    public void setOwner(String owner) {

        this.owner = owner;
    }

    public String getCustomName() {

        return customName;
    }

    public boolean hasCustomName() {

        return customName != null && customName.length() > 0;
    }

    public void setCustomName(String customName) {

        this.customName = customName;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {

        return true; //owner.equals(player.username); // option to override?
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTag) {
        
        super.readFromNBT(nbtTag);
        
        if(nbtTag.hasKey(Strings.NBT_TE_DIRECTION_KEY)) {
            orientation = ForgeDirection.getOrientation(nbtTag.getByte(Strings.NBT_TE_DIRECTION_KEY));
        }
        
        if(nbtTag.hasKey(Strings.NBT_TE_CUSTOM_NAME)) {
            customName = nbtTag.getString(Strings.NBT_TE_CUSTOM_NAME);
        }
    }
    
    @Override
    public void writeToNBT(NBTTagCompound nbtTag) {
        
        super.writeToNBT(nbtTag);
        
        nbtTag.setByte(Strings.NBT_TE_DIRECTION_KEY, (byte) orientation.ordinal());
        
        if(this.hasCustomName()) {
            nbtTag.setString(Strings.NBT_TE_CUSTOM_NAME, customName);
        }
    }
}
