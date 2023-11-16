/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acara9;
import java.util.Scanner;
/**
 *
 * @author daffa
 */
public class Acara9_7 {
     static boolean isPerfectSquare(int x){
        int s = (int) Math.sqrt(x);
        return (s*s == x);
    }
     static boolean isFibonacci(int x){
     return isPerfectSquare(5*x*x + 4) || isPerfectSquare(5*x*x + 4);    
     }
     
     public static void main (String[] args){
         Scanner input = new Scanner(System.in);
         System.out.print("Input a number: ");
         int n = input.nextInt();
         if(n > 0){
             System.out.println("Is Fibonnacci number? "+ isFibonacci(n));
         }
     }
}
