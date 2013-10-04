package playacem.allrondism.core.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import playacem.allrondism.client.audio.SoundHandler;
import playacem.allrondism.client.gui.inventory.GuiMultiFurnace;
import playacem.allrondism.core.util.LogHelper;
import playacem.allrondism.lib.GuiIDs;
import playacem.allrondism.tileentity.TileEntityMultiFurnaceCore;

//import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Allrondism
 * 
 * ClientProxy
 * 
 * Handles the client stuff.
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenderers() {
        // Loading textures
        // MinecraftForgeClient.preloadTexture(ITEMS_PNG);
        // MinecraftForgeClient.preloadTexture(BLOCKS_PNG);
    }

    @Override
    public void registerSoundHandler() {
        MinecraftForge.EVENT_BUS.register(new SoundHandler());
    }
    
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        
        switch(ID) {
            case GuiIDs.MULTI_FURNACE:
                TileEntityMultiFurnaceCore tileMultiFurnace = (TileEntityMultiFurnaceCore) world.getBlockTileEntity(x, y, z);
                return new GuiMultiFurnace(player.inventory, tileMultiFurnace);
            default:
                LogHelper.alert("Invalid Gui ID!(Client Side)");
                break;
        }
        return null;
    }
}
