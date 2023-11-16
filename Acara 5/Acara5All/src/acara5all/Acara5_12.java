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
public class Acara5_12 {
    public static void main(String[] String){
        Scanner input = new Scanner(System.in);
        System.out.print("Input weight in pounds: ");
        double weight = input.nextDouble();
        
        System.out.print("Input height in inches: ");
        double inches = input.nextDouble();
        
        double BMI = weight * 0.45359237 / (inches * 0.0254 * inches * 0.0254);
        System.out.println("Body mass Index is " + BMI +"\n");
    }
}
