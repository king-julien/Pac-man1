package gr11.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author gubas3504
 */
public class PacManPelets_2  implements Runnable, ActionListener{

  // Class Variables  
  
  JTextField outputBox = new JTextField();

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
 
    
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    
    
    
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    PacManPelets_2  gui = new PacManPelets_2 ();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}