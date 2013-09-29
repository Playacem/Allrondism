package playacem.allrondism.client.gui.inventory;

import org.lwjgl.opengl.GL11;

import playacem.allrondism.inventory.ContainerMultiFurnace;
import playacem.allrondism.lib.Strings;
import playacem.allrondism.lib.Textures;
import playacem.allrondism.tileentity.TileEntityMultiFurnaceCore;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

/**
 * Allrondism
 * 
 * GuiMultiFurnace
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GuiMultiFurnace extends GuiContainer {

    private TileEntityMultiFurnaceCore tileCore;
    
    public GuiMultiFurnace(InventoryPlayer playerInventory, TileEntityMultiFurnaceCore tileEntity) {
        super(new ContainerMultiFurnace(playerInventory, tileEntity));
        
        this.tileCore = tileEntity;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {

        String containerName = tileCore.isInvNameLocalized() ? tileCore.getInvName() : "Multi-Furnace";
        fontRenderer.drawString(containerName, xSize / 2 - fontRenderer.getStringWidth(containerName) / 2,  6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_INVENTORY), 8, ySize - 93, 4210752);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(Textures.GUI_MULTI_FURNACE);
        
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
        int timeScaled;
        int debug = -16;
        
        if(tileCore.isBurning()) {
            timeScaled = tileCore.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(xStart + 56 + debug, yStart + 36 + 12 - timeScaled, 176, 12 - timeScaled, 14, timeScaled + 2);
            //^needs to be tested!
        }
        
        timeScaled = tileCore.getCookProgressScaled(24);
        drawTexturedModalRect(xStart + 79, yStart + 34, 176, 14, timeScaled + 1, 16);
       
    }

    
}
