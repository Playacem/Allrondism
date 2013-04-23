package de.playacem.allrondism.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

//import de.playacem.allrondism.lib.Strings;

/**
 * Allrondism-Mod
 * 
 * TileAM
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class TileAM extends TileEntity {

    private ForgeDirection orientation;
    private String owner;
    private String customName;

    public TileAM() {

        setOrientation(ForgeDirection.SOUTH);
        setOwner("");
        setCustomName("");
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

    public boolean isUsableByPlayer(EntityPlayer player) {

        return owner.equals(player.username);
    }

}
