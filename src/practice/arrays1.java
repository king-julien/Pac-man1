/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author gubas3504
 */
import java.util.Scanner;

/**
 *
 * @author gubas3504
 */
public class arrays1 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.println("how many variables are in the squence?");
    int numTests = input.nextInt();
    
    int[] tests = new int[numTests];
    
    System.out.println("please enter the begin of the squence and the end");
    for (int i = 0; i < numTests; i++) {
        tests[i] = input.nextInt();
    }
    
    System.out.println("number squence below");
    
    int sum1 = 1;
    for (int i = 6; i < 10; i++){
        
        int sum = i + 1;
        
        System.out.println(sum = i + 1);
        
    }
    
}
}
