/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr11.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 *
 * @author gubas3504
 */
public class hang_man3 {
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
        HangmanScreen_buffered_image  gui = new HangmanScreen_buffered_image ();
        Graphics g = gui.getGraphics();
        
       
        
    private String nextWordToFind() {
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }
    
    public void clearscreen () {
        g.setColor(Color.WHITE);
    g.fillRect(0, 0, 1000, 1000);
    }
    
    public void newGame() {
        SwingUtilities.invokeLater((Runnable) gui);
        
        //pole
        g.setColor(Color.BLACK);
        g.drawLine(250, 100, 250, 500);
        //top of the pole
        g.setColor(Color.BLACK);
        g.drawLine(250, 100, 400, 100);
        //place where the person is put together
        g.drawLine(400, 100, 400, 200);
        //platform
        g.drawLine(125, 500, 400, 500);
        //left platform foot
        g.drawLine(125, 500, 125, 525);
        //right platform foot
        g.drawLine(400, 500, 400, 525);
        
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
                if (max_errors - nbErrors == 5){
                    
                    //head
                    g.setColor(Color.BLACK);
                    g.drawOval(375, 200, 50, 50);
                    
                    //system outprint drawing
                    System.out.println("  _____");
                    System.out.println("  l   l ");
                    System.out.println("  l   o ");
                    System.out.println("  l     ");
                    System.out.println("  l     ");
                    System.out.println("__l__     ");
                    System.out.println("l   l     ");
                    
                } else if (max_errors - nbErrors == 4){
                    
                    //head
                    g.drawOval(375, 200, 50, 50);  
                    //body
                    g.drawLine(400, 250, 400, 325);
                    
                    //system outprint drawing
                    System.out.println("  _____");
                    System.out.println("  l   l ");
                    System.out.println("  l   o ");
                    System.out.println("  l   l ");
                    System.out.println("  l     ");
                    System.out.println("__l__     ");
                    System.out.println("l   l     ");
                    
                } else if (max_errors - nbErrors == 3){
                    
                    //head
                    g.drawOval(375, 200, 50, 50);  
                    //body
                    g.drawLine(400, 250, 400, 325); 
                    //left arm
                    g.drawLine(400, 250, 425, 315);
                    
                    //system outprint drawing
                    System.out.println("  _____");
                    System.out.println("  l   l ");
                    System.out.println("  l   o ");
                    System.out.println("  l  /l ");
                    System.out.println("  l     ");
                    System.out.println("__l__     ");
                    System.out.println("l   l     ");
                    
                } else if (max_errors - nbErrors == 2){
                    
                    //head
                    g.drawOval(375, 200, 50, 50);  
                    //body
                    g.drawLine(400, 250, 400, 325); 
                    //left arm
                    g.drawLine(400, 250, 425, 315);
                    //right arm
                    g.drawLine(400, 250, 375, 315);
                    
                    //system outprint drawing
                    System.out.println("  _____");
                    System.out.println("  l   l ");
                    System.out.println("  l   o ");
                    System.out.println("  l  /l\\  ");
                    System.out.println("  l     ");
                    System.out.println("__l__     ");
                    System.out.println("l   l     ");
                    
                } else if (max_errors - nbErrors == 1){
                    
                    //head
                    g.drawOval(375, 200, 50, 50);  
                    //body
                    g.drawLine(400, 250, 400, 325); 
                    //left arm
                    g.drawLine(400, 250, 425, 315);
                    //right arm
                    g.drawLine(400, 250, 375, 315);
                    //left leg
                    g.drawLine(400, 325, 425, 400);
                    
                    //system outprint drawing
                    System.out.println("  _____");
                    System.out.println("  l   l ");
                    System.out.println("  l   o ");
                    System.out.println("  l  /l\\ ");
                    System.out.println("  l  /    ");
                    System.out.println("__l__     ");
                    System.out.println("l   l     ");
                    
                } else if (max_errors - nbErrors == 0){
                    
                    //head
                    g.drawOval(375, 200, 50, 50);  
                    //body
                    g.drawLine(400, 250, 400, 325); 
                    //left arm
                    g.drawLine(400, 250, 425, 315);
                    //right arm
                    g.drawLine(400, 250, 375, 315);
                    //left leg
                    g.drawLine(400, 325, 425, 400);
                    //right leg
                    g.drawLine(400, 325, 375, 400);
                    
                    //system outprint drawing
                    System.out.println("  _____");
                    System.out.println("  l   l ");
                    System.out.println("  l   o ");
                    System.out.println("  l  /l\\ ");
                    System.out.println("  l  / \\ ");
                    System.out.println("__l__     ");
                    System.out.println("l   l     ");
                    
                }
            
                gui.repaint();
                
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
        System.out.println("  _____   ");
        System.out.println("  l   l   ");
        System.out.println("  l       ");
        System.out.println("  l       ");
        System.out.println("  l       ");
        System.out.println("__l__     ");
        System.out.println("l   l     ");
        System.out.println("_ _ _ _ _ _ _ _");
        hang_man3 hangmanGame = new hang_man3();
        hangmanGame.newGame();
        hangmanGame.play();
    }
}