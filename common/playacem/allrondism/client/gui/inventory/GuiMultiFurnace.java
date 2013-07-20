package playacem.allrondism.client.gui.inventory;

import playacem.allrondism.inventory.ContainerMultiFurnace;
import playacem.allrondism.tileentity.TileEntityMultiFurnaceCore;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

/**
 * Allrondism
 * 
 * GuiMultiFurnace
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GuiMultiFurnace extends GuiContainer {

    private TileEntityMultiFurnaceCore tileEntity;
    public GuiMultiFurnace(InventoryPlayer playerInventory, TileEntityMultiFurnaceCore tileEntity) {
        super(new ContainerMultiFurnace(playerInventory, tileEntity));
        
        this.tileEntity = tileEntity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        
    }
}
