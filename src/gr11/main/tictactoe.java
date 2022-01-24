/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr11.main;

import java.util.Scanner;

/**
 *
 * @author gubas3504
 */
public class tictactoe {
    
    static Scanner input = new Scanner(System.in);
    static char[] board = new char [9];
    static char player = 'X';
    
    public static void drawBoard() {
        
        System.out.println(board[0] + "|" + board[1] + "|" + board[2]);
        System.out.print("_ _ _ _ _");
        System.out.println(board[3] + "|" + board[4] + "|" + board[5]);
        System.out.print("_ _ _ _ _");
        System.out.println(board[6] + "|" + board[7] + "|" + board[8]);
        System.out.print("_ _ _ _ _");
        
    }
    
    public static void clearBoard () {
        
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
        
    }
    
    public static void placePeice () {
        
        System.out.print("It is" + player + " turn");
        System.out.print("Please pick a spot: (0-8)");
        int spot = input.nextInt();
        
        while (spot < 0 || spot > 8 || !isFree(spot)) {
            
            System.out.print("That spot is already taken try again");
            spot = input.nextInt();
            
        }
        
        board[spot] = player;
        
    }
    
    public static void changeTurns () {
        
        if (player == 'X') {
            
            player = 'O';
            
        } else {
            
            player = 'X';
            
        }
        
    }
    
    public static boolean CheckForWin () {
        
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
    
    public static boolean CheckForTie () {
        
        for (int i = 0; i < board.length; i++) {
            
            //if we find a blank, can't be tie game
            if (board[i] == ' ') {
                
                return false;
                
            }
            
        }
        
        //every spot is fillec
        return true;
        
    }
    
    public static boolean isFree (int spot) {
        
        if (board  [spot] == ' ') {
            
            return true;
            
        } else {
            
            return false;
            
        }
        
    }
    
    
    
    
    
    
    public static void main (String[] args) {
        
        
        clearBoard();
        
        while (true) {
            
            drawBoard();
            placePeice();
            Boolean Win = CheckForWin();
            Boolean Tie = CheckForTie();
            
            if (Win) {
                
                System.out.println("player " + player + " WINS!");
                break;
                
            } else if (Tie) {
                
                System.out.println("Tie game");
                break;
                
            } else {
                
                changeTurns();
                
            }
        
        
        
    }
    
}