package gr11.main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Scanner;

/**
 *
 * @author gubas3504
 */
public class PacMan1 extends JFrame implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 1000;
    static final int HEIGHT = 1000;

    //Title of the window
    String title = "PacMan - 1";

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));
    
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;

    // YOUR GAME VARIABLES WOULD GO HERE
    
    int PacManDrawX = 443;
    int PacManDrawY = 378;
    
    int directionX = (int) 2.5;
    int directionY = (int) 2.5;
    int directionX2 = (int) -2.5;
    int directionY2 = (int) -2.5;
    
    int PacManDrawX2 = 460;
    int PacManDrawY2 = 383;
    
    int directionstop = 0;
    
    int PacManDraw;
    int PacManInky;
    int PacManPinky;
    int PacManClyde;
    int PacManBlnky;
    int PacManMaze;
    int PacManPelet;
    int PacManLiveScore;
    
    
    
    // GAME VARIABLES END HERE    

    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public PacMan1(){
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);
        
        // Set things up for the game at startup
        setup();

       // Start the game loop
        gameTimer = new Timer(desiredTime,this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    
    public void paintComponent (Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        // GAME DRAWING GOES HERE
        
        // Drawing of the map
        
        //background
        g.setColor(Color.black);
        g.drawRect(0, 0, 1000, 1000);
        g.fillRect(0, 0, 1000, 1000);
        
        // PacMan draw
        PacManDraw (g);
        
        // PacMan pelet draw
        PacManPelet (g);
        
        // PacMan live score draw
        PacManLiveScore (g);
        
        // PacMan maze draw
        PacManMaze (g);
        
        // PacMan Inky draw
        PacManInky (g);
        
        // PacMan Pinky draw
        PacManPinky (g);
        
        // PacMan Pinky draw
        PacManBlinky (g);
        
        // PacMan Pinky draw
        PacManClyde (g);
        
        // GAME DRAWING ENDS HERE
    }
    
    public void PacManInky (Graphics g) {
        
        //GAMES DRAW STARTS HERE
        
        // PacMan body
        g.setColor(Color.cyan);
        g.fillArc(400, 305, 25, 25, 0, 180);
        g.fillRect(400, 315, 25, 25);
        
        // PacMan inky eyes
        g.setColor(Color.gray);
        g.fillOval(12, 10, 6, 6);
        g.fillOval(25, 10, 6, 6);
        
        //GAMES DRAW ENDS HERE
        
    }
    
    public void PacManPinky (Graphics g) {
        
        //GAMES DRAW STARTS HERE
        
        // PacMan body
        g.setColor(Color.pink);
        g.fillArc(445, 305, 25, 25, 0, 180);
        g.fillRect(445, 315, 25, 25);
        
        // PacMan inky eyes
        g.setColor(Color.gray);
        g.fillOval(12, 10, 6, 6);
        g.fillOval(25, 10, 6, 6);
        
        //GAMES DRAW ENDS HERE
        
    }
    
    public void PacManBlinky (Graphics g) {
        
        //GAMES DRAW STARTS HERE
        
        // PacMan body
        g.setColor(Color.red);
        g.fillArc(445, 250, 25, 25, 0, 180);
        g.fillRect(445, 260, 25, 25);
        
        // PacMan inky eyes
        g.setColor(Color.gray);
        g.fillOval(12, 10, 6, 6);
        g.fillOval(25, 10, 6, 6);
        
        //GAMES DRAW ENDS HERE
        
    }
    
    public void PacManClyde (Graphics g) {
        
        //GAMES DRAW STARTS HERE
        
        // PacMan body
        g.setColor(Color.orange);
        g.fillArc(490, 305, 25, 25, 0, 180);
        g.fillRect(490, 315, 25, 25);
        
        // PacMan inky eyes
        g.setColor(Color.gray);
        g.fillOval(12, 10, 6, 6);
        g.fillOval(25, 10, 6, 6);
        
        //GAMES DRAW ENDS HERE
        
    }
    
    public void PacManDraw (Graphics g) {
        
        //GAMES DRAW STARTS HERE
        
        // PacMan body
        g.setColor(Color.yellow);
        g.fillArc(PacManDrawX, PacManDrawY, 25, 25, 125, 305);
        
        // PacMan eyes
        g.setColor(Color.black);
        g.fillOval(PacManDrawX2, PacManDrawY2, 6, 6);
        
        //GAMES DRAW ENDS HERE
        
    }
    
    public void PacManPelet (Graphics g) {
        
        //GAMES DRAW STARTS HERE
        
        // PacMan pelet drawing    
        
        g.setColor(Color.yellow);
        g.fillOval(100, 50, 10, 10);
        g.drawOval(100, 50, 10, 10);
        
        
        //GAMES DRAW ENDS HERE
        
    }
    
    public void PacManLiveScore (Graphics g) {
        
        //GAMES DRAW STARTS HERE
        
        // Live score
        g.drawString("Score: ", 410, 20);
        
        //GAMES DRAW ENDS HERE
        
    }
    
    public void PacManMaze(Graphics g) {
        
        //GAMES DRAW STARTS HERE
        
        // set the color of the maze
        g.setColor(Color.blue);
        
        // outside walls
        
        g.drawRect(50, 30, 820, 10);
        g.fillRect(50, 30, 820, 10);
        
        g.drawRect(50, 670, 820, 10);
        g.fillRect(50, 670, 820, 10);
        
        g.drawRect(50, 30, 10, 200);
        g.fillRect(50, 30, 10, 200);
        
        g.drawRect(860, 30, 10, 200);
        g.fillRect(860, 30, 10, 200);
        
        g.drawRect(50, 430, 10, 250);
        g.fillRect(50, 430, 10, 250);
        
        g.drawRect(860, 430, 10, 250);
        g.fillRect(860, 430, 10, 250);
        
        g.drawRect(700, 300, 170, 10);
        g.fillRect(700, 300, 170, 10);
        
        g.drawRect(700, 350, 170, 10);
        g.fillRect(700, 350, 170, 10);
        
        g.drawRect(50, 300, 170, 10);
        g.fillRect(50, 300, 170, 10);
        
        g.drawRect(50, 350, 170, 10);
        g.fillRect(50, 350, 170, 10);
        
        g.drawRect(700, 230, 170, 10);
        g.fillRect(700, 230, 170, 10);
        
        g.drawRect(700, 430, 170, 10);
        g.fillRect(700, 430, 170, 10);
        
        g.drawRect(50, 230, 170, 10);
        g.fillRect(50, 230, 170, 10);
        
        g.drawRect(50, 430, 170, 10);
        g.fillRect(50, 430, 170, 10);
        
        g.drawRect(700, 230, 10, 80);
        g.fillRect(700, 230, 10, 80);
        
        g.drawRect(700, 360, 10, 80);
        g.fillRect(700, 360, 10, 80);
        
        g.drawRect(210, 230, 10, 80);
        g.fillRect(210, 230, 10, 80);
        
        g.drawRect(210, 360, 10, 80);
        g.fillRect(210, 360, 10, 80);
        
        g.drawRect(435, 30, 40, 90);
        g.fillRect(435, 30, 40, 90);
        
        // ghost cage
        g.drawRect(325, 285, 110, 10);
        g.fillRect(325, 285, 110, 10);
        
        g.drawRect(480, 285, 110, 10);
        g.fillRect(480, 285, 110, 10);
        
        g.drawRect(325, 285, 10, 80);
        g.fillRect(325, 285, 10, 80);
        
        g.drawRect(580, 285, 10, 80);
        g.fillRect(580, 285, 10, 80);
        
        g.drawRect(325, 365, 265, 10);
        g.fillRect(325, 365, 265, 10);
        
        // ghost cage gate
        g.drawLine(430, 290, 480, 290);
        
        // top left of maze
        g.drawRect(90, 70, 130, 70);
        g.fillRect(90, 70, 130, 70);
        
        g.drawRect(90, 170, 130, 30);
        g.fillRect(90, 170, 130, 30);
        
        g.drawRect(250, 70, 145, 50);
        g.fillRect(250, 70, 145, 50);
        
        // top right of maze
        g.drawRect(700, 70, 130, 70);
        g.fillRect(700, 70, 130, 70);
        
        g.drawRect(700, 170, 130, 30);
        g.fillRect(700, 170, 130, 30);
        
        g.drawRect(515, 70, 145, 50);
        g.fillRect(515, 70, 145, 50);
        
        // above ghost cage
        g.drawRect(320, 150, 270, 35);
        g.fillRect(320, 150, 270, 35);
        
        g.drawRect(435, 150, 40, 100);
        g.fillRect(435, 150, 40, 100);
        
        // left of ghost cage
        g.drawRect(250, 150, 30, 160);
        g.fillRect(250, 150, 30, 160);
        
        g.drawRect(250, 220, 140, 30);
        g.fillRect(250, 220, 140, 30);
        
        g.drawRect(250, 350, 30, 90);
        g.fillRect(250, 350, 30, 90);
        
        // right of ghost cage
        g.drawRect(630, 150, 30, 160);
        g.fillRect(630, 150, 30, 160);
        
        g.drawRect(520, 220, 140, 30);
        g.fillRect(520, 220, 140, 30);
        
        g.drawRect(630, 350, 30, 90);
        g.fillRect(630, 350, 30, 90);
        
        // below ghost cage
        g.drawRect(320, 405, 270, 35);
        g.fillRect(320, 405, 270, 35);
        
        g.drawRect(435, 405, 40, 115);
        g.fillRect(435, 405, 40, 115);
        
        // bottem middle
        g.drawRect(320, 540, 270, 35);
        g.fillRect(320, 540, 270, 35);
        
        g.drawRect(435, 540, 40, 100);
        g.fillRect(435, 540, 40, 100);
        
        // bottem left
        g.drawRect(90, 470, 130, 35);
        g.fillRect(90, 470, 130, 35);
        
        g.drawRect(180, 470, 40, 110);
        g.fillRect(180, 470, 40, 110);
        
        g.drawRect(250, 470, 150, 35);
        g.fillRect(250, 470, 150, 35);
        
        g.drawRect(250, 540, 30, 100);
        g.fillRect(250, 540, 30, 100);
        
        g.drawRect(90, 605, 310, 35);
        g.fillRect(90, 605, 310, 35);
        
        g.drawRect(50, 530, 100, 50);
        g.fillRect(50, 530, 100, 50);
        
        // bottem right
        g.drawRect(700, 470, 130, 35);
        g.fillRect(700, 470, 130, 35);
        
        g.drawRect(700, 470, 40, 110);
        g.fillRect(700, 470, 40, 110);
        
        g.drawRect(510, 470, 150, 35);
        g.fillRect(510, 470, 150, 35);
        
        g.drawRect(630, 540, 30, 100);
        g.fillRect(630, 540, 30, 100);
        
        g.drawRect(510, 605, 320, 35);
        g.fillRect(510, 605, 320, 35);
        
        g.drawRect(770, 530, 100, 50);
        g.fillRect(770, 530, 100, 50);
        
        //GAMES DRAW ENDS HERE
        
    }
    
    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void setup() {
        // Any of your pre setup before the loop starts should go here

    }

    // The main game loop
    // In here is where all the logic for my game will go
    
    // Prevents PacMan from colistion glitching
    public void loop() {
        
        
        
    }
    
    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {
            
            int key = e.getKeyCode();
            
            if(key == KeyEvent.VK_LEFT){
                
                PacManDrawX = PacManDrawX - directionX;
                
            }else if(key == KeyEvent.VK_RIGHT){
                
                PacManDrawX = PacManDrawX + directionX;
                
            }
            
            if(key == KeyEvent.VK_UP){
                
                PacManDrawY = PacManDrawY - directionY;
                
            }else if(key == KeyEvent.VK_DOWN){
                
                PacManDrawY = PacManDrawY + directionY;
                
            }
            
            if(key == KeyEvent.VK_LEFT){
                
                PacManDrawX2 = PacManDrawX2 - directionX;
                
            }else if(key == KeyEvent.VK_RIGHT){
                
                PacManDrawX2 = PacManDrawX2 + directionX;
                
            }
            
            if(key == KeyEvent.VK_UP){
                
                PacManDrawY2 = PacManDrawY2 - directionY;
                
            }else if(key == KeyEvent.VK_DOWN){
                
                PacManDrawY2 = PacManDrawY2 + directionY;
                
            }
            
            
            
        }
        
        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            
            int key = e.getKeyCode();
            
            if(key == KeyEvent.VK_A){
                
                PacManDrawX = 0;
                PacManDrawX2 = 0;
                
            }else if(key == KeyEvent.VK_D){
                
                PacManDrawX = 0;
                PacManDrawX2 = 0;
                
            }
            
            if(key == KeyEvent.VK_W){
                
                PacManDrawY = 0;
                PacManDrawY2 = 0;
                
            }else if(key == KeyEvent.VK_S){
                
                PacManDrawY = 0;
                PacManDrawY2 = 0;
                
            }
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        loop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        PacMan1 game = new PacMan1();
    }
}