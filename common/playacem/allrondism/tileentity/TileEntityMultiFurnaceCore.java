package playacem.allrondism.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import playacem.allrondism.block.ModBlocks;
import playacem.allrondism.core.util.LogHelper;
import playacem.allrondism.core.util.UtilBlock;
import playacem.allrondism.lib.ExtensionData;
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
    public static final int[] inputSlots = {0, 1, 2};
    public static final int[] fuelSlots = {3, 4, 5};
    public static final int[] outputSlots = {6, 7, 8};

    public static final int INVENTORY_SIZE = 9;
    public int sizeMultiblock = 0;

    public int furnaceBurnTime = 0; // if this value reaches 0 --> 1 item finished
    public int currentItemBurnTime = 0; // how long the current consumed item will still last.
    public int furnaceCookTime = 0; // Cook progress(the bar)

    private int cookDuration = 200; // Vanilla default, to be changed by extensions, acts like a speed modifier
    private float itemBurnTimeFactor = 1.0F;
    private float cookDurationFactor = 1.0F;

    public int bonusSlotsInput = 0;
    public int bonusSlotsFuel = 0;
    public int bonusSlotsOutput = 0;

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
        if(metadata > 5) return true;
        return false;
    }

    public int getDirection() {

        int metadata = getBlockMetadata(); //worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
        return isActive() ? metadata - 4 : metadata;
    }

    public void invalidateMultiBlock() {

        isValidMultiblock = false;

        int metadata = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
        if ( isActive() ) metadata -= 4;
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, metadata, 2);

        furnaceBurnTime = 0;
        currentItemBurnTime = 0;
        furnaceCookTime = 0;

        revertDummies(sizeMultiblock);
        sizeMultiblock = 0;

        bonusSlotsInput = 0;
        bonusSlotsFuel = 0;
        bonusSlotsOutput = 0;
    }

    // size = 3 --> 3x3x3 usw.
    public boolean checkIfProperlyFormed(int size) {

        int maxDepth = size - 1;
        int max = (size - 1) / 2;
        int negativeMax = max * -1;

        int dir = getDirection();

        boolean forwardZ = ((dir == ForgeDirection.NORTH.ordinal()) || (dir == ForgeDirection.SOUTH.ordinal()));
        int depthMultiplier = ((dir == ForgeDirection.NORTH.ordinal()) || (dir == ForgeDirection.WEST.ordinal())) ? 1 : -1;

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
                                StringBuilder sb = new StringBuilder();
                                sb.append(String.format("The Center Block is not Air!(x: %d, y: %d, z: %d, Size: %d)", x, y, z, size));
                                LogHelper.debug(sb.toString());
                                return false;
                            } else {
                                continue;
                            }
                        }
                    }

                    if(!(UtilBlock.isValidBlock(worldObj, x, y, z, ModBlocks.storageBlock.blockID, 1) || blockID == ModBlocks.multiFurnaceExtension.blockID )) {
                        StringBuilder s = new StringBuilder();
                        s.append(String.format("A block with id %d located relative to the Core at horiz: %d, vert: %d, depth: %d (x: %d, y: %d, z: %d) is not usable with this MultiBlock (Size: %d)!", blockID, horiz, vert, depth, x, y, z, size));
                        LogHelper.debug(s.toString());
                        return false;
                    }
                }
            }
        }
        sizeMultiblock = size;
        return true;
    }

    public void convertDummies(int size) {

        int maxDepth = size - 1;
        int max = (size - 1) / 2;
        int negativeMax = max * -1;

        int dir = getDirection();

        boolean forwardZ = ((dir == ForgeDirection.NORTH.ordinal()) || (dir == ForgeDirection.SOUTH.ordinal()));
        int depthMultiplier = ((dir == ForgeDirection.NORTH.ordinal()) || (dir == ForgeDirection.WEST.ordinal())) ? 1 : -1;

        for(int horiz = negativeMax; horiz <= max; horiz++) {
            for(int vert = negativeMax; vert <= max; vert++) {
                for(int depth = 0; depth <= maxDepth; depth++) {
                    int x = xCoord + (forwardZ ? horiz : (depth * depthMultiplier));
                    int y = yCoord + vert;
                    int z = zCoord + (forwardZ ? (depth * depthMultiplier) : horiz);


                    if(horiz == 0 && vert == 0 && (depth == 0 || depth == maxDepth / 2))
                        continue;
                    if(UtilBlock.isValidBlock(worldObj, x, y, z, ModBlocks.storageBlock.blockID, 1)) {
                        worldObj.setBlock(x, y, z, ModBlocks.multiFurnaceExtension.blockID, ExtensionData.DUMMY_META, 3);
                        worldObj.markBlockForUpdate(x, y, z);
                    }
                        

                    try {
                        IExtensionSlot te = (IExtensionSlot)worldObj.getBlockTileEntity(x, y, z);
                        EnumSlotType type = te.getSlotType();
                        int amount = te.getAmountAdditionalSlots();
                        
                        switch(type) {
                            case INPUT:
                                bonusSlotsInput += amount;
                                Math.min(bonusSlotsInput, inputSlots.length - 1);
                                break;
                            case FUEL:
                                bonusSlotsFuel += amount;
                                Math.min(bonusSlotsFuel, fuelSlots.length - 1);
                                break;
                            case OUTPUT:
                                bonusSlotsOutput += amount;
                                Math.min(bonusSlotsOutput, outputSlots.length - 1);
                                break;
                        }
                    }catch(Exception e) {}

                    ICoreExtension extensionTE = (ICoreExtension)worldObj.getBlockTileEntity(x, y, z);
                    extensionTE.setCore(this);
                }
            }
        }

        isValidMultiblock = true;
    }

    private void revertDummies(int size) {

        int maxDepth = size - 1;
        int max = (size - 1) / 2;
        int negativeMax = max * -1;

        int dir = getDirection();

        boolean forwardZ = ((dir == ForgeDirection.NORTH.ordinal()) || (dir == ForgeDirection.SOUTH.ordinal()));
        int depthMultiplier = ((dir == ForgeDirection.NORTH.ordinal()) || (dir == ForgeDirection.WEST.ordinal())) ? 1 : -1;

        for(int horiz = negativeMax; horiz <= max; horiz++) {   // Horizontal (X or Z)
            for(int vert = negativeMax; vert <= max; vert++) { // Vertical (Y)
                for(int depth = 0; depth <= maxDepth; depth++) { // Depth (Z or X)
                    int x = xCoord + (forwardZ ? horiz : (depth * depthMultiplier));
                    int y = yCoord + vert;
                    int z = zCoord + (forwardZ ? (depth * depthMultiplier) : horiz);


                    if(horiz == 0 && vert == 0 && (depth == 0 || depth == maxDepth / 2))
                        continue;

                    if(!UtilBlock.isValidBlock(worldObj, x, y, z, ModBlocks.multiFurnaceExtension.blockID, ExtensionData.DUMMY_META))
                        continue;

                    worldObj.setBlock(x, y, z, ModBlocks.storageBlock.blockID, 1, 2);
                    worldObj.markBlockForUpdate(x, y, z);
                }
            }
        }

        isValidMultiblock = false;
    }

    @Override
    public void updateEntity() {

        if(!isValidMultiblock)
            return;

        boolean inventoryChanged = false;
        int metadata = getBlockMetadata();
        int isActive = isActive() ? 1 : 0;

        if(furnaceBurnTime > 0)
            furnaceBurnTime--;

        if(!this.worldObj.isRemote) {
            if(furnaceBurnTime == 0 && canSmelt()) {

                int firstFuelSlotWithFuel = -1;
                do {
                    ++firstFuelSlotWithFuel;
                    currentItemBurnTime = furnaceBurnTime = TileEntityFurnace.getItemBurnTime(inventory[fuelSlots[firstFuelSlotWithFuel]]); 
                }while(firstFuelSlotWithFuel < fuelSlots.length && furnaceBurnTime == 0);
                currentItemBurnTime *= itemBurnTimeFactor;

                if(furnaceBurnTime > 0) {
                    inventoryChanged = true;

                    if(inventory[fuelSlots[firstFuelSlotWithFuel]] != null) {
                        inventory[fuelSlots[firstFuelSlotWithFuel]].stackSize--;

                        if(inventory[fuelSlots[firstFuelSlotWithFuel]].stackSize == 0)
                            inventory[fuelSlots[firstFuelSlotWithFuel]] = inventory[fuelSlots[firstFuelSlotWithFuel]].getItem().getContainerItemStack(inventory[fuelSlots[firstFuelSlotWithFuel]]);

                    }
                }

                if(isBurning() && canSmelt()) {
                    furnaceCookTime++;

                    if(furnaceCookTime == cookDuration * cookDurationFactor) {
                        furnaceCookTime = 0;
                        smeltItems();
                        inventoryChanged = true;
                    }
                } else 
                    furnaceCookTime = 0;


                if(isActive == 0 && furnaceBurnTime > 0) {
                    inventoryChanged = true;
                    metadata = getBlockMetadata();
                    isActive = 1;
                    metadata += 4;
                    worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, metadata, 2);
                }

            }

            if(inventoryChanged) 
                onInventoryChanged();
        }
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

        NBTTagList itemsTag = compound.getTagList("Items");

        for(int i = 0; i < itemsTag.tagCount(); i++) {

            NBTTagCompound slotTag = (NBTTagCompound)itemsTag.tagAt(i);
            byte slot = slotTag.getByte("Slot");

            if(slot >= 0 && slot < inventory.length)
                inventory[slot] = ItemStack.loadItemStackFromNBT(slotTag);    
        }

        isValidMultiblock = compound.getBoolean("isValidMultiblock");
        sizeMultiblock = compound.getShort("sizeMultiblock");

        furnaceBurnTime = compound.getShort("BurnTime");
        furnaceCookTime = compound.getShort("CookTime");
        currentItemBurnTime = TileEntityFurnace.getItemBurnTime(inventory[fuelSlots[0]]);

        bonusSlotsInput = compound.getShort("bonusSlotsInput");
        bonusSlotsFuel = compound.getShort("bonusSlotsFuel");
        bonusSlotsOutput = compound.getShort("bonusSlotsOutput");
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {

        super.writeToNBT(compound);

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
        
        compound.setBoolean("isValidMultiblock", isValidMultiblock);
        System.out.println("[NBT-SavingState] Is valid? " + (isValidMultiblock ? "Yes" : "No"));

        compound.setShort("sizeMultiblock", (short)sizeMultiblock);

        compound.setShort("BurnTime", (short)furnaceBurnTime);
        compound.setShort("CookTime", (short)furnaceCookTime);

        compound.setShort("bonusSlotsInput", (short)bonusSlotsInput);
        compound.setShort("bonusSlotsFuel", (short)bonusSlotsFuel);
        compound.setShort("bonusSlotsOutput", (short)bonusSlotsOutput);
    }

    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int scalingFactor) {

        return furnaceCookTime * scalingFactor / 100;
    }

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int scalingFactor) {

        if(currentItemBurnTime == 0) 
            currentItemBurnTime = 100;

        return furnaceBurnTime * scalingFactor / currentItemBurnTime;
    }

    public boolean isBurning() {

        return furnaceBurnTime > 0;
    }

    private boolean canSmelt() {

        return false;
    }

    public void smeltItems() {

        return;
    }
}
