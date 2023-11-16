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
public class Acara5_17 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input a number(string): ");
        String str = input.nextLine();
        int result = Integer.parseInt(str);
        System.out.printf("The integer value is: %d", result);
    }
}
