package gr11.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;


/**
 *
 * @author gubas3504
 */
public abstract class hang_man1  implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel = new JPanel();
  JTextField textbox = new JTextField("input");
  JButton button = new JButton("press me");
  JTextField outputBox = new JTextField();
  JTextField outputBox2 = new JTextField();
  JTextField numberBox = new JTextField();
  JPanel drawing = new JPanel();
  
        //a list of words to be use
	static String[] wordList = {"abstraction", "microprocessor", "navigation", "optimization", "parameter", "patrick", "hotjava", "vertex", "unsigned", "primitives", "traditional"};
        
        //variable that will decide which and what word would be use
        static int randomThings; 
	
        //current word in use
        static String word;  
        
	//count mistakes, and 6 would end the game
        static int count = 0;  
        
        // Method to assemble our GUI
        // beginning of the game
        public void run(String[] args) {
            
            //init telling the game is not intended to end yet
            boolean endGame = false;  
		
            //declaring a char variable used for deciding which letter is being evaluated
            char now;  
		
            //declaring a variable use to taking user's input
            String response; 
		
            //take the first letter of response and make it the user input
            char letter;  
		
            //a list of user's input that is wrong
            String letterUsed; 
		
            //a blank sheet, if the letter is correct, the respected array will be filled in
            char[] wordChar; 
		
            //init scanner
            Scanner scan=new Scanner(System.in); 
            
            do{  // run the program until while is satisfied
		
		//pick a word
                wordChar = randomPickWord();          
                
		//clear the incorrect letter list
                letterUsed = ""; 
                
		//clear the response
                response = " "; 
            
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(1000,1000);
    // shows the window
    frame.setVisible(true);
    
    //put the panel in the frame
    frame.add(mainPanel);
    //disable the layout manager
    mainPanel.setLayout(null);
    
    //set the size and location of the textbox
    //setBounds (x, y, with, length)
    textbox.setBounds(400,300,100,50);
    //add it to the screen
    mainPanel.add(textbox);
    
    //set the size and location of the textbox
    //setBounds (x, y, with, length)
    outputBox2.setBounds(300,200,300,50);
    //add it to the screen
    mainPanel.add(outputBox2);
    
    // resize and position the button
    button.setBounds(200, 300, 100, 50);
    mainPanel.add(button);
    button.setBackground(Color.red);
    button.setBackground(Color.cyan);
    //add the listener
    button.addActionListener(this);
    button.setActionCommand("button");
    
    outputBox.setBounds(200, 400, 300, 100);
    mainPanel.add(outputBox);
    
    while(word.equals(String.valueOf(wordChar))==false && (response.toLowerCase().equals("exit")==false & count!=6)){			

	//draw the dancing man
        drawMan(count); 
	
        //create a blank line
        System.out.println(); 
	
        //checking to see if the letter is filled, also if it is not then create _
        for(int i=0;i<word.length();i++){ 
        
        
        now=word.charAt(i);
        
        
        //check to see if letter is already dec
        //this is one strike against the user
    if (word.replace(letter, (char)48)==word && letterUsed.replace(letter, (char)48)==letterUsed){ lard, if not add to a listcount=count+1; 
	letterUsed=letter+ " "+letterUsed;
            
            // get the text typed into the box
            String name = textbox.getText();
            // say hello in the output box
            outputBox2.setText("the letter " + name + " was wrong");
            
        } else {
            
            // get the text typed into the box
            String name = textbox.getText();
            // say hello in the output box
            outputBox.setText("the letter " + name + " was wrong"); 
            
        }

    private char[] randomPickWord() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void drawMan(int count) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
