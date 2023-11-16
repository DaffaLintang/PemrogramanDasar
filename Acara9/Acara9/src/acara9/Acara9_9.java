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
public class Acara9_9 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Input number :");
        int input = in.nextInt();
        System.out.print("Input number 2: ");
        int input2 = in.nextInt();
        int  hasil = input + input2; 
       if(hasil > 0){
           System.out.println("Number is positive");
       } else if (hasil < 0){
           System.out.println("Number is negative");
       } else{
           System.out.println("Number is zero");
       }
        System.out.println(hasil);
    }
    
}
