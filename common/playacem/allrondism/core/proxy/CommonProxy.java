package playacem.allrondism.core.proxy;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import playacem.allrondism.client.gui.inventory.GuiMultiFurnace;
import playacem.allrondism.core.handlers.SpawnHandler;
import playacem.allrondism.core.util.LogHelper;
import playacem.allrondism.inventory.ContainerMultiFurnace;
import playacem.allrondism.lib.GuiIDs;
import playacem.allrondism.lib.Strings;
import playacem.allrondism.tileentity.TileEntityMultiFurnaceCore;
import playacem.allrondism.tileentity.TileEntityMultiFurnaceDummy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

/**
 * Allrondism
 * 
 * CommonProxy
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class CommonProxy implements IGuiHandler {

    public void registerRenderers() {
        // Nothing here as the server doesn't render graphics!
    }

    public void registerSoundHandler() {
        // The Server doesn't manage sounds either.
    }
    
    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityMultiFurnaceCore.class, Strings.TE_MULTI_FURNACE_CORE_NAME);
        GameRegistry.registerTileEntity(TileEntityMultiFurnaceDummy.class, Strings.TE_MULTI_FURNACE_DUMMY_NAME);
    }
    
    public void registerSpawnHandler() {
        MinecraftForge.EVENT_BUS.register(new SpawnHandler());
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch(ID) {
            case GuiIDs.MULTI_FURNACE:
                TileEntityMultiFurnaceCore tileMultiFurnace = (TileEntityMultiFurnaceCore) world.getBlockTileEntity(x, y, z);
                return new ContainerMultiFurnace(player.inventory, tileMultiFurnace);
            default:
                LogHelper.alert("Invalid Gui ID!(Server Side)");
                break;
        }
        return null;
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
