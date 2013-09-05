package playacem.allrondism.tileentity;

/**
 * Allrondism
 * 
 * TileEntityMultiFurnaceSlotOutput
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @credit pahimar
 */
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
