/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package farenhiettocelcius;
import java.util.Scanner;

/**
 *
 * @author daffa
 */
public class FarenhietToCelcius {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                Scanner scan;
        double F;
        double C;
        
        scan = new Scanner(System.in);
        System.out.println("Input a degree in Farenheit: ");
        F = scan.nextDouble();
        
        C = (5 *(F - 32)) / 9;
        
        System.out.println(F+ " degree Farenheit is equal to "+C+" in Celcius");

    }
    
}
