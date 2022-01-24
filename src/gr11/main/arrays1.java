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
public class arrays1 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.println("how many test marks?");
    int numTests = input.nextInt();
    
    int[] tests = new int[numTests];
    
    System.out.println("please ente each test mark");
    for (int i = 0; i < numTests; i++) {
        tests[i] = input.nextInt();
    }
    
    int find = input.nextInt();
    for (int i = 0; i < tests.length; i++) {
       
        if (find == tests[i]) {
        System.out.println(find + " is on index " + i);   
        }
    }
}
}
