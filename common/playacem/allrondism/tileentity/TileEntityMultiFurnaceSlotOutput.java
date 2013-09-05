package playacem.allrondism.tileentity;

public class TileEntityMultiFurnaceSlotOutput extends TileEntityMultiFurnaceDummy implements IExtensionSlot {

    @Override
    public EnumSlotType getSlotType() {

        return EnumSlotType.OUTPUT;
    }

    @Override
    public int getAmountAdditionalSlots() {

        return 1;
    }

}
