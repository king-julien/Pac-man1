/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr11.main;

import com.sun.javafx.iio.ImageStorage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


/**
 *
 * @author lamonta
 */
public class HangmanScreen_buffered_image  implements Runnable, ActionListener{

  // Class Variables  
  
BufferedImage img;
PicturePanel pic;
JFrame frame;


public HangmanScreen_buffered_image(){
    pic = new PicturePanel();
    img = new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
    pic.setImage(img);
    
}

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
     frame = new JFrame("HangMan");
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
  
  public void repaint() {
      frame.repaint();
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    HangmanScreen_buffered_image  gui = new HangmanScreen_buffered_image ();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater((Runnable) gui);
    
    Graphics g = gui.getGraphics();
    
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, 800, 600);
    g.setColor(Color.RED);
    g.fillRect(100, 50, 100, 50);
  }
}