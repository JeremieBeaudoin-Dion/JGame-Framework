package jGameFramework.core.threadObjects;

import addResourceLoaderHere.GameInformation;
import jGameFramework.collections.ResourceKeyMap;

import javax.sound.sampled.AudioInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Plays music files.
 *
 * This Handler is different from the SoundHandler because it
 * closes clips that are not currently playing. These clips will
 * take up less memory but are longer to load.
 *
 * @author Jérémie Beaudoin-Dion
 */
class MusicHandler {

    private ResourceKeyMap<String, AudioInputStream> musicMap;

    private List<DisposableClip> musicClips;

    MusicHandler(Map<String, AudioInputStream> musicMap){
        this.musicMap = new ResourceKeyMap<>(musicMap);
        musicClips = new LinkedList<>();
    }

    void play(String id) {
        closeAllIfNotRunning();
        deleteAllClosedClips();
        openAndPlay(id);
    }

    private void openAndPlay(String id){
        DisposableClip newClip = new DisposableClip(id);
        newClip.open(musicMap.get(id));
        newClip.play(GameInformation.musicLoopValue);
        musicClips.add(newClip);
    }

    void stop(String id){
        for (DisposableClip clip: musicClips){
            if (clip.isEqualTo(id)){
                clip.close();
            }
        }
    }

    void closeAll(){
        for(DisposableClip clip: musicClips){
            clip.close();
        }
    }

    private void closeAllIfNotRunning(){
        for(DisposableClip clip: musicClips){
            if (!clip.isRunning()) {
                clip.close();
            }
        }
    }

    private void deleteAllClosedClips(){
        musicClips.removeIf(DisposableClip::dispose);
    }


}

