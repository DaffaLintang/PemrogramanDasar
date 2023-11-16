/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package acara5all;
import java.util.Scanner;
/**
 *
 * @author daffa
 */
public class Input {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        System.out.print("Inputkan integer: ");
        int number = input.nextInt();
                
        System.out.println("Kamu meng-inputkan: "+number);
    }
    
}
