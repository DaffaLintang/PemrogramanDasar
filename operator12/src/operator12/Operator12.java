/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operator12;

/**
 *
 * @author daffa
 */
public class Operator12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int x = 25; 
        int y = 45; 
        int n = 35; 
        
        
        double result = Math.pow(x, n) % y;
        
        System.out.println("Input x : " +x);
        System.out.println("Input n : " +n);
        System.out.println("Input y : " +y);
        System.out.println("x^n % y = " +result);
    }
    
}
