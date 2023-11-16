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
public class Acara5_18 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("input the number of sides on the polygon: ");
        int n = input.nextInt();
        System.out.print("Input the length o one of the sides: ");
        double s = input.nextDouble();
        System.out.println("The area is: " + polygonArea(n,s));
    }
    
    public static double polygonArea(int n, double s){
       return (n*(s*s)/(4.0*Math.tan(Math.PI/n))); 
    }
}
