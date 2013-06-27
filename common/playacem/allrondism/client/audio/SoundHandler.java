package playacem.allrondism.client.audio;

import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.event.ForgeSubscribe;
import playacem.allrondism.core.util.LogHelper;

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

        LogHelper.debug("Event: " + event.name);
        if (event.name.contains("step.stone")) {
            LogHelper.debug("Stone Event!");
            // event.result = event.manager.soundPoolSounds.getRandomSoundFromSoundPool("step.gravel");
            // TODO add check for specific block 
        }
        
    }

    
}
