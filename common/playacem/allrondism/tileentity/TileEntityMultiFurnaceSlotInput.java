package playacem.allrondism.tileentity;

public class TileEntityMultiFurnaceSlotInput extends TileEntityMultiFurnaceDummy implements IExtensionSlot {

    @Override
    public EnumSlotType getSlotType() {

        return EnumSlotType.INPUT;
    }

    @Override
    public int getAmountAdditionalSlots() {

        return 1;
    }

}
