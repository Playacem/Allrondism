package playacem.allrondism.client.audio;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.event.ForgeSubscribe;
import playacem.allrondism.core.util.LogHelper;
import playacem.allrondism.lib.BlockIDs;

/**
 * Allrondism
 * 
 * SoundHandler
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class SoundHandler {

    @ForgeSubscribe
    public void onSoundPlay(PlaySoundEvent event) {
        return;
        /*
        //TODO Get the World using DimensionManager.
        //need a way to get the current dimension the client is in.
        World world = Minecraft.getMinecraft().theWorld;
        //World world = DimensionManager.getWorld(dimID);
        int x = (int) event.x;
        int y = (int) event.y;
        int z = (int) event.z;
        if (event.name.contains("step.stone")) {
            if(world.getBlockId(x, y, z)== BlockIDs.STORAGE_BLOCKS ){
                if(world.getBlockMetadata(x, y, z) == 0) {
                    event.manager.pauseAllSounds();
                    event.manager.playSound("step.gravel", event.x, event.y, event.z, 0.15F, 1.0F);
                    event.manager.resumeAllSounds();
                }
            }
        }
        */
    }

    
}
