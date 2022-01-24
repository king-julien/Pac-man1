package gr11.main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.Timer;

/**
 *
 * @author lamonta
 */
public class pong extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    //Title of the window
    String title = "My Game";

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));
    
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;

    // YOUR GAME VARIABLES WOULD GO HERE
    int ballX = 375;
    int ballY = 275;
    
    int directionX = 1;
    int directionY = 1;
    
    boolean pOneUp = false;
    boolean pOneDown = false;
    
    int paddleOneY = 230;
    
    boolean pTwoUp = false;
    boolean pTwoDown = false;
    
    int paddleTwoY = 230;

    // GAME VARIABLES END HERE    

    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public pong(){
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
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        g.fillRect(25, paddleOneY, 50, 140);
        g.fillRect(725, paddleTwoY, 50, 140);
        
        g.fillOval(ballX, ballY, 50, 50);
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void setup() {
        // Any of your pre setup before the loop starts should go here

    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void loop() {
        ballX = ballX + directionX;
        ballY = ballY + directionY;
        
        if(ballY > 550 || ballY < 0){
            directionY = directionY * -1;
        }
        
        
        if(ballX > 750 || ballX < 0){
            directionX = directionX * -1;
        }
        
        if(pOneUp){
            paddleOneY = paddleOneY - 10;
        }else if(pOneDown){
            paddleOneY = paddleOneY + 10;
        }
        
        if(pTwoUp){
            paddleTwoY = paddleTwoY - 5;
        }else if(pTwoDown){
            paddleTwoY = paddleTwoY + 5;
        }
        
        // bounce of left paddle
        if(ballX < 75 && ballY +50 > paddleOneY 
                && ballY < paddleOneY + 140){
            directionX = directionX*-1;
        }
        
        // bounce off right paddle
        if(ballX + 50 > 725 && ballY +50 > paddleTwoY 
                && ballY < paddleTwoY + 140){
            directionX = directionX * - 0;
            directionY = directionY * - 0;
        }
        
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
            
            if(key == KeyEvent.VK_SHIFT){
                pOneUp = true;
            }else if(key == KeyEvent.VK_CONTROL){
                pOneDown = true;
            }
            
            if(key == KeyEvent.VK_UP){
                pTwoUp = true;
            }else if(key == KeyEvent.VK_DOWN){
                pTwoDown = true;
            }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            
            if(key == KeyEvent.VK_SHIFT){
                pOneUp = false;
            }else if(key == KeyEvent.VK_CONTROL){
                pOneDown = false;
            }
            
            if(key == KeyEvent.VK_UP){
                pTwoUp = false;
            }else if(key == KeyEvent.VK_DOWN){
                pTwoDown = false;
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
        pong game = new pong();
    }
}