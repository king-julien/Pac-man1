package gr11.main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;
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
 * @author gubas3504
 */
public class PacMan2 extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 1000;
    static final int HEIGHT = 1000;

    //Title of the window
    String title = "PacMan - 2";

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));
    
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;

    // YOUR GAME VARIABLES WOULD GO HERE
    
    Rectangle player = new Rectangle(433, 368, 20, 20);
    Rectangle player2 = new Rectangle(435, 308, 20, 20);
    Rectangle leftPotal = new Rectangle(20, 310, 30, 30);
    Rectangle rightPotal = new Rectangle(840, 310, 30, 30);
    
    // player movement
    boolean left = false;
    boolean right = false;
    boolean up = false;
    boolean down = false;
    
    // player 2 movement
    boolean left2 = false;
    boolean right2 = false;
    boolean up2 = false;
    boolean down2 = false;
    boolean end = false;
    boolean score = false;
    int speed = 5;
    int stop = 0;
    
    int collected = 0;
    
    boolean onGround = false;
    
    Rectangle [] blocks = new Rectangle [400];
    
    Color opacblack = new Color(100, 0, 0, 1);
    
    // GAME VARIABLES END HERE    

    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public PacMan2(){
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
        
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        
        for (int i = 0; i < blocks.length; i++) {
            
            if(blocks[i] != null) {
                
                g.setColor(Color.BLUE);
                
                g.fillRect(blocks[1].x, blocks[1].y, blocks[1].width, blocks[1].height);
                
                g.fillRect(blocks[2].x, blocks[2].y, blocks[2].width, blocks[2].height);
                
                g.fillRect(blocks[3].x, blocks[3].y, blocks[3].width, blocks[3].height);
                
                g.fillRect(blocks[4].x, blocks[4].y, blocks[4].width, blocks[4].height);
                
                g.fillRect(blocks[5].x, blocks[5].y, blocks[5].width, blocks[5].height);
                
                g.fillRect(blocks[6].x, blocks[6].y, blocks[6].width, blocks[6].height);
                
                g.fillRect(blocks[7].x, blocks[7].y, blocks[7].width, blocks[7].height);
                
                g.fillRect(blocks[8].x, blocks[8].y, blocks[8].width, blocks[8].height);
                
                g.fillRect(blocks[9].x, blocks[9].y, blocks[9].width, blocks[9].height);
                
                g.fillRect(blocks[10].x, blocks[10].y, blocks[10].width, blocks[10].height);
                
                g.fillRect(blocks[11].x, blocks[11].y, blocks[11].width, blocks[11].height);
                
                g.fillRect(blocks[12].x, blocks[12].y, blocks[12].width, blocks[12].height);
                
                g.fillRect(blocks[13].x, blocks[13].y, blocks[13].width, blocks[13].height);
                
                g.fillRect(blocks[14].x, blocks[14].y, blocks[14].width, blocks[14].height);
                
                g.fillRect(blocks[15].x, blocks[15].y, blocks[15].width, blocks[15].height);
                
                g.fillRect(blocks[16].x, blocks[16].y, blocks[16].width, blocks[16].height);
                
                g.fillRect(blocks[17].x, blocks[17].y, blocks[17].width, blocks[17].height);
                
                g.fillRect(blocks[18].x, blocks[18].y, blocks[18].width, blocks[18].height);
                
                g.fillRect(blocks[19].x, blocks[19].y, blocks[19].width, blocks[19].height);
                
                g.fillRect(blocks[20].x, blocks[20].y, blocks[20].width, blocks[20].height);
                
                g.fillRect(blocks[21].x, blocks[21].y, blocks[21].width, blocks[21].height);
                
                g.fillRect(blocks[22].x, blocks[22].y, blocks[22].width, blocks[22].height);
                
                g.fillRect(blocks[23].x, blocks[23].y, blocks[23].width, blocks[23].height);
                
                g.fillRect(blocks[189].x, blocks[189].y, blocks[189].width, blocks[189].height);
                
                g.fillRect(blocks[25].x, blocks[25].y, blocks[25].width, blocks[25].height);
                
                g.fillRect(blocks[26].x, blocks[26].y, blocks[26].width, blocks[26].height);
                
                g.fillRect(blocks[27].x, blocks[27].y, blocks[27].width, blocks[27].height);
                
                g.fillRect(blocks[28].x, blocks[28].y, blocks[28].width, blocks[28].height);
                
                g.fillRect(blocks[29].x, blocks[29].y, blocks[29].width, blocks[29].height);
                
                g.fillRect(blocks[30].x, blocks[30].y, blocks[30].width, blocks[30].height);
                
                g.fillRect(blocks[31].x, blocks[31].y, blocks[31].width, blocks[31].height);
                
                g.fillRect(blocks[32].x, blocks[32].y, blocks[32].width, blocks[32].height);
                
                g.fillRect(blocks[33].x, blocks[33].y, blocks[33].width, blocks[33].height);
                
                g.fillRect(blocks[34].x, blocks[34].y, blocks[34].width, blocks[34].height);
                
                g.fillRect(blocks[35].x, blocks[35].y, blocks[35].width, blocks[35].height);
                
                g.fillRect(blocks[36].x, blocks[36].y, blocks[36].width, blocks[36].height);
                
                g.fillRect(blocks[37].x, blocks[37].y, blocks[37].width, blocks[37].height);
                
                g.fillRect(blocks[38].x, blocks[38].y, blocks[38].width, blocks[38].height);
                
                g.fillRect(blocks[39].x, blocks[39].y, blocks[39].width, blocks[39].height);
                
                g.fillRect(blocks[40].x, blocks[40].y, blocks[40].width, blocks[40].height);
                
                g.fillRect(blocks[41].x, blocks[41].y, blocks[41].width, blocks[41].height);
                
                g.fillRect(blocks[42].x, blocks[42].y, blocks[42].width, blocks[42].height);
                
                g.fillRect(blocks[43].x, blocks[43].y, blocks[43].width, blocks[43].height);
                
                g.fillRect(blocks[44].x, blocks[44].y, blocks[44].width, blocks[44].height);
                
                g.fillRect(blocks[45].x, blocks[45].y, blocks[45].width, blocks[45].height);
                
                g.fillRect(blocks[46].x, blocks[46].y, blocks[46].width, blocks[46].height);
                
                g.fillRect(blocks[47].x, blocks[47].y, blocks[47].width, blocks[47].height);
                
                g.fillRect(blocks[48].x, blocks[48].y, blocks[48].width, blocks[48].height);
                
                g.fillRect(blocks[49].x, blocks[49].y, blocks[49].width, blocks[49].height);
                
                g.fillRect(blocks[50].x, blocks[50].y, blocks[50].width, blocks[50].height);
                
                g.fillRect(blocks[51].x, blocks[51].y, blocks[51].width, blocks[51].height);
                
                g.fillRect(blocks[52].x, blocks[52].y, blocks[52].width, blocks[52].height);
                
                g.fillRect(blocks[53].x, blocks[53].y, blocks[53].width, blocks[53].height);
                
                g.fillRect(blocks[54].x, blocks[54].y, blocks[54].width, blocks[54].height);
                
                g.fillRect(blocks[55].x, blocks[55].y, blocks[55].width, blocks[55].height);
                
                g.setColor(opacblack);
                
                g.fillRect(blocks[56].x, blocks[56].y, blocks[56].width, blocks[56].height);
                
                g.fillRect(blocks[57].x, blocks[57].y, blocks[57].width, blocks[57].height);
                
                g.fillRect(blocks[58].x, blocks[58].y, blocks[58].width, blocks[58].height);
                
                g.fillRect(blocks[59].x, blocks[59].y, blocks[59].width, blocks[59].height);
                
                g.fillRect(blocks[60].x, blocks[60].y, blocks[60].width, blocks[60].height);
                
                g.fillRect(blocks[61].x, blocks[61].y, blocks[61].width, blocks[61].height);
                
                g.fillRect(blocks[62].x, blocks[62].y, blocks[62].width, blocks[62].height);
                
                g.fillRect(blocks[63].x, blocks[63].y, blocks[63].width, blocks[63].height);
                
                g.fillRect(blocks[64].x, blocks[64].y, blocks[64].width, blocks[64].height);
                
                g.fillRect(blocks[65].x, blocks[65].y, blocks[65].width, blocks[65].height);
                
                g.fillRect(blocks[66].x, blocks[66].y, blocks[66].width, blocks[66].height);
                
                g.fillRect(blocks[67].x, blocks[67].y, blocks[67].width, blocks[67].height);
                
                g.fillRect(blocks[68].x, blocks[68].y, blocks[68].width, blocks[68].height);
                
                g.fillRect(blocks[69].x, blocks[69].y, blocks[69].width, blocks[69].height);
                
                g.fillRect(blocks[70].x, blocks[70].y, blocks[70].width, blocks[70].height);
                
                g.fillRect(blocks[71].x, blocks[71].y, blocks[71].width, blocks[71].height);
                
                g.fillRect(blocks[72].x, blocks[72].y, blocks[72].width, blocks[72].height);
                
                g.fillRect(blocks[73].x, blocks[73].y, blocks[73].width, blocks[73].height);
                
                g.fillRect(blocks[74].x, blocks[74].y, blocks[74].width, blocks[74].height);
                
                g.fillRect(blocks[75].x, blocks[75].y, blocks[75].width, blocks[75].height);
                
                g.fillRect(blocks[76].x, blocks[76].y, blocks[76].width, blocks[76].height);
                
                g.fillRect(blocks[77].x, blocks[77].y, blocks[77].width, blocks[77].height);
                
                g.fillRect(blocks[78].x, blocks[78].y, blocks[78].width, blocks[78].height);
                
                g.fillRect(blocks[79].x, blocks[79].y, blocks[79].width, blocks[79].height);
                
                g.fillRect(blocks[80].x, blocks[80].y, blocks[80].width, blocks[80].height);
                
                g.fillRect(blocks[81].x, blocks[81].y, blocks[81].width, blocks[81].height);
                
                g.fillRect(blocks[82].x, blocks[82].y, blocks[82].width, blocks[82].height);
                
                g.fillRect(blocks[83].x, blocks[83].y, blocks[83].width, blocks[83].height);
                
                g.fillRect(blocks[84].x, blocks[84].y, blocks[84].width, blocks[84].height);
                
                g.fillRect(blocks[85].x, blocks[85].y, blocks[85].width, blocks[85].height);
                
                g.fillRect(blocks[86].x, blocks[86].y, blocks[86].width, blocks[86].height);
                
                g.fillRect(blocks[87].x, blocks[87].y, blocks[87].width, blocks[87].height);
                
                g.fillRect(blocks[88].x, blocks[88].y, blocks[88].width, blocks[88].height);
                
                g.fillRect(blocks[89].x, blocks[89].y, blocks[89].width, blocks[89].height);
                
                g.fillRect(blocks[90].x, blocks[90].y, blocks[90].width, blocks[90].height);
                
                g.fillRect(blocks[91].x, blocks[91].y, blocks[91].width, blocks[91].height);
                
                g.fillRect(blocks[92].x, blocks[92].y, blocks[92].width, blocks[92].height);
                
                g.fillRect(blocks[93].x, blocks[93].y, blocks[93].width, blocks[93].height);
                
                g.fillRect(blocks[94].x, blocks[94].y, blocks[94].width, blocks[94].height);
                
                g.fillRect(blocks[95].x, blocks[95].y, blocks[95].width, blocks[95].height);
                
                g.fillRect(blocks[96].x, blocks[96].y, blocks[96].width, blocks[96].height);
                
                g.fillRect(blocks[97].x, blocks[97].y, blocks[97].width, blocks[97].height);
                
                g.fillRect(blocks[98].x, blocks[98].y, blocks[98].width, blocks[98].height);
                
                g.fillRect(blocks[99].x, blocks[99].y, blocks[99].width, blocks[99].height);
                
                g.fillRect(blocks[100].x, blocks[100].y, blocks[100].width, blocks[100].height);
                
                g.fillRect(blocks[101].x, blocks[101].y, blocks[101].width, blocks[101].height);
                
                g.fillRect(blocks[102].x, blocks[102].y, blocks[102].width, blocks[102].height);
                
                g.fillRect(blocks[103].x, blocks[103].y, blocks[103].width, blocks[103].height);
                
                g.fillRect(blocks[104].x, blocks[104].y, blocks[104].width, blocks[104].height);
                
                g.fillRect(blocks[105].x, blocks[105].y, blocks[105].width, blocks[105].height);
                
                g.fillRect(blocks[106].x, blocks[106].y, blocks[106].width, blocks[106].height);
                
                g.fillRect(blocks[107].x, blocks[107].y, blocks[107].width, blocks[107].height);
                
                g.fillRect(blocks[108].x, blocks[108].y, blocks[108].width, blocks[108].height);
                
                g.fillRect(blocks[109].x, blocks[109].y, blocks[109].width, blocks[109].height);
                
                g.fillRect(blocks[110].x, blocks[110].y, blocks[110].width, blocks[110].height);
                
                g.fillRect(blocks[111].x, blocks[111].y, blocks[111].width, blocks[111].height);
                
                g.fillRect(blocks[112].x, blocks[112].y, blocks[112].width, blocks[112].height);
                
                g.fillRect(blocks[113].x, blocks[113].y, blocks[113].width, blocks[113].height);
                
                g.fillRect(blocks[114].x, blocks[114].y, blocks[114].width, blocks[114].height);
                
                g.fillRect(blocks[115].x, blocks[115].y, blocks[115].width, blocks[115].height);
                
                g.fillRect(blocks[116].x, blocks[116].y, blocks[116].width, blocks[116].height);
                
                g.fillRect(blocks[117].x, blocks[117].y, blocks[117].width, blocks[117].height);
                
                g.fillRect(blocks[118].x, blocks[118].y, blocks[118].width, blocks[118].height);
                
                g.fillRect(blocks[119].x, blocks[119].y, blocks[119].width, blocks[119].height);
                
                g.fillRect(blocks[120].x, blocks[120].y, blocks[120].width, blocks[120].height);
                
                g.fillRect(blocks[121].x, blocks[121].y, blocks[121].width, blocks[121].height);
                
                g.fillRect(blocks[122].x, blocks[122].y, blocks[122].width, blocks[122].height);
                
                g.setColor(Color.YELLOW);
                
                g.fillRect(blocks[123].x, blocks[123].y, blocks[123].width, blocks[123].height);
                
                g.fillRect(blocks[124].x, blocks[124].y, blocks[124].width, blocks[124].height);
                
                g.fillRect(blocks[125].x, blocks[125].y, blocks[125].width, blocks[125].height);
                
                g.fillRect(blocks[126].x, blocks[126].y, blocks[126].width, blocks[126].height);
                
                g.fillRect(blocks[127].x, blocks[127].y, blocks[127].width, blocks[127].height);
                
                g.fillRect(blocks[128].x, blocks[128].y, blocks[128].width, blocks[128].height);
                
                g.fillRect(blocks[129].x, blocks[129].y, blocks[129].width, blocks[129].height);
                
                g.fillRect(blocks[130].x, blocks[130].y, blocks[130].width, blocks[130].height);
                
                g.fillRect(blocks[131].x, blocks[131].y, blocks[131].width, blocks[131].height);
                
                g.fillRect(blocks[132].x, blocks[132].y, blocks[132].width, blocks[132].height);
                
                g.fillRect(blocks[133].x, blocks[133].y, blocks[133].width, blocks[133].height);
                
                g.fillRect(blocks[134].x, blocks[134].y, blocks[134].width, blocks[134].height);
                
                g.fillRect(blocks[135].x, blocks[135].y, blocks[135].width, blocks[135].height);
                
                g.fillRect(blocks[136].x, blocks[136].y, blocks[136].width, blocks[136].height);
                
                g.fillRect(blocks[137].x, blocks[137].y, blocks[137].width, blocks[137].height);
                
                g.fillRect(blocks[138].x, blocks[138].y, blocks[138].width, blocks[138].height);
                
                g.fillRect(blocks[139].x, blocks[139].y, blocks[139].width, blocks[139].height);
                
                g.fillRect(blocks[140].x, blocks[140].y, blocks[140].width, blocks[140].height);
                
                g.fillRect(blocks[141].x, blocks[141].y, blocks[141].width, blocks[141].height);
                
                g.fillRect(blocks[142].x, blocks[142].y, blocks[142].width, blocks[142].height);
                
                g.fillRect(blocks[143].x, blocks[143].y, blocks[143].width, blocks[143].height);
                
                g.fillRect(blocks[144].x, blocks[144].y, blocks[144].width, blocks[144].height);
                
                g.fillRect(blocks[145].x, blocks[145].y, blocks[145].width, blocks[145].height);
                
                g.fillRect(blocks[146].x, blocks[146].y, blocks[146].width, blocks[146].height);
                
                g.fillRect(blocks[147].x, blocks[147].y, blocks[147].width, blocks[147].height);
                
                g.fillRect(blocks[148].x, blocks[148].y, blocks[148].width, blocks[148].height);
                
                g.fillRect(blocks[149].x, blocks[149].y, blocks[149].width, blocks[149].height);
                
                g.fillRect(blocks[150].x, blocks[150].y, blocks[150].width, blocks[150].height);
                
                g.fillRect(blocks[151].x, blocks[151].y, blocks[151].width, blocks[151].height);
                
                g.fillRect(blocks[152].x, blocks[152].y, blocks[152].width, blocks[152].height);
                
                g.fillRect(blocks[153].x, blocks[153].y, blocks[153].width, blocks[153].height);
                
                g.fillRect(blocks[154].x, blocks[154].y, blocks[154].width, blocks[154].height);
                
                g.fillRect(blocks[155].x, blocks[155].y, blocks[155].width, blocks[155].height);
                
                g.fillRect(blocks[156].x, blocks[156].y, blocks[156].width, blocks[156].height);
                
                g.fillRect(blocks[157].x, blocks[157].y, blocks[157].width, blocks[157].height);
                
                g.fillRect(blocks[158].x, blocks[158].y, blocks[158].width, blocks[158].height);
                
                g.fillRect(blocks[159].x, blocks[159].y, blocks[159].width, blocks[159].height);
                
                g.fillRect(blocks[160].x, blocks[160].y, blocks[160].width, blocks[160].height);
                
                g.fillRect(blocks[161].x, blocks[161].y, blocks[161].width, blocks[161].height);
                
                g.fillRect(blocks[162].x, blocks[162].y, blocks[162].width, blocks[162].height);
                
                g.fillRect(blocks[163].x, blocks[163].y, blocks[163].width, blocks[163].height);
                
                g.fillRect(blocks[164].x, blocks[164].y, blocks[164].width, blocks[164].height);
                
                g.fillRect(blocks[165].x, blocks[165].y, blocks[165].width, blocks[165].height);
                
                g.fillRect(blocks[166].x, blocks[166].y, blocks[166].width, blocks[166].height);
                
                g.fillRect(blocks[167].x, blocks[167].y, blocks[167].width, blocks[167].height);
                
                g.fillRect(blocks[168].x, blocks[168].y, blocks[168].width, blocks[168].height);
                
                g.fillRect(blocks[169].x, blocks[169].y, blocks[169].width, blocks[169].height);
                
                g.fillRect(blocks[170].x, blocks[170].y, blocks[170].width, blocks[170].height);
                
                g.fillRect(blocks[171].x, blocks[171].y, blocks[171].width, blocks[171].height);
                
                g.fillRect(blocks[172].x, blocks[172].y, blocks[172].width, blocks[172].height);
                
                g.fillRect(blocks[173].x, blocks[173].y, blocks[173].width, blocks[173].height);
                
                g.fillRect(blocks[174].x, blocks[174].y, blocks[174].width, blocks[174].height);
                
                g.fillRect(blocks[175].x, blocks[175].y, blocks[175].width, blocks[175].height);
                
                g.fillRect(blocks[176].x, blocks[176].y, blocks[176].width, blocks[176].height);
                
                g.fillRect(blocks[177].x, blocks[177].y, blocks[177].width, blocks[177].height);
                
                g.fillRect(blocks[178].x, blocks[178].y, blocks[178].width, blocks[178].height);
                
                g.fillRect(blocks[179].x, blocks[179].y, blocks[179].width, blocks[179].height);
                
                g.fillRect(blocks[180].x, blocks[180].y, blocks[180].width, blocks[180].height);
                
                g.fillRect(blocks[181].x, blocks[181].y, blocks[181].width, blocks[181].height);
                
                g.fillRect(blocks[182].x, blocks[182].y, blocks[182].width, blocks[182].height);
                
                g.fillRect(blocks[183].x, blocks[183].y, blocks[183].width, blocks[183].height);
                
                g.fillRect(blocks[184].x, blocks[184].y, blocks[184].width, blocks[184].height);
                
                g.fillRect(blocks[185].x, blocks[185].y, blocks[185].width, blocks[185].height);
                
                g.fillRect(blocks[186].x, blocks[186].y, blocks[186].width, blocks[186].height);
                
                g.fillRect(blocks[187].x, blocks[187].y, blocks[187].width, blocks[187].height);
                
                g.fillRect(blocks[188].x, blocks[188].y, blocks[188].width, blocks[188].height);
                
            }
            
        }
        
        g.setColor(Color.orange);
        g.fillRect(player2.x, player2.y, player2.width, player2.height);
        
        g.setColor(Color.black);
        g.fillArc(player.x, player.y, player.width, player.height, 125, 305);
        
        g.setColor(Color.blue);
        g.fillRect(leftPotal.x, leftPotal.y, leftPotal.width, leftPotal.height);
        
        g.fillRect(rightPotal.x, rightPotal.y, rightPotal.width, rightPotal.height);
        
        //live game score
        g.drawString("Score: " + collected, 410, 20);
        
        if (end) {
            
            g.setColor(Color.black);
            g.fillRect(0, 0, 1000, 1000);
            System.out.println("hi");
            
            g.setColor(Color.white);
            g.drawString("Game Over ghost wins", 450, 450);
            System.out.println("bye");
            
        } else if (collected == 66) {
            
            g.setColor(Color.black);
            g.fillRect(0, 0, 1000, 1000);
            System.out.println("hi");
            
            g.setColor(Color.white);
            g.drawString("Game Over PacMan wins", 450, 450);
            System.out.println("bye");
            
        }
        
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void setup() {
        
        // Any of your pre setup before the loop starts should go here
        
            //outside walls
            blocks[1] = new Rectangle (50, 30, 780, 10);
            
            blocks[2] = new Rectangle (50, 670, 790, 10);
            
            blocks[55] = new Rectangle (50, 30, 10, 200);
            
            blocks[3] = new Rectangle (830, 30, 10, 200);
            
            blocks[4] = new Rectangle (50, 420, 10, 250);
            
            blocks[5] = new Rectangle (830, 420, 10, 250);
            
            blocks[6] = new Rectangle (670, 300, 170, 10);
            
            blocks[7] = new Rectangle (670, 340, 170, 10);
            
            blocks[8] = new Rectangle (50, 300, 170, 10);
            
            blocks[9] = new Rectangle (50, 340, 170, 10);
            
            blocks[10] = new Rectangle (670, 230, 170, 10);
            
            blocks[11] = new Rectangle (670, 420, 170, 10);
            
            blocks[12] = new Rectangle (50, 230, 170, 10);
            
            blocks[13] = new Rectangle (50, 420, 170, 10);
            
            blocks[14] = new Rectangle (670, 230, 10, 80);
            
            blocks[15] = new Rectangle (670, 350, 10, 80);
            
            blocks[16] = new Rectangle (210, 230, 10, 80);
            
            blocks[17] = new Rectangle (210, 350, 10, 80);
            
            blocks[18] = new Rectangle (425, 30, 40, 90);
            
            // ghost cage
            blocks[19] = new Rectangle (315, 275, 110, 10);
            
            blocks[20] = new Rectangle (465, 275, 110, 10);
            
            blocks[21] = new Rectangle (310, 275, 10, 80);
            
            blocks[22] = new Rectangle (570, 275, 10, 80);
            
            blocks[23] = new Rectangle (310, 355, 270, 10);
            
            // ghost cage gate
            blocks[189] = new Rectangle (415, 280, 50, 2);
            
            // top left of maze
            blocks[25] = new Rectangle (90, 70, 130, 50);
            
            blocks[26] = new Rectangle (90, 150, 130, 50);
            
            blocks[27] = new Rectangle (250, 70, 145, 50);
            
            // top right of maze
            blocks[28] = new Rectangle (670, 70, 130, 50);
            
            blocks[29] = new Rectangle (670, 150, 130, 50);
            
            blocks[30] = new Rectangle (495, 70, 145, 50);
            
            // above ghost cage
            blocks[31] = new Rectangle (310, 150, 270, 35);
            
            blocks[32] = new Rectangle (425, 150, 40, 95);
            
            // left of ghost cage
            blocks[33] = new Rectangle (250, 150, 30, 160);
            
            blocks[34] = new Rectangle (250, 215, 145, 30);
            
            blocks[35] = new Rectangle (250, 340, 30, 90);
            
            // right of ghost cage
            blocks[36] = new Rectangle (610, 150, 30, 160);
            
            blocks[37] = new Rectangle (495, 215, 145, 30);
            
            blocks[38] = new Rectangle (610, 340, 30, 90);
            
            // below ghost cage
            blocks[39] = new Rectangle (310, 395, 270, 35);
            
            blocks[40] = new Rectangle (420, 405, 50, 90);
            
            // bottem middle
            blocks[41] = new Rectangle (310, 525, 270, 50);
            
            blocks[42] = new Rectangle (420, 525, 50, 115);
            
            // bottem left
            blocks[43] = new Rectangle (90, 460, 130, 35);
            
            blocks[44] = new Rectangle (180, 460, 40, 115);
            
            blocks[45] = new Rectangle (250, 460, 140, 35);
            
            blocks[46] = new Rectangle (250, 525, 30, 100);
            
            blocks[47] = new Rectangle (90, 605, 300, 35);
            
            blocks[48] = new Rectangle (50, 525, 100, 50);
            
            // bottem right
            blocks[49] = new Rectangle (670, 460, 130, 35);
            
            blocks[50] = new Rectangle (670, 460, 40, 115);
            
            blocks[51] = new Rectangle (500, 460, 140, 35);
            
            blocks[52] = new Rectangle (610, 525, 30, 100);
            
            blocks[53] = new Rectangle (500, 605, 300, 35);
            
            blocks[54] = new Rectangle (740, 525, 100, 50);
            
            // intercect points
            blocks[56] = new Rectangle (60, 40, 30, 30);
            
            blocks[57] = new Rectangle (220, 40, 30, 30);
            
            blocks[58] = new Rectangle (395, 40, 30, 30);
            
            blocks[59] = new Rectangle (465, 40, 30, 30);
            
            blocks[60] = new Rectangle (640, 40, 30, 30);
            
            blocks[61] = new Rectangle (800, 40, 30, 30);
            
            blocks[62] = new Rectangle (60, 120, 30, 30);
            
            blocks[63] = new Rectangle (220, 120, 30, 30);
            
            blocks[64] = new Rectangle (220, 120, 30, 30);
            
            blocks[65] = new Rectangle (395, 120, 30, 30);
            
            blocks[66] = new Rectangle (465, 120, 30, 30);
            
            blocks[67] = new Rectangle (640, 120, 30, 20);
            
            blocks[68] = new Rectangle (640, 120, 30, 30);
            
            blocks[69] = new Rectangle (800, 120, 30, 30);
            
            blocks[70] = new Rectangle (280, 120, 30, 30);
            
            blocks[71] = new Rectangle (580, 185, 30, 30);
            
            blocks[72] = new Rectangle (280, 185, 30, 30);
            
            blocks[73] = new Rectangle (465, 185, 30, 30);
            
            blocks[74] = new Rectangle (395, 185, 30, 30);
            
            blocks[75] = new Rectangle (465, 245, 30, 30);
            
            blocks[76] = new Rectangle (395, 245, 30, 30);
            
            blocks[77] = new Rectangle (60, 200, 30, 30);
            
            blocks[78] = new Rectangle (220, 200, 30, 30);
            
            blocks[79] = new Rectangle (640, 200, 30, 30);
            
            blocks[80] = new Rectangle (800, 200, 30, 30);
            
            blocks[81] = new Rectangle (220, 310, 30, 30);
            
            blocks[82] = new Rectangle (280, 245, 30, 30);
            
            blocks[83] = new Rectangle (280, 310, 30, 30);

            blocks[84] = new Rectangle (580, 245, 30, 30);
            
            blocks[85] = new Rectangle (580, 310, 30, 30);
            
            blocks[86] = new Rectangle (640, 310, 30, 30);
            
            blocks[87] = new Rectangle (220, 430, 30, 30);
            
            blocks[88] = new Rectangle (280, 365, 30, 30);
            
            blocks[89] = new Rectangle (280, 430, 30, 30);
            
            blocks[90] = new Rectangle (640, 430, 30, 30);
            
            blocks[91] = new Rectangle (580, 365, 30, 30);
            
            blocks[92] = new Rectangle (580, 430, 30, 30);
            
            blocks[93] = new Rectangle (390, 430, 30, 30);
            
            blocks[94] = new Rectangle (470, 430, 30, 30);
            
            blocks[95] = new Rectangle (60, 430, 30, 30);
            
            blocks[96] = new Rectangle (60, 495, 30, 30);
            
            blocks[97] = new Rectangle (150, 495, 30, 30);
            
            blocks[98] = new Rectangle (220, 495, 30, 30);
            
            blocks[99] = new Rectangle (280, 495, 30, 30);
            
            blocks[100] = new Rectangle (60, 575, 30, 30);
            
            blocks[101] = new Rectangle (150, 575, 30, 30);
            
            blocks[102] = new Rectangle (220, 575, 30, 30);
            
            blocks[103] = new Rectangle (280, 575, 30, 30);
            
            blocks[104] = new Rectangle (60, 640, 30, 30);
            
            blocks[105] = new Rectangle (150, 640, 30, 30);
            
            blocks[106] = new Rectangle (220, 640, 30, 30);
            
            blocks[107] = new Rectangle (390, 640, 30, 30);
            
            blocks[108] = new Rectangle (390, 495, 30, 30);
            
            blocks[109] = new Rectangle (390, 575, 30, 30);
            
            blocks[110] = new Rectangle (470, 575, 30, 30);
            
            blocks[111] = new Rectangle (580, 575, 30, 30);
            
            blocks[112] = new Rectangle (640, 575, 30, 30);
            
            blocks[113] = new Rectangle (710, 575, 30, 30);
            
            blocks[114] = new Rectangle (470, 640, 30, 30);
            
            blocks[115] = new Rectangle (640, 495, 30, 30);
            
            blocks[116] = new Rectangle (710, 495, 30, 30);
            
            blocks[117] = new Rectangle (800, 640, 30, 30);
            
            blocks[118] = new Rectangle (800, 495, 30, 30);
            
            blocks[119] = new Rectangle (800, 575, 30, 30);
            
            blocks[120] = new Rectangle (580, 495, 30, 30);
            
            blocks[121] = new Rectangle (470, 495, 30, 30);
            
            blocks[122] = new Rectangle (800, 430, 30, 30);
            
            // pac pelets
            blocks[123] = new Rectangle (70, 50, 10, 10);
            
            blocks[124] = new Rectangle (230, 50, 10, 10);
            
            blocks[125] = new Rectangle (405, 50, 10, 10);
            
            blocks[126] = new Rectangle (475, 50, 10, 10);
            
            blocks[127] = new Rectangle (650, 50, 10, 10);
            
            blocks[128] = new Rectangle (810, 50, 10, 10);
            
            blocks[129] = new Rectangle (70, 130, 10, 10);
            
            blocks[130] = new Rectangle (230, 130, 10, 10);
            
            blocks[131] = new Rectangle (405, 130, 10, 10);
            
            blocks[132] = new Rectangle (475, 130, 10, 10);
            
            blocks[133] = new Rectangle (650, 130, 10, 10);
            
            blocks[134] = new Rectangle (810, 130, 10, 10);
            
            blocks[135] = new Rectangle (290, 130, 10, 10);
            
            blocks[136] = new Rectangle (590, 195, 10, 10);
            
            blocks[137] = new Rectangle (290, 195, 10, 10);
            
            blocks[138] = new Rectangle (475, 195, 10, 10);
            
            blocks[139] = new Rectangle (405, 195, 10, 10);
            
            blocks[140] = new Rectangle (475, 255, 10, 10);
            
            blocks[141] = new Rectangle (405, 255, 10, 10);
            
            blocks[142] = new Rectangle (70, 210, 10, 10);
            
            blocks[143] = new Rectangle (230, 210, 10, 10);
            
            blocks[144] = new Rectangle (650, 210, 10, 10);
            
            blocks[145] = new Rectangle (810, 210, 10, 10);
            
            // move 10 down and 10 to the left
            blocks[146] = new Rectangle (230, 320, 10, 10);
            
            blocks[148] = new Rectangle (290, 320, 10, 10);
            
            blocks[147] = new Rectangle (290, 255, 10, 10);
            
            blocks[149] = new Rectangle (590, 255, 10, 10);
            
            blocks[150] = new Rectangle (590, 320, 10, 10);
            
            blocks[151] = new Rectangle (650, 320, 10, 10);
            
            blocks[152] = new Rectangle (230, 440, 10, 10);
            
            blocks[154] = new Rectangle (290, 440, 10, 10);
            
            blocks[155] = new Rectangle (650, 440, 10, 10);
            
            blocks[157] = new Rectangle (590, 440, 10, 10);
            
            blocks[158] = new Rectangle (400, 440, 10, 10);
            
            blocks[159] = new Rectangle (480, 440, 10, 10);
            
            blocks[160] = new Rectangle (70, 440, 10, 10);
            
            blocks[153] = new Rectangle (290, 375, 10, 10);
            
            blocks[156] = new Rectangle (590, 375, 10, 10);
            
            blocks[161] = new Rectangle (70, 505, 10, 10);
            
            blocks[162] = new Rectangle (160, 505, 10, 10);
            
            blocks[163] = new Rectangle (230, 505, 10, 10);
            
            blocks[164] = new Rectangle (290, 505, 10, 10);
            
            blocks[165] = new Rectangle (70, 585, 10, 10);
            
            blocks[166] = new Rectangle (160, 585, 10, 10);
            
            blocks[167] = new Rectangle (230, 585, 10, 10);
            
            blocks[168] = new Rectangle (290, 585, 10, 10);
            
            blocks[169] = new Rectangle (290, 585, 10, 10);
            
            blocks[170] = new Rectangle (70, 650, 10, 10);
            
            blocks[171] = new Rectangle (160, 650, 10, 10);
            
            blocks[172] = new Rectangle (230, 650, 10, 10);
            
            blocks[173] = new Rectangle (400, 650, 10, 10);
            
            blocks[174] = new Rectangle (400, 505, 10, 10);
            
            blocks[175] = new Rectangle (400, 585, 10, 10);
            
            blocks[176] = new Rectangle (480, 585, 10, 10);
            
            blocks[177] = new Rectangle (590, 585, 10, 10);
            
            blocks[178] = new Rectangle (650, 585, 10, 10);
            
            blocks[179] = new Rectangle (720, 585, 10, 10);
            
            blocks[180] = new Rectangle (480, 650, 10, 10);
            
            blocks[183] = new Rectangle (810, 650, 10, 10);
            
            blocks[181] = new Rectangle (650, 505, 10, 10);
            
            blocks[182] = new Rectangle (720, 505, 10, 10);
            
            blocks[184] = new Rectangle (810, 505, 10, 10);
            
            blocks[186] = new Rectangle (590, 505, 10, 10);
            
            blocks[187] = new Rectangle (480, 505, 10, 10);
            
            blocks[188] = new Rectangle (810, 440, 10, 10);
            
            blocks[185] = new Rectangle (810, 585, 10, 10);
            
    }
            // ready to use as an intersect points

    // The main game loop
    // In here is where all the logic for my game will go
    public void loop1() {
        
        // move left, right, up and down
        if(left){
            
            System.out.println("left");
            
            player.x = player.x - speed;
            
        } 
        if(right){
            
            System.out.println("right");
            
            player.x = player.x + speed;
            
        }
        if(up){
            
            System.out.println("up");
            
            player.y = player.y - speed;
            
        }
        if(down){
            
            System.out.println("down");
            
            player.y = player.y + speed;
            
        }
        
        if (player.x < leftPotal.x) {
            
            System.out.println("right portal");
            
            player.x = 820;
            player.y = 317;
            
        }
        
        
        if (player.x > rightPotal.x) {
            
            System.out.println("left portal");
            
            player.x = 75;
            player.y = 317;
            
        }
        
        for (int i = 1; i < blocks.length; i++) {
            
            if(blocks[i] == null){
                
                continue;
                
            }
            if(i < 55 && blocks[i] != null && player.intersects(blocks[i])){
                
                if (up) {
                    
                    player.y = player.y + speed - 2;
                    
                } else if (down) {
                    
                    player.y = player.y - speed + 2;
                    
                } else if (left) {
                    
                    player.x = player.x + speed - 2;
                    
                } else if (right) {
                    
                    player.x = player.x - speed + 2;
                    
                }
                
                up = false;
                down = false;
                left = false;
                right = false;
                
            }
        
        }
        
        System.out.println(player.x +", "+ player.y);       
    }
    
    public void loop2() {
        
        // ghost move left, right, up and down
        if(left2){
            
            System.out.println("left");
            
            player2.x = player2.x - speed - 1;
            
        } 
        if(right2){
            
            System.out.println("right");
            
            player2.x = player2.x + speed + 1;
            
        }
        if(up2){
            
            System.out.println("up");
            
            player2.y = player2.y - speed - 1;
            
        }
        if(down2){
            
            System.out.println("down");
            
            player2.y = player2.y + speed + 1;
            
        }
        
        if (player2.x < leftPotal.x) {
            
            System.out.println("right portal");
            
            player2.x = 820;
            player2.y = 317;
            
        }
        
        
        if (player2.x > rightPotal.x) {
            
            System.out.println("left portal");
            
            player2.x = 75;
            player2.y = 317;
            
        }
        
        for (int i = 1; i < blocks.length; i++) {
            
            if(blocks[i] == null){
                
                continue;
                
            }
            if(i < 55 && blocks[i] != null && player2.intersects(blocks[i])){
                
                if (up2) {
                    
                    player2.y = player2.y + speed - 1;
                    
                } else if (down2) {
                    
                    player2.y = player2.y - speed + 1;
                    
                } else if (left2) {
                    
                    player2.x = player2.x + speed - 1;
                    
                } else if (right2) {
                    
                    player2.x = player2.x - speed + 1;
                    
                }
                
                up2 = false;
                down2 = false;
                left2 = false;
                right2 = false;
                
            }
        
        }
        
        for (int i = 1; i < blocks.length; i++) {
            
            if(blocks[i] == null){
                
                continue;
                
            }
            if(i > 122 && blocks[i] != null && player.intersects(blocks[i])){
                
                blocks[i].x = -10000;
                
                collected++;
                
                score = true;
                
            }
        
        }
        
        for (int i = 1; i < blocks.length; i++) {
            
            if(blocks[i] == null){
                
                continue;
                
            }
            if(player != null && player2.intersects(player)){
                
                end = true;
                
                up = false;
                down = false;
                left = false;
                right = false;
                
                up2 = false;
                down2 = false;
                left2 = false;
                right2 = false;
                
            }
        
        }
        
        System.out.println(player2.x +", "+ player2.y);
        
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
            if(key == KeyEvent.VK_A){
                
                down = false;
                left = true;
                up = false;
                right = false;
                
            } else if(key == KeyEvent.VK_D){
                
                down = false;
                left = false;
                up = false;
                right = true;
                
            } else if(key == KeyEvent.VK_W){
                
                down = false;
                left = false;
                up = true;
                right = false;
                
            } else if(key == KeyEvent.VK_S){
                
                down = true;
                left = false;
                up = false;
                right = false;
                
            } else if(key == KeyEvent.VK_SPACE){
                
                // player stoping
                down = false;
                left = false;
                up = false;
                right = false;
                
                // player 2 stoping
                down2 = false;
                left2 = false;
                up2 = false;
                right2 = false;
                
            }
            
            if(key == KeyEvent.VK_LEFT){
                
                down2 = false;
                left2 = true;
                up2 = false;
                right2 = false;
                
            } else if(key == KeyEvent.VK_RIGHT){
                
                down2 = false;
                left2 = false;
                up2 = false;
                right2 = true;
                
            } else if(key == KeyEvent.VK_UP){
                
                down2 = false;
                left2 = false;
                up2 = true;
                right2 = false;
                
            } else if(key == KeyEvent.VK_DOWN){
                
                down2 = true;
                left2 = false;
                up2 = false;
                right2 = false;
                
            } else if(key == KeyEvent.VK_R){
                
                player.x = 433;
                player.y = 368;
                
                player2.x = 435;
                player2.y = 308;
                
                // player stoping
                down = false;
                left = false;
                up = false;
                right = false;
                
                // player 2 stoping
                down2 = false;
                left2 = false;
                up2 = false;
                right2 = false;
                
            }
            
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        loop1();
        loop2();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        PacMan2 game = new PacMan2();
    }
}