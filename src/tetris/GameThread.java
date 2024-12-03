package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameThread extends Thread
{
    private GameArea ga;
    private GameForm gf;
    private int score;
    private int level = 1;
    private int scorePerLevel = 500;
    private int lines = 0;
    
    // Time interval between block movements (in milliseconds)
    private int pause = 500;
    
    // Speed-up factor per level (decrease pause time)
    private int speedupPerLevel = 60;
    
    // Constructor
    public GameThread(GameArea ga, GameForm gf)
    {
        this.ga = ga;
        this.gf = gf;
        
        // Initialize score and level on the game form
        gf.updateScore(score);
        gf.updateLevel(level);
    }

    GameThread(GameArea ga) {
        throw new UnsupportedOperationException("Not supported yet."); 
    // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // Run method for the thread
    @Override
    public void run()
    {
        // Main game loop
        while(true)
        {
            ga.spawnBlock();
            
             while (ga.moveBlockDown())
            {
                try
                {
                    // Pause between block movements
                    Thread.sleep(pause);
                }
                catch (InterruptedException ex)
                {
                    return;
                }
            }
            
             // Check if the block is out of bounds (game over condition)
            if(ga.isBlockOutOfBounds())
            {
                Tetris.gameOver(score);
                break;
            }
            
            ga.moveBlockToBackground();
            int linesCleared = ga.clearLines();

            // Update the number of lines cleared on the game form
            gf.updateLines(lines += linesCleared);
            
            // Calculate and update the score
            score += calculateScore(linesCleared);
            gf.updateScore(score);
           
            // Calculate current level based on score and update if necessary
            int lvl = score / scorePerLevel + 1;
            if(lvl > level)
            {
                level = lvl;
                gf.updateLevel(level);
                pause -= speedupPerLevel;
                
                Tetris.playLevelup();
            }
        }
    }
    
    // Method to calculate score based on the number of lines cleared
    private int calculateScore(int linesCleared) 
    {
        // Define scoring logic based on the number of lines cleared
        switch (linesCleared) {
            case 1:
                return 100; // Score for clearing one line
            case 2:
                return 300; // Score for clearing two lines
            case 3:
                return 600; // Score for clearing three lines
            case 4:
                return 1000; // Score for clearing four lines (Tetris!)
            default:
                return 0; // No score for other cases
        }
    }
}
