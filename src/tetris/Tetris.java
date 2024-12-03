package tetris;

import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Tetris
{
    private static GameForm gf;
    private static StartupForm sf;
    private static LeaderboardForm lf;
    
    public static AudioPlayer audio = new AudioPlayer();
    
     // Method to start the game
    public static void start()
    {
        gf.setVisible(true);
        gf.startGame();
        playBGM();
    }
    
    // Method to show the leaderboard form
    public static void showLeaderboard()
    {
        lf.setVisible(true);
    }
    
    // Method to show the startup form
    public static void showStartup()
    {
        sf.setVisible(true);
    }
    
    // Method called when the game is over
    public static void gameOver(int score)
    {
        audio.stopBGM();;
        playGameover();
        
        // Prompt user to enter their name
        String playerName = JOptionPane.showInputDialog("Game Over!\nPlease enter your name.");
        
        gf.setVisible(false);
        lf.addPlayer(playerName, score);
    }
    
    // Method to play sound when lines are cleared
    public static void playClear() 
    {
        audio.playClearLine();
    }
    
    // Method to play gameover sound
    public static void playGameover() 
    {
        audio.playGameover();
    }
    
    // Method to play levelup sound
    public static void playLevelup() 
    {
        audio.playLevelup();
    }
    
    // Method to play game over sound
    public static void playDrop() 
    {
        audio.playDrop();
    }
    
    // Method to play background music
    public static void playBGM() 
    {
        audio.playBGM();
        if (audio.bgMusic != null) {
            audio.bgMusic.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
    
    // Main method to start the game
    public static void main(String[] args)
    {
        // Invoke the GUI on the event dispatch thread
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                // Initialize game, startup, and leaderboard forms
                gf = new GameForm();
                sf = new StartupForm();
                lf = new LeaderboardForm();
        
                sf.setVisible(true);
            }
        });
    } 
}
