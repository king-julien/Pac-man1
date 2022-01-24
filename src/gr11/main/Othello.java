package gr11.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author gilbh1061
 */
public class Othello implements Runnable, ActionListener {

    // Class Variables  
    JPanel mainPanel;
    JPanel gameGrid;
    JPanel menu;
    JPanel textPanel;
    char[] board = new char[9];
    String player = "BLACK";
    boolean[][] freeSpot = new boolean[8][8];
    String[][] occupiedBy = new String[8][8];
    JButton[][] gridButtons = new JButton[8][8];
    JLabel instructions;
    JLabel scoreTracker;
    JButton pass;
    JButton surrender;
    JButton restart;
    Color darkGreen = new Color(1, 79, 22);
    int upCoor = 0;
    boolean checkUp = false;
    int downCoor = 0;
    boolean checkDown = false;
    int leftCoor = 0;
    boolean checkLeft = false;
    int rightCoor = 0;
    boolean checkRight = false;
    String topRight = new String();
    boolean checkTopRight = false;
    String bottomRight = new String();
    boolean checkBottomRight = false;
    String topLeft = new String();
    boolean checkTopLeft = false;
    String bottomLeft = new String();
    boolean checkBottomLeft = false;
    boolean go = false;
    int blackPoints = 0;
    int whitePoints = 0;
    boolean winTie = false;

