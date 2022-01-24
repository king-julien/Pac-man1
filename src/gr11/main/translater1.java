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
public class translater1 {
    
    public static String toPigLatin(String word){
        
        // does it start with a vowel
        word = word.toUpperCase();
        
        if(word.startsWith("A") 
                || word.startsWith("E") 
                || word.startsWith("I") 
                || word.startsWith("O") 
                || word.startsWith("U")){
            
            return word + "WAY";
            
        }else{
            
            // go through each letter
            // start at 1 because 
            // don't need to look at the first letter
            
            for(int i = 1; i < word.length(); i++){
                
                // get the letter at position i
                char letter = word.charAt(i);
                
                String vowels = "AEIOU";
                
                // if the letter is in the vowels AEIOU
                // it must be one of those vowels
                if(vowels.contains("" + letter)){
                    
                    // separates the word into 2 chunks
                    String back = word.substring(i);
                    String front = word.substring(0,i);
                    return back + front + "AY";
                    
                }
            }
            
            // if it somehow manages no translation rules...
            return word;
            
        }
    }
    

    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter something to translate");
        String line = input.nextLine();
        String[] words = line.split(" ");
        
        // go through each word
        for(int i = 0; i < words.length; i++){
            
            // translate a single word
            String word = words[i];
            String translation = toPigLatin(word);
            
            // print the transation with a space
            System.out.print(translation + " ");
            
        }
        
        System.out.println("");
        
    }
    
}