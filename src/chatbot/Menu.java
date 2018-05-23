/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.util.Scanner;

/**
 *
 * @author jake
 */
public class Menu {
    
    private Scanner scan = new Scanner(System.in);
    private String userInput;
    private Main main = new Main();
    
    public void show() {
        System.out.println("CHAT PARA COMPRA DE OSOS");
        userInput = scan.nextLine();                    
        
        main.executeSentence(userInput);        
    } 
}
