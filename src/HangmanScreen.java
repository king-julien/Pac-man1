import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author lamonta
 */
public class HangmanScreen  implements Runnable, ActionListener{

  // Class Variables  
  
BufferedImage img;
PicturePanel pic;

public HangmanScreen(){
    pic = new PicturePanel();
    img = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
    pic.setImage(img);
    
}

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("HangMan");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
    
    frame.add(pic);
    
  }
  
  public Graphics getGraphics(){
      return this.pic.getGraphics();
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

  }
  
  

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    HangmanScreen  gui = new HangmanScreen ();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
    
    Graphics g = gui.getGraphics();
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr11.main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author gubas3504
 */
    // Java Keywords
    public static final String[] WORDS = {
        "ABSTRACT", "ASSERT", "BOOLEAN", 
        "BREAK", "BYTE", "CASE", "CATCH"
    };
    
    public static final Random RANDOM = new Random();
	// Max errors before user lose
	public static final int max_errors = 6;
	// Word to find
	private String wordToFind;
	// Word found stored in a char array to show progression of user
	private char[] wordFound;
	private int nbErrors;
	// letters already entered by user
	private ArrayList<String> letters = new ArrayList<>();
        
    private String nextWordToFind() {
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }
    
    public void newGame() {
        nbErrors = 0;
        letters.clear();
        wordToFind = nextWordToFind();
        
        // word found initialization
        wordFound = new char[wordToFind.length()];
        
        for (int i = 0; i < wordFound.length; i++) {
        wordFound[i] = '_';
        }
    }
    
    public boolean wordFound() {
        return wordToFind.contentEquals(new String(wordFound));
    }
        //removes one letter from the word if it is the right letter
        private String wordFoundContent() {
        StringBuilder builder = new StringBuilder();
    
        for (int i = 0; i < wordFound.length; i++) {
        builder.append(wordFound[i]);
    
        if (i < wordFound.length - 1) {
        builder.append(" ");
        }
    }

    return builder.toString();
    }
    
    private void enter(String c) {
        // we update only if c has not already been entered
        if (!letters.contains(c)) {
        // we check if word to find contains c
        if (wordToFind.contains(c)) {
            // if so, we replace _ by the character c
            int index = wordToFind.indexOf(c);

        while (index >= 0) {
            wordFound[index] = c.charAt(0);
            index = wordToFind.indexOf(c, index + 1);
        }
        } else {
        // c not in the word => error
        nbErrors++;
        }

        // c is now a letter entered
        letters.add(c);
        }
    }
    
    public void play() {
        try (Scanner input = new Scanner(System.in)) {
            // we play while nbErrors is lower than max errors or user has found the word
            while (nbErrors < max_errors) {
                System.out.println("\nEnter a letter : ");
                // get next input from user
                String str = input.next();
                
                

            // we keep just first letter
            if (str.length() > 1) {
                str = str.substring(0, 1);
            }

            // update word found
            enter(str);
            
            //draws the hang_an
            
            
            // display current state
            System.out.println("\n" + wordFoundContent());
            
            // check if word is found
            if (wordFound()) {
                System.out.println("\nYou win!");
                break;
            } else {
                // we display nb tries remaining for the user
                System.out.println("\n=> Nb tries remaining : " + (max_errors - nbErrors));
            }
        }
        
            if (nbErrors == max_errors) {
                // user lost
                System.out.println("\nYou lose!");
                System.out.println("=> Word to find was : " + wordToFind);
            }
        }
    }
    
    public static void main(String[] args) {
        //starts the game
        System.out.println("Hangman Game");
        hang_man3 hangmanGame = new hang_man3();
        hangmanGame.newGame();
        hangmanGame.play();
    }
    
    
}

}