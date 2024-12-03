package tetris;

import java.awt.Color;
import java.util.Random;

public class TetrisBlock
{
    private int [][]shape;
    private Color color;
    private int x,y;
    private int [][][] shapes;
    private int currentRotation;
    
    private Color[] availableColors = {Color.GREEN, 
                                       Color.RED,
                                       Color.BLUE, 
                                       Color.YELLOW, 
                                       Color.CYAN, 
                                       Color.ORANGE,
                                       Color.MAGENTA};
    
    // Constructor
    public TetrisBlock (int[][] shape)
    {
        this.shape = shape;
        
        initShapes();
    }
    
    // Method to initialize different rotations of the block
    private void initShapes()
    {
        shapes = new int [4][][];
        
        // Generate rotations by rotating the original shape
        for (int i = 0; i<4; i++)
        {
            int r = shape[0].length;
            int c = shape.length;
            
            shapes[i] = new int[r][c];
            
            for(int y = 0; y<r; y++)
            {
                for (int x = 0; x<c; x++)
                {
                    shapes[i][y][x] = shape[c-x-1][y]; // Rotate the shape
                }
            }
            
            shape = shapes[i]; // Update shape to the rotated one
        }
    }
    
    // Method to spawn a new block
    public void spawn(int gridWidth)
    {
        Random r = new Random();
        
        currentRotation = r.nextInt(shapes.length); // Set a random rotation
        shape = shapes[currentRotation]; // Set the current shape to the chosen rotation
        
        // Set random position within the grid bounds
        y = -getHeight();
        x = r.nextInt(gridWidth - getWidth());
        
        // Set a random color for the block
        color = availableColors[r.nextInt(availableColors.length)];
    }
    
    //Getter and Setter Methods
    public int [][] getShape (){return shape;}
    
    public Color getColor(){return color;}
    
    public int getHeight(){return shape.length;}
    
    public int getWidth(){return shape[0].length;}
    
    public int getX(){return x;}
    public void setX(int newX){x=newX;}
    public int getY(){return y;}
    public void setY(int newY){y=newY;}
    
    // Methods for moving the block
    public void moveDown(){y++;}
    public void moveLeft(){x--;}
    public void moveRight(){x++;}
    
    // Method to rotate the block clockwise
    public void Rotate()
    {
        currentRotation++;
        if(currentRotation > 3) currentRotation = 0; //Reset to 0 if index exceeds 3
        shape = shapes[currentRotation];
    }
    
    // Method to rotate the block counter-clockwise
    public void CounterRotate()
    {
        currentRotation--;
        if (currentRotation < 0) currentRotation = 3; //Set to 3 if index goes negative
        shape = shapes[currentRotation];
    }
    
    // Getter methods for the edges of the block
    public int getBottomEdge(){return y + getHeight();}
    public int getLeftEdge(){ return x;}
    public int getRightEdge(){ return x + getWidth();}
}
