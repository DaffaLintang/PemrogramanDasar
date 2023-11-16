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
public class Acara5_11 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
        System.out.print("Input first integer: ");
        int first = input.nextInt();
        
        System.out.print("Input second integer: ");
        int second = input.nextInt();
        
        boolean a = first != second;
        boolean b = first < second;
        boolean c = first <= second;
        System.out.println(first +" != " + second +" "+ a);
        System.out.println(first +" < " + second +" "+ b);
        System.out.println(first +" <= " + second +" "+ c);
 
        
    }
}
