package playacem.allrondism.tileentity;

public class TileEntityMultiFurnaceSlotFuel extends TileEntityMultiFurnaceDummy implements IExtensionSlot {


    @Override
    public EnumSlotType getSlotType() {

        return EnumSlotType.FUEL;
    }

    @Override
    public int getAmountAdditionalSlots() {

        return 1;
    }

}
