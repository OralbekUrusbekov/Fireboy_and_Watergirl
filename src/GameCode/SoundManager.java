package GameCode;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundManager {
    private static SoundManager instance;
    private Clip backgroundClip; // Бір ғана фон музыка Clip

    private SoundManager() {
        // Приватный конструктор
    }

    public static SoundManager getInstance() {
        if (instance == null) {
            instance = new SoundManager();
        }
        return instance;
    }

    public void playSound(String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void loopSound(String filePath) {
        try {
            // Егер музыка ойналып тұрса — тоқтатамыз
            if (backgroundClip != null && backgroundClip.isRunning()) {
                backgroundClip.stop();
                backgroundClip.close();
            }

            File soundFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            backgroundClip = AudioSystem.getClip();
            backgroundClip.open(audioStream);
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
            backgroundClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stopBackgroundMusic() {
        if (backgroundClip != null && backgroundClip.isRunning()) {
            backgroundClip.stop();
            backgroundClip.close();
        }
    }
}