    // Method to assemble our GUI
    public void run() {
        // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
        JFrame frame = new JFrame("Othell0");
        // Makes the X button close the program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // makes the windows 600 pixel wide by 600 pixels tall
        frame.setSize(660, 600);
        // shows the window
        frame.setVisible(true);

        // make the overall panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // grid for the buttons
        gameGrid = new JPanel();
        gameGrid.setLayout(new GridLayout(8, 8));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // make the button
                gridButtons[i][j] = new JButton();
                // set the actionListener
                gridButtons[i][j].addActionListener(this);
                gridButtons[i][j].setActionCommand(i + "_" + j);

                // set colour
                gridButtons[i][j].setBackground(darkGreen);

                // add it to the grid
                gameGrid.add(gridButtons[i][j]);
            }
        }

        // add gamegrid to main panel
        mainPanel.add(gameGrid, BorderLayout.CENTER);

        // make text panel
        textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(2, 1));

        // create the instruction text
        Font medium = new Font("SanSerif", Font.BOLD, 18);
        instructions = new JLabel("Black goes first");
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setFont(medium);
        textPanel.add(instructions);

        // create score tracker
        scoreTracker = new JLabel();
        scoreTracker.setHorizontalAlignment(JLabel.CENTER);
        scoreTracker.setFont(medium);
        textPanel.add(scoreTracker);

        // add text panel to main panel
        mainPanel.add(textPanel, BorderLayout.PAGE_END);

        // grid for the menu
        menu = new JPanel();
        menu.setLayout(new GridLayout(3, 1));

        // create the pass button
        Color grey = new Color(80, 81, 82);
        pass = new JButton("Pass");
        pass.setBackground(grey);
        pass.setForeground(Color.BLACK);
        pass.setFont(medium);
        pass.addActionListener(this);
        pass.setActionCommand("Pass");
        menu.add(pass);

        // create the surrender button
        surrender = new JButton("Surrender");
        surrender.setBackground(grey);
        surrender.setForeground(Color.BLACK);
        surrender.setFont(medium);
        surrender.addActionListener(this);
        surrender.setActionCommand("Surrender");
        menu.add(surrender);

        // create the restart button
        restart = new JButton("Restart");
        restart.setBackground(grey);
        restart.setForeground(Color.BLACK);
        restart.setFont(medium);
        restart.addActionListener(this);
        restart.setActionCommand("Restart");
        menu.add(restart);

        // add menu to mani panel
        mainPanel.add(menu, BorderLayout.LINE_END);

        // put the main panel in the frame
        frame.add(mainPanel);

        resetBoard();
    }

    public void resetBoard() {
        // clear board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                gridButtons[i][j].setBackground(darkGreen);
                freeSpot[i][j] = true;
                occupiedBy[i][j] = "NONE";
                gridButtons[i][j].setEnabled(true);
            }
        }

        // reset variables
        blackPoints = 2;
        whitePoints = 2;
        player = "BLACK";
        instructions.setText("Black goes first");
        scoreTracker.setText("Black = " + blackPoints + "     White = " + whitePoints);

        // set starting counters
        // top left black counter
        gridButtons[3][3].setBackground(Color.BLACK);
        freeSpot[3][3] = false;
        occupiedBy[3][3] = "BLACK";
        gridButtons[3][3].setEnabled(false);

        // top right white counter
        gridButtons[4][3].setBackground(Color.WHITE);
        freeSpot[4][3] = false;
        occupiedBy[4][3] = "WHITE";
        gridButtons[4][3].setEnabled(false);

        // bottom left white counter
        gridButtons[3][4].setBackground(Color.WHITE);
        freeSpot[3][4] = false;
        occupiedBy[3][4] = "WHITE";
        gridButtons[3][4].setEnabled(false);

        // bottom right black counter
        gridButtons[4][4].setBackground(Color.BLACK);
        freeSpot[4][4] = false;
        occupiedBy[4][4] = "BLACK";
        gridButtons[4][4].setEnabled(false);

    }

    public void placePiece(int row, int col) {
        // if spot is free...
        if (freeSpot[row][col]) {
            if (player.equals("WHITE")) {
                // place white piece
                gridButtons[row][col].setBackground(Color.WHITE);
                occupiedBy[row][col] = "WHITE";
                whitePoints++;
            } else if (player.equals("BLACK")) {
                // place black piece
                gridButtons[row][col].setBackground(Color.BLACK);
                occupiedBy[row][col] = "BLACK";
                blackPoints++;
            }
            // spot is now occupied
            gridButtons[row][col].setEnabled(false);
            freeSpot[row][col] = false;
        }
    }

    public boolean checkUp(int row, int col) {
        // clear variables
        upCoor = 0;
        boolean upCapture = false;

        // check column up
        // check there are pieces to capture
        if (!occupiedBy[row - 1][col].equals(player) && !occupiedBy[row - 1][col].equals("NONE")) {
            for (int i = row - 2; i >= 0; i--) {
                // if an end piece is found
                if (occupiedBy[i][col] == player) {
                    // record end piece row
                    upCoor = i;
                    return true;
                } else if (freeSpot[i][col]) {
                    // if there is an empty space...
                    return false;
                }
            }
        }
        return upCapture;
    }

    public boolean checkDown(int row, int col) {
        // clear variables
        downCoor = 0;
        boolean downCapture = false;

        // check column down
        // check there are pieces to capture
        if (!occupiedBy[row + 1][col].equals(player) && !occupiedBy[row + 1][col].equals("NONE")) {
            for (int i = row + 2; i <= 7; i++) {
                // if an end piece is found
                if (occupiedBy[i][col].equals(player)) {
                    // record end piece row
                    downCoor = i;
                    return true;
                } else if (freeSpot[i][col]) {
                    // if there is an empty space...
                    return false;
                }
            }
        }

        return downCapture;
    }

    public boolean checkLeft(int row, int col) {
        // clear variables
        leftCoor = 0;
        boolean leftCapture = false;

        // check row left
        // check there are pieces to capture
        if (!occupiedBy[row][col - 1].equals(player) && !occupiedBy[row][col - 1].equals("NONE")) {
            for (int i = col - 2; i >= 0; i--) {
                // if an end piece is found
                if (occupiedBy[row][i].equals(player)) {
                    // record end piece column
                    leftCoor = i;
                    return true;
                } else if (freeSpot[row][i]) {
                    // if there is an empty space...
                    return false;
                }
            }
        }
        return leftCapture;
    }

    public boolean checkRight(int row, int col) {
        // clear variables
        rightCoor = 0;
        boolean rightCapture = false;

        // check row right
        // check there are pieces to capture
        if (!occupiedBy[row][col + 1].equals(player) && !occupiedBy[row][col + 1].equals("NONE")) {
            for (int i = col + 2; i <= 7; i++) {
                // if an end piece is found
                if (occupiedBy[row][i].equals(player)) {
                    // record end piece column
                    rightCoor = i;
                    return true;
                } else if (freeSpot[row][i]) {
                    // if it is an empty space...
                    return false;
                }
            }
        }
        return rightCapture;
    }

    public boolean checkTopRight(int row, int col) {
        // clear variables
        topRight = "";
        boolean topRightCapture = false;

        // check diagonal top right
        // check there are pieces to capture
        if (!occupiedBy[row - 1][col + 1].equals(player) && !occupiedBy[row - 1][col + 1].equals("NONE")) {
            // set second coordinate to next piece
            int j = col + 2;
            for (int i = row - 2; i >= 0 && j <= 7; i--) {
                //if an end piece is found...
                if (occupiedBy[i][j].equals(player)) {
                    topRight = (i + "_" + j);
                    return true;
                } else if (freeSpot[i][j]) {
                    // if it is an empty space...
                    return false;
                } else if (freeSpot[i][j]) {
                    return false;
                }
                j++;
            }
        }
        return topRightCapture;
    }

    public boolean checkBottomRight(int row, int col) {
        // clear variables
        bottomRight = "";
        boolean bottomRightCapture = false;

        // check diagonal bottom right
        // check there are pieces to capture
        if (!occupiedBy[row + 1][col + 1].equals(player) && !occupiedBy[row + 1][col + 1].equals("NONE")) {
            // set second coordinate to next piece
            int j = col + 2;
            for (int i = row + 2; i <= 7 && j <= 7; i++) {
                // if end piece is found...
                if (occupiedBy[i][j].equals(player)) {
                    bottomRight = (i + "_" + j);
                    return true;
                } else if (freeSpot[i][j]) {
                    // if it is an empty space...
                    return false;
                }
                j++;
            }
        }
        return bottomRightCapture;
    }

    public boolean checkTopLeft(int row, int col) {
        // reset variables
        topLeft = "";
        boolean topLeftCapture = false;

        // check diagonal top left
        // check there are pieces to capture
        if (!occupiedBy[row - 1][col - 1].equals(player) && !occupiedBy[row - 1][col - 1].equals("NONE")) {
            // set second coordinate to next piece
            int j = col - 2;
            for (int i = row - 2; i >= 0 && j >= 0; i--) {
                // if end piece is found...
                if (occupiedBy[i][j].equals(player)) {
                    topLeft = (i + "_" + j);
                    return true;
                } else if (freeSpot[i][j]) {
                    // if spot is empty...
                    return false;
                }
                j--;
            }
        }
        return topLeftCapture;
    }

    public boolean checkBottomLeft(int row, int col) {
        // clear variables
        bottomLeft = "";
        boolean bottomLeftCapture = false;

        // check diagonal bottom left
        if (!occupiedBy[row + 1][col - 1].equals(player) && !occupiedBy[row + 1][col - 1].equals("NONE")) {
            int j = col - 2;
            for (int i = row + 2; j >= 0 && i <= 7; i++) {
                // if end piece is found...
                if (occupiedBy[i][j].equals(player)) {
                    bottomLeft = (i + "_" + j);
                    return true;
                } else if (freeSpot[i][j]) {
                    // if spot is empty...
                    return false;
                }
                j--;
            }
        }
        return bottomLeftCapture;
    }

    public void captureUpCounters(int row, int col) {
        // change colour and owner
        // repeat until reaches end piece
        for (int i = row - 1; i > upCoor; i--) {
            if (player.equals("BLACK")) {
                // player black...
                gridButtons[i][col].setBackground(Color.BLACK);
                occupiedBy[i][col] = "BLACK";
                blackPoints++;
                whitePoints--;
            } else {
                // player white...
                gridButtons[i][col].setBackground(Color.WHITE);
                occupiedBy[i][col] = "WHITE";
                whitePoints++;
                blackPoints--;
            }
        }
    }

    public void captureDownCounters(int row, int col) {
        // change colour and owner
        // repeat until reaches end piece
        for (int i = row + 1; i < downCoor; i++) {
            if (player.equals("BLACK")) {
                // player black...
                gridButtons[i][col].setBackground(Color.BLACK);
                occupiedBy[i][col] = "BLACK";
                blackPoints++;
                whitePoints--;
            } else {
                // player white...
                gridButtons[i][col].setBackground(Color.WHITE);
                occupiedBy[i][col] = "WHITE";
                whitePoints++;
                blackPoints--;
            }
        }
    }

    public void captureLeftCounters(int row, int col) {
        // change colour and owner
        // repeat until reaches end piece
        for (int i = col - 1; i > leftCoor; i--) {
            if (player.equals("BLACK")) {
                // player black...
                gridButtons[row][i].setBackground(Color.BLACK);
                occupiedBy[row][i] = "BLACK";
                blackPoints++;
                whitePoints--;
            } else {
                // player white...
                gridButtons[row][i].setBackground(Color.WHITE);
                occupiedBy[row][i] = "WHITE";
                whitePoints++;
                blackPoints--;
            }
        }
    }

    public void captureRightCounters(int row, int col) {
        // change colour and owner
        // repeat until reaches end piece
        for (int i = col + 1; i < rightCoor; i++) {
            if (player.equals("BLACK")) {
                // player black...
                gridButtons[row][i].setBackground(Color.BLACK);
                occupiedBy[row][i] = "BLACK";
                blackPoints++;
                whitePoints--;
            } else {
                // player white...
                gridButtons[row][i].setBackground(Color.WHITE);
                occupiedBy[row][i] = "WHITE";
                whitePoints++;
                blackPoints--;
            }
        }
    }

    public void captureTRightCounters(int row, int col) {
        // retrieve coordinates
        char a = topRight.charAt(0);
        int i = a - '0';
        col = col + 1;

        // change colour and owner
        // repeat until reaches end piece
        for (int k = row - 1; k > i; k--) {
            if (player.equals("BLACK")) {
                // player black...
                gridButtons[k][col].setBackground(Color.BLACK);
                occupiedBy[k][col] = "BLACK";
                blackPoints++;
                whitePoints--;
            } else {
                gridButtons[k][col].setBackground(Color.WHITE);
                occupiedBy[k][col] = "WHITE";
                whitePoints++;
                blackPoints--;
            }
            col++;
        }
    }

    public void captureBRightCounters(int row, int col) {
        // retrieve coordinates
        char a = bottomRight.charAt(0);
        int i = a - '0';
        col = col + 1;

        // change colour and owner
        // repeat until reaches end piece
        for (int j = row + 1; j < i; j++) {
            if (player.equals("BLACK")) {
                // player black...
                gridButtons[j][col].setBackground(Color.BLACK);
                occupiedBy[j][col] = "BLACK";
                blackPoints++;
                whitePoints--;
            } else {
                gridButtons[j][col].setBackground(Color.WHITE);
                occupiedBy[j][col] = "WHITE";
                whitePoints++;
                blackPoints--;
            }
            col++;
        }
    }

    public void captureTLeftCounters(int row, int col) {
        // retrieve coordinates
        char a = topLeft.charAt(0);
        int i = a - '0';
        col = col - 1;

        // change colour and owner
        // repeat until reaches end piece
        for (int k = row - 1; k > i; k--) {
            if (player.equals("BLACK")) {
                // player black...
                gridButtons[k][col].setBackground(Color.BLACK);
                occupiedBy[k][col] = "BLACK";
                blackPoints++;
                whitePoints--;
            } else {
                gridButtons[k][col].setBackground(Color.WHITE);
                occupiedBy[k][col] = "WHITE";
                whitePoints++;
                blackPoints--;
            }
            col--;
        }
    }

    public void captureBLeftCounters(int row, int col) {
        // retrieve coordinates
        char a = bottomLeft.charAt(0);
        int i = a - '0';
        col = col - 1;

        // change colour and owner
        // repeat until reaches end piece
        for (int k = row + 1; k < i; k++) {
            if (player.equals("BLACK")) {
                // player black...
                gridButtons[k][col].setBackground(Color.BLACK);
                occupiedBy[k][col] = "BLACK";
                blackPoints++;
                whitePoints--;
            } else {
                gridButtons[k][col].setBackground(Color.WHITE);
                occupiedBy[k][col] = "WHITE";
                whitePoints++;
                blackPoints--;
            }
            col--;
        }
    }

    public boolean detectWinOrTie() {
        // clear variables
        winTie = false;

        // is the board full?
        System.out.println("Method is running");
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (freeSpot[i][j]) {
                    System.out.println(i + ", " + j + "   " + freeSpot[i][j]);
                    System.out.println("");
                    return false;
                }
            }
        }

        // who wins?
        if (blackPoints > whitePoints) {
            instructions.setText("Black wins!!!");
        } else if (blackPoints < whitePoints) {
            instructions.setText("White wins!!!");
        } else {
            instructions.setText("Tie Game");
        }
        System.out.println("SUCCESSFUL!!!");
        return true;
    }

    public String changeTurn() {
        // switch player colour
        if (player.equals("BLACK")) {
            player = "WHITE";
            instructions.setText("It's White's turn");
            return player;
        } else if (player.equals("WHITE")) {
            player = "BLACK";
            instructions.setText("It's Black's turn");
            return player;
        }
        return player;
    }

    // method called when a button is pressed
    public void actionPerformed(ActionEvent e) {
        // get the command from the action
        String command = e.getActionCommand();

        // if there are no available moves...
        if (command.equals("Pass")) {
            // if player wishes to forfeit their turn...
            changeTurn();

        } else if (command.equals("Surrender")) {
            // if player wishes to surrender...

            // disable the board
            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j <= 7; j++) {
                    gridButtons[i][j].setEnabled(false);
                }
            }
            // declare winner
            if (player.equals("BLACK")) {
                instructions.setText("Black forfeits, and White wins!!!");
            } else {
                instructions.setText("White forfeits, and Black wins!!!");
            }

        } else if (command.equals("Restart")) {
            // if player wishes to restart...
            resetBoard();

        } else {
            // game logic

            // get the location of the button
            String location[] = command.split("_");
            char i = location[0].charAt(0);
            char j = location[1].charAt(0);
            int row = i - '0';
            int col = j - '0';

            // reset variables
            go = false;
            checkUp = false;
            checkDown = false;
            checkRight = false;
            checkLeft = false;

            // search for available capture
            // search up
            if (row >= 2) {
                checkUp = checkUp(row, col);
                if (checkUp) {
                    // capture pieces
                    go = true;
                    captureUpCounters(row, col);
                }
            }

            // search down
            if (row <= 5) {
                checkDown = checkDown(row, col);
                if (checkDown) {
                    // capture pieces
                    go = true;
                    captureDownCounters(row, col);
                }
            }

            // search left
            if (col >= 2) {
                checkLeft = checkLeft(row, col);
                if (checkLeft) {
                    // capture pieces
                    go = true;
                    captureLeftCounters(row, col);
                }
            }

            // search right
            if (col <= 5) {
                checkRight = checkRight(row, col);
                if (checkRight) {
                    // capture pieces
                    go = true;
                    captureRightCounters(row, col);
                }
            }

            // search top right
            if (col <= 5 && row >= 2) {
                checkTopRight = checkTopRight(row, col);
                if (checkTopRight) {
                    // capture pieces
                    go = true;
                    captureTRightCounters(row, col);
                }
            }

            // search bottom right
            if (col <= 5 && row <= 5) {
                checkBottomRight = checkBottomRight(row, col);
                if (checkBottomRight) {
                    // capture pieces
                    go = true;
                    captureBRightCounters(row, col);
                }
            }

            // search top left
            if (col >= 2 && row >= 2) {
                checkTopLeft = checkTopLeft(row, col);
                if (checkTopLeft) {
                    // capture pieces
                    go = true;
                    captureTLeftCounters(row, col);
                }
            }

            // search bottom left
            if (col >= 2 && row <= 5) {
                checkBottomLeft = checkBottomLeft(row, col);
                if (checkBottomLeft) {
                    // capture pieces
                    go = true;
                    captureBLeftCounters(row, col);
                }
            }

            // place piece and change turn
            if (go) {
                placePiece(row, col);
                winTie = detectWinOrTie();
                if (winTie) {
                } else {
                    changeTurn();
                }
                scoreTracker.setText("Black = " + blackPoints + "     White = " + whitePoints);
            }
        }
    }
    
    // Main method to start our program

    public static void main(String[] args) {
        // Creates an instance of our program
        Othello gui = new Othello();
        // Lets the computer know to start it in the event thread
        SwingUtilities.invokeLater(gui);

    }
}


