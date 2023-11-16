/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acara5all;
import java.util.Scanner;
/**
 *
 * @author daffa
 */
public class Acara5_15 {
        public static void main(String[] args){
            int x,y,z;
            Scanner input = new Scanner(System.in);
            System.out.println("Input the first number: ");
            x = input.nextInt();
            System.out.println("Input the second number: ");
            y = input.nextInt();
            
            z = x;
            x = y;
            y = z;
            System.out.println("Swapped values are: "+ x +" and "+y);
        }
}
