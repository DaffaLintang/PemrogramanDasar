/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package countdownroket;
import java.util.Scanner;
/**
 *
 * @author daffa
 */
public class CountDownRoket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nilai n: ");
        int n = input.nextInt();
        
        for (int i = n; i >= 1; i--) {
            System.out.println(i);
        }

        input.close();
    }
    
}
