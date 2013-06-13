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
    public void soundPlayed(PlaySoundEvent event) {
        LogHelper.info("Sound detected: " + event.source.soundName);

        if (event.source.soundName.contains("step/stone")) {
            LogHelper.info("Stone Sound!");
            if (event.isCancelable()) {
                LogHelper.info("You can cancel this stuff!");
            }
        }
    }

}
