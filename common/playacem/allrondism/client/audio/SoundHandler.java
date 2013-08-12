package playacem.allrondism.client.audio;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.event.ForgeSubscribe;
import playacem.allrondism.block.ModBlocks;
import playacem.allrondism.core.util.UtilBlock;

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
        
        World world = Minecraft.getMinecraft().theWorld;
        int x = (int)Math.floor((double)event.x);
        int y = (int)Math.floor((double)event.y);
        int z = (int)Math.floor((double)event.z);;
        String name = event.name;

        if (name.contains("stone")) {
            // The event gives, incase of a StepSound, the coordinates of the Block above.
            if (name.contains("step")) { --y; } 
            boolean valid = UtilBlock.isValidBlock(world, x, y, z, ModBlocks.storageBlock.blockID, 0);
            if (valid) {
                if (name.contains("dig")) {
                    event.result = event.manager.soundPoolSounds.getRandomSoundFromSoundPool("dig.gravel");
                }
                if (name.contains("step")) {
                    event.result = event.manager.soundPoolSounds.getRandomSoundFromSoundPool("step.gravel");
                }
            }
        }   
    }
}
