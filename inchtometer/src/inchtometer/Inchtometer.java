/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inchtometer;
import java.util.Scanner;
/**
 *
 * @author daffa
 */
public class Inchtometer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan;
        double inch;
        scan = new Scanner(System.in);
        System.out.println("Input a value for inch: ");
        inch = Integer.parseInt(scan.nextLine());
        double meter = inch * 0.0254;
        
        
        System.out.println(+inch +" Inch is: " +meter);
    }
    
}
