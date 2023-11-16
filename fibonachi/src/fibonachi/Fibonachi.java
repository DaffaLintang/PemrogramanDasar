/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fibonachi;
import java.util.Scanner;
/**
 *
 * @author daffa
 */
public class Fibonachi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nilai n: ");
        int n = input.nextInt();
        
        int a = 0;
        int b = 1;
        int i = 1;

        while (i <= n) {
            System.out.print(a + " ");
            int temp = a;
            a = b;
            b = temp + b;
            i++;
        }
    }
    
}
