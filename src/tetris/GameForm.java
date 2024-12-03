package tetris;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import static tetris.Tetris.audio;

public class GameForm extends JFrame
{
    private GameArea ga;
    private GameThread gt;
    
     // Constructor
    public GameForm()
    {
        initComponents();
        
        // Create a new game area and add it to the frame
        ga = new GameArea(gameAreaPlaceholder, 10);
        this.add(ga);
        
        initControls(); // Initialize keyboard controls
    }
    
    // Method to initialize keyboard controls
    private void initControls()
    {
        InputMap im = this.getRootPane().getInputMap();
        ActionMap am = this.getRootPane().getActionMap();
        
        // Define key bindings for different actions
        im.put(KeyStroke.getKeyStroke("RIGHT"), "right");
        im.put(KeyStroke.getKeyStroke("LEFT"), "left");
        im.put(KeyStroke.getKeyStroke("A"), "rotateL" );
        im.put(KeyStroke.getKeyStroke("D"), "rotateR" );
        im.put(KeyStroke.getKeyStroke("SPACE"), "space");
        
        // Associate actions with key bindings
        am.put("right", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ga.moveBlockRight();
            }
        });
        
        am.put("left", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ga.moveBlockLeft();
            }
        });
        
        am.put("rotateL", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                ga.CounterRotate();
            }
        });
        
        am.put("rotateR", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                ga.Rotate();
            }
        });
        
        am.put("space", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ga.dropBlock();
            }
        });
    }
    
    // Method to start the game
    public void startGame()
    {
        ga.initBackgroundArray();
       gt = new GameThread(ga, this);
       gt.start();
    }
    
    // Method to update the score display
    public void updateScore(int score)
    {
        scoreDisplay.setText("" +score);
    }
    
    // Method to update the level display
    public void updateLevel(int level)
    {
        levelDisplay.setText("LEVEL: " +level);
    }
    
    // Method to update the lines display
    public void updateLines(int lines)
    {
        linesDisplay.setText("LINES: " +lines);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LeaderboardDisplay = new javax.swing.JPanel();
        gameAreaPlaceholder = new javax.swing.JPanel();
        scoreDisplay = new javax.swing.JLabel();
        btnMainMenu = new javax.swing.JButton();
        levelDisplay = new javax.swing.JLabel();
        ctrlDisplay = new javax.swing.JLabel();
        ctrlDisplay1 = new javax.swing.JLabel();
        ctrlDisplay2 = new javax.swing.JLabel();
        ctrlDisplay3 = new javax.swing.JLabel();
        linesDisplay = new javax.swing.JLabel();
        scoreDisplay1 = new javax.swing.JLabel();
        nameDisplay = new javax.swing.JLabel();

        javax.swing.GroupLayout LeaderboardDisplayLayout = new javax.swing.GroupLayout(LeaderboardDisplay);
        LeaderboardDisplay.setLayout(LeaderboardDisplayLayout);
        LeaderboardDisplayLayout.setHorizontalGroup(
            LeaderboardDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        LeaderboardDisplayLayout.setVerticalGroup(
            LeaderboardDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        gameAreaPlaceholder.setBackground(new java.awt.Color(0, 0, 0));
        gameAreaPlaceholder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout gameAreaPlaceholderLayout = new javax.swing.GroupLayout(gameAreaPlaceholder);
        gameAreaPlaceholder.setLayout(gameAreaPlaceholderLayout);
        gameAreaPlaceholderLayout.setHorizontalGroup(
            gameAreaPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        gameAreaPlaceholderLayout.setVerticalGroup(
            gameAreaPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        scoreDisplay.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        scoreDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreDisplay.setText("0");
        scoreDisplay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnMainMenu.setText("Main Menu");
        btnMainMenu.setFocusable(false);
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        levelDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        levelDisplay.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        levelDisplay.setText("LEVEL: 1");

        ctrlDisplay.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        ctrlDisplay.setText("Controls:");

        ctrlDisplay1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ctrlDisplay1.setText("Rotate: A, D");

        ctrlDisplay2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ctrlDisplay2.setText("Drop: Space");

        ctrlDisplay3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ctrlDisplay3.setText("Move: Left, Right");

        linesDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        linesDisplay.setText("LINES: 0");

        scoreDisplay1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        scoreDisplay1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreDisplay1.setText("SCORE");

        nameDisplay.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        nameDisplay.setText("Group 5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ctrlDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ctrlDisplay1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ctrlDisplay2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ctrlDisplay3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(gameAreaPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(levelDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                        .addComponent(linesDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(nameDisplay))
                        .addComponent(scoreDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scoreDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMainMenu)
                        .addGap(56, 56, 56)
                        .addComponent(ctrlDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ctrlDisplay3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ctrlDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ctrlDisplay2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(levelDisplay)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(linesDisplay)
                            .addGap(34, 34, 34)
                            .addComponent(scoreDisplay1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scoreDisplay)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameDisplay))
                        .addComponent(gameAreaPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        
        // Interrupt the game thread and stop background music
        gt.interrupt();
        audio.stopBGM();
        
        this.setVisible(false);
        Tetris.showStartup();
        
    }//GEN-LAST:event_btnMainMenuActionPerformed

    // Main method
    public static void main(String args[])
    {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                new GameForm().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LeaderboardDisplay;
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JLabel ctrlDisplay;
    private javax.swing.JLabel ctrlDisplay1;
    private javax.swing.JLabel ctrlDisplay2;
    private javax.swing.JLabel ctrlDisplay3;
    private javax.swing.JPanel gameAreaPlaceholder;
    private javax.swing.JLabel levelDisplay;
    private javax.swing.JLabel linesDisplay;
    private javax.swing.JLabel nameDisplay;
    private javax.swing.JLabel scoreDisplay;
    private javax.swing.JLabel scoreDisplay1;
    // End of variables declaration//GEN-END:variables
}
