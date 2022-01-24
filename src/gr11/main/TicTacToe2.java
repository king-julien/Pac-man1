package gr11.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author gubas3504
 */
public class TicTacToe2  implements Runnable, ActionListener{

  // Class Variables  
  
    JPanel mainPanel;
    JPanel gameGrid;
    JButton[] gridButtons = new JButton[9];
    JTextField instructions;
    
    static char[] board = new char [9];
    static char player = 'X';


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
    
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    
    gameGrid = new JPanel();
    gameGrid.setLayout(new GridLayout(3, 3));
    
    for (int i = 0; i < 9; i++) {
        
        gridButtons[i] = new JButton();
        
        gridButtons[i].addActionListener(this);
        
        gridButtons[i].setActionCommand(" " + i);
        
        gameGrid.add(gridButtons[i]);
        
    }
    
    mainPanel.add(gameGrid, BorderLayout.CENTER);
    
    instructions = new JTextField("Player x goes first");
    
    mainPanel.add(instructions, BorderLayout.PAGE_END);
    
    frame.add(mainPanel);
    
    clearBoard();
    
  }
  
  public void clearBoard () {
        
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
            gridButtons[i].setText(" ");
        }
        
    }
    
    public boolean placePeice (int spot) {
        
        if (spot < 0 || spot > 8 || !isFree(spot)) {
            
            instructions.setText("That spot is already taken try again");
            return false;
            
        }
        
        board[spot] = player;
        
        gridButtons[spot].setText(" " + player);
        
        return true;
        
    }
    
    public void changeTurns () {
        
        if (player == 'X') {
            
            player = 'O';
            
        } else {
            
            player = 'X';
            
        }
        
        instructions.setText(" " + player + "'s go!");
        
    }
    
    public boolean CheckForWin () {
        
        //check vertical and horizontal
        for (int i = 0; i < 3 ; i++) {
            
            if (board[3*i] == player && board[3*i+1] == player && board[3*i+2] == player) {
                
                return true;
                
            }
            
            if (board[i] == player && board[i+3] == player && board[i+6] == player) {
                
                return true;
                
            }
            
            
            
        }
        
        //check diagnols
        if (board[0] == player && board[4] == player && board[8] == player) {
            
            return true;
            
        }
        
        if (board[2] == player && board[4] == player && board[6] == player) {
            
            return true;
            
        }
        
        //noone has won
        return false;
        
        
    }
    
    public boolean CheckForTie () {
        
        for (int i = 0; i < board.length; i++) {
            
            //if we find a blank, can't be tie game
            if (board[i] == ' ') {
                
                return false;
                
            }
            
        }
        
        //every spot is fillec
        return true;
        
    }
    
    public boolean isFree (int spot) {
        
        if (board  [spot] == ' ') {
            
            return true;
            
        } else {
            
            return false;
            
        }
        
    }
  
  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
        
    int spot = Integer.parseInt(command);
    
    if (placePeice(spot)) {
        
        if (CheckForWin()) {
            
            instructions.setText("player ");
            
        } else if (CheckForTie()) {
            
            instructions.setText("player ");
            
        } else {
            
            changeTurns();
            
        }
        
    }
    
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    TicTacToe2  gui = new TicTacToe2 ();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}