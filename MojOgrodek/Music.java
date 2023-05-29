package MojOgrodek;

import java.io.*;
import javax.sound.sampled.*;

public class Music {
    static Clip clip;
    float previousVolume = 0;
    float currentVolume = 0;
    FloatControl fc;
    AudioInputStream sound;
    public void setFile(String soundFileName) {
        try {
            File file = new File(soundFileName);
            sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();

            clip.open(sound);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

   static public void setVolume(float volume) {
        if (volume < 0f || volume > 1f)
            throw new IllegalArgumentException("Volume not valid: " + volume);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(20f * (float) Math.log10(volume));
    }
    public void play() throws IOException {
        clip.start();
    }
    public void stop() throws IOException {

        clip.stop();
    }


}


