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
public class Acara5_13 {
    public static void main(String[] String){
        Scanner input = new Scanner(System.in);
        System.out.print("Input 1st integer: ");
        int firstInt = input.nextInt();
        System.out.print("Input 1st integer: ");
        int secondInt = input.nextInt();
        
        System.out.printf("Sum of two integers: %d%n", firstInt + secondInt);
        System.out.printf("Difference of two integers: %d%n", firstInt - secondInt);
        System.out.printf("Product of two integers: %d%n", firstInt * secondInt);
        System.out.printf("Average of two integers: %.2f%n",(double) (firstInt + secondInt)/2);
        System.out.printf("Distance of two integers: %d%n", Math.abs(firstInt - secondInt));
        System.out.printf("Distance of two integers: %d%n", Math.max(firstInt,secondInt));
        System.out.printf("Distance of two integers: %d%n", Math.min(firstInt,secondInt));
    }
}
