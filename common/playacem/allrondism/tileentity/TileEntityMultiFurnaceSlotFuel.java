package playacem.allrondism.tileentity;

/**
 * Allrondism
 * 
 * TileEntityMultiFurnaceSlotFuel
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
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
