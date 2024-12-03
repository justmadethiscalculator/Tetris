package tetris;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
    // Paths to audio files
    private String soundsFolder =  "tetrissounds" + File.separator;
    private String clearLinePath = soundsFolder + "clear.wav";
    private String gameoverPath = soundsFolder + "success.wav";
    private String bgMusicPath = soundsFolder + "bgMusic.wav";
    private String levelupPath = soundsFolder + "levelup.wav";
    private String dropPath = soundsFolder + "drop.wav";
    
    // Clips for storing audio
    private Clip clearLineSound, gameoverSound, levelupSound, dropSound;
    public Clip bgMusic;
    
    // Constructor
    public AudioPlayer(){
        try {
            // Initialize audio clips
            clearLineSound = AudioSystem.getClip();
            gameoverSound = AudioSystem.getClip();
            levelupSound = AudioSystem.getClip();
            dropSound = AudioSystem.getClip();
            bgMusic = AudioSystem.getClip();
            
            // Load audio files into clips
            getAudio(clearLineSound, clearLinePath);
            getAudio(gameoverSound, gameoverPath);
            getAudio(levelupSound, levelupPath);
            getAudio(dropSound, dropPath);
            getAudio(bgMusic, bgMusicPath);
            
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            //Log any exceptions
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Method to play clearLineSound
    public void playClearLine() {
        clearLineSound.setFramePosition(0); // Reset the position of the sound to the beginning
        clearLineSound.start();
    }
    
    // Method to play gameoverSound
    public void playGameover() {
        gameoverSound.setFramePosition(0); // Reset the position of the sound to the beginning
        gameoverSound.start();
    }
    
    // Method to play levelupSound
    public void playLevelup() {
        levelupSound.setFramePosition(0); // Reset the position of the sound to the beginning
        levelupSound.start();
    }
    
    // Method to play gameoverSound
    public void playDrop() {
        dropSound.setFramePosition(0); // Reset the position of the sound to the beginning
        dropSound.start();
    }
    
    // Method to play bgMusic
    public void playBGM() {
        bgMusic.setFramePosition(0); // Reset the position of the sound to the beginning
        bgMusic.start();
    }
    
    // Method to stop bgMusic
    public void stopBGM() {
        if (bgMusic != null && bgMusic.isRunning()) {
            bgMusic.stop();
        }
    }
    
    // Method to load audio file into clip
    private void getAudio(Clip clip, String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // Open audio file and load it into the clip
        clip.open( AudioSystem.getAudioInputStream( new File(filePath).getAbsoluteFile()));
    }
}
