package playacem.allrondism.tileentity;

import playacem.allrondism.block.ModBlocks;
import playacem.allrondism.core.util.UtilBlock;
import playacem.allrondism.lib.Strings;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.ForgeDirection;

/**
 * Allrondism
 * 
 * TileEntityMultiFurnaceCore
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit pahimar, Minalien
 */
public class TileEntityMultiFurnaceCore extends TileAM implements ISidedInventory {

    private ItemStack[] inventory;
    private static int[] inputSlots = {0, 1, 2};
    private static int[] fuelSlots = {3, 4, 5};
    private static int[] outputSlots = {6, 7, 8};
    
    public static final int INVENTORY_SIZE = 9;
    public int sizeMultiBlock = 0;
    
    public int furnaceBurnTime = 0; // if this value reaches 0 --> 1 item finished
    public int currentItemBurnTime = 0; // how long the current consumed item will still last.
    public int furnaceCookTime = 0; // Cook progress
    
    private boolean isValidMultiblock = false;
    
    public TileEntityMultiFurnaceCore() {
        super();
        inventory = new ItemStack[INVENTORY_SIZE];
    }

    public boolean getIsValid() {
        return isValidMultiblock;
    }
    
    public boolean isActive() {
        int metadata = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
        if(metadata > 6) return true;
        return false;
    }
    
    public int getDirection() {
        return isActive() ? getBlockMetadata() - 4 : getBlockMetadata();
    }
    
    public void invalidateMultiBlock() {
        isValidMultiblock = false;
        
        int metadata = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
        if ( isActive() ) metadata -= 4;
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, metadata, 2);
        
        furnaceBurnTime = 0;
        currentItemBurnTime = 0;
        furnaceCookTime = 0;
        
