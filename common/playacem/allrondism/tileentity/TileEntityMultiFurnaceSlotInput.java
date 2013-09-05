package playacem.allrondism.tileentity;

/**
 * Allrondism
 * 
 * TileEntityMultiFurnaceSlotInput
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit pahimar
 */
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
