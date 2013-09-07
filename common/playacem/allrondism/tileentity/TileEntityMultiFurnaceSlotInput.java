package playacem.allrondism.tileentity;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Allrondism
 * 
 * TileEntityMultiFurnaceSlotInput
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityMultiFurnaceSlotInput extends TileEntityMultiFurnaceDummy implements IExtensionSlot {

    TileEntityMultiFurnaceCore tileEntityCore;
    int coreX;
    int coreY;
    int coreZ;
    
    /* ICoreExtension */
    
    @Override
    public void setCore(TileEntityMultiFurnaceCore core) {
        coreX = core.xCoord;
        coreY = core.yCoord;
        coreZ = core.zCoord;
        tileEntityCore = core;
    }
    
    @Override
    public TileEntityMultiFurnaceCore getCore() {
        if(tileEntityCore == null) {
            tileEntityCore = (TileEntityMultiFurnaceCore)worldObj.getBlockTileEntity(coreX, coreY, coreZ);
        }
        return tileEntityCore;
    }
    
    /* IExtensionSlot */
    
    @Override
    public EnumSlotType getSlotType() {

        return EnumSlotType.INPUT;
    }

    @Override
    public int getAmountAdditionalSlots() {

        return 1;
    }
    
    /* NBT stuff */
    
    @Override
    public void readFromNBT(NBTTagCompound compund) {
        super.readFromNBT(compund);
        
        coreX = compund.getInteger("CoreX");
        coreY = compund.getInteger("CoreY");
        coreZ = compund.getInteger("CoreZ");
    }
    
    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        
        compound.setInteger("CoreX", coreX);
        compound.setInteger("CoreY", coreY);
        compound.setInteger("CoreZ", coreZ);
    }
}