        revertDummies(sizeMultiBlock);
    }
    // size = 3 --> 3x3x3
    public boolean checkIfProperlyFormed(int size) {
        int maxDepth = size - 1;
        int max = size - 2;
        int negativeMax = max * -1;
        
        int dir = getDirection();
        
        boolean forwardZ = ((dir == ForgeDirection.NORTH.ordinal()) || (dir == ForgeDirection.SOUTH.ordinal()));
        int depthMultiplier = forwardZ ? 1 : -1;
        
        for(int horiz = negativeMax; horiz <= max; horiz++) {
            for(int vert = negativeMax; vert <= max; vert++) {
                for(int depth = 0; depth <= maxDepth; depth++) {
                    int x = xCoord + (forwardZ ? horiz : (depth * depthMultiplier));
                    int y = yCoord + vert;
                    int z = zCoord + (forwardZ ? (depth * depthMultiplier) : horiz);
                    
                    int blockID = worldObj.getBlockId(x, y, z);
                    
                    if(horiz == 0 && vert == 0) {
                        if(depth == 0) // Looking at core, move on!
                            continue;
                        
                        if(depth == maxDepth / 2) { // Center must be air!
                            if(!worldObj.isAirBlock(x, y, z)) {
                                return false;
                            } else {
                                continue;
                            }
                        }
                    }
                    // oreAllrondium is a placeholder
                    if(!(blockID == ModBlocks.storageBlock.blockID || blockID == ModBlocks.oreAllrondium.blockID )) {
                        return false;
                    }
                }
            }
        }
        
        return false;
    }
    
    public void convertDummies(int size) {
        int maxDepth = size - 1;
        int max = size - 2;
        int negativeMax = max * -1;
        
        int dir = getDirection();
        
        boolean forwardZ = ((dir == ForgeDirection.NORTH.ordinal()) || (dir == ForgeDirection.SOUTH.ordinal()));
        int depthMultiplier = forwardZ ? 1 : -1;
        
        for(int horiz = negativeMax; horiz <= max; horiz++) {
            for(int vert = negativeMax; vert <= max; vert++) {
                for(int depth = 0; depth <= maxDepth; depth++) {
                    int x = xCoord + (forwardZ ? horiz : (depth * depthMultiplier));
                    int y = yCoord + vert;
                    int z = zCoord + (forwardZ ? (depth * depthMultiplier) : horiz);
                    
                    
                    if(horiz == 0 && vert == 0 && (depth == 0 || depth == maxDepth / 2))
                        continue;
                    //TODO change BlockID and Metadata
                    worldObj.setBlock(x, y, z, 0);
                    worldObj.setBlockMetadataWithNotify(x, y, z, 0, 3);
                    
                    ICoreExtension dummyTE = (ICoreExtension)worldObj.getBlockTileEntity(x, y, z);
                    dummyTE.setCore(this);
                }
            }
        }
    }
    
    private void revertDummies(int size) {
        int maxDepth = size - 1;
        int max = size - 2;
        int negativeMax = max * -1;
        
        int dir = getDirection();
        
        boolean forwardZ = ((dir == ForgeDirection.NORTH.ordinal()) || (dir == ForgeDirection.SOUTH.ordinal()));
        int depthMultiplier = forwardZ ? 1 : -1;
        
        for(int horiz = negativeMax; horiz <= max; horiz++) {   // Horizontal (X or Z)
            for(int vert = negativeMax; vert <= max; vert++) { // Vertical (Y)
                for(int depth = 0; depth <= maxDepth; depth++) { // Depth (Z or X)
                    int x = xCoord + (forwardZ ? horiz : (depth * depthMultiplier));
                    int y = yCoord + vert;
                    int z = zCoord + (forwardZ ? (depth * depthMultiplier) : horiz);
                    
                    int blockID = worldObj.getBlockId(x, y, z);
                    
                    if(horiz == 0 && vert == 0 && (depth == 0 || depth == maxDepth / 2))
                        continue;
                    
                    if(UtilBlock.isValidBlock(worldObj, x, y, z, blockID, 1))
                        continue;
                    
                    worldObj.setBlock(x, y, z, ModBlocks.storageBlock.blockID);
                    worldObj.setBlockMetadataWithNotify(x, y, z, 1, 2);
                    worldObj.markBlockForUpdate(x, y, z);
                }
            }
        }
        isValidMultiblock = false;
    }
    
    /* IInventory stuff */
    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
       
        ItemStack itemStack = getStackInSlot(slot);
        if(itemStack != null) {
            if(itemStack.stackSize <= amount) {
                setInventorySlotContents(slot, null);
            } else {
                itemStack = itemStack.splitStack(amount);
                if(itemStack.stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }
        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack itemStack = getStackInSlot(slot);
        if(itemStack != null) {
            inventory[slot] = null;
            return itemStack;
        } else return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemstack) {
        inventory[slot] = itemstack;
        
        if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
            itemstack.stackSize = this.getInventoryStackLimit();
    }

    @Override
    public String getInvName() {
        return this.hasCustomName() ? this.getCustomName() : Strings.CONTAINER_MULTI_FURNACE_NAME;
    }

    @Override
    public boolean isInvNameLocalized() {
        return this.hasCustomName();
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }


    @Override
    public void openChest() { }

    @Override
    public void closeChest() { }

    @Override
    public boolean isStackValidForSlot(int slot, ItemStack itemstack) {
        for(int i = 0; i < outputSlots.length; ++i) {
            if( outputSlots[i] == slot) return false;
        }
        for(int i = 0; i < fuelSlots.length; ++i) {
            if( fuelSlots[i] == slot) return TileEntityFurnace.isItemFuel(itemstack);
        }
        for(int i = 0; i < inputSlots.length; ++i) {
            if( inputSlots[i] == slot) return true;
        }
        return false;
    }

    /* ISidedInventory stuff */
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return null;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int j) {
        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemstack, int j) {
        return false;
    }

    /* NBT stuff */
    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        
        //int md = compound.getInteger("BlockMeta");
        isValidMultiblock = compound.getBoolean("isValidMultiblock");
        
        NBTTagList itemsTag = compound.getTagList("Items");
        
        for(int i = 0; i < itemsTag.tagCount(); i++) {
            NBTTagCompound slotTag = (NBTTagCompound)itemsTag.tagAt(i);
            byte slot = slotTag.getByte("Slot");
            
            if(slot >= 0 && slot < inventory.length)
                inventory[slot] = ItemStack.loadItemStackFromNBT(slotTag);    
        }
        
        furnaceBurnTime = compound.getShort("BurnTime");
        furnaceCookTime = compound.getShort("CookTime");
        currentItemBurnTime = TileEntityFurnace.getItemBurnTime(inventory[fuelSlots[0]]);
    }
    
    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        
        compound.setBoolean("isValidMultiblock", isValidMultiblock);
        
        compound.setShort("BurnTime", (short)furnaceBurnTime);
        compound.setShort("CookTime", (short)furnaceCookTime);
        NBTTagList itemsList = new NBTTagList();
        
        for(int i = 0; i < inventory.length; i++) {
            if(inventory[i] != null) {
                NBTTagCompound slotTag = new NBTTagCompound();
                slotTag.setByte("Slot", (byte)i);
                inventory[i].writeToNBT(slotTag);
                itemsList.appendTag(slotTag);
            }
            
            compound.setTag("Items", itemsList);
        }
    }
}
