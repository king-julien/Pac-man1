package GUI_Game_Temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author gubas3504
 */
public class java  implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel = new JPanel();
  JTextField textbox = new JTextField("defualt text");
  JButton button = new JButton("press me");
  JTextField outputBox = new JTextField();
  JTextField numberBox1 = new JTextField();
  JTextField numberBox2 = new JTextField();


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
    
    //put the panel in the frame
    frame.add(mainPanel);
    //disable the layout manager
    mainPanel.setLayout(null);
    
    //set the size and location of the textbox
    //setBounds (x, y, with, length)
    textbox.setBounds(50,50,100,50);
    //add it to the screen
    mainPanel.add(textbox);
    
    // resize and position the button
    button.setBounds(50, 100, 100, 50);
    mainPanel.add(button);
    button.setBackground(Color.red);
    button.setBackground(Color.cyan);
    //add the listener
    button.addActionListener(this);
    button.setActionCommand("button");
    
    outputBox.setBounds(50, 200, 200, 50);
    mainPanel.add(outputBox);
    
    numberBox1.setBounds(150, 50, 100, 50);
    mainPanel.add(numberBox1);
    
    numberBox2.setBounds(150, 100, 100, 50);
    mainPanel.add(numberBox2);
    
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    // what command happened!
    if(command.equals("button")){
        // get the text typed into the box
        String name = textbox.getText();
        // say hello in the output box
        outputBox.setText("Hello " + name);
        
        //get the number from the textbox
        String numberWord = numberBox1.getText();
        // convert it to an actual number
        int number = Integer.parseInt(numberWord);
        double number2 = Double.parseDouble(numberWord);
        
        int product = numberBox1 * numberBox2;
        String oldText = outputBox.getText();
        outputBox.setText(oldText + " " + product);
        
    }
    
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    java  gui = new java ();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}