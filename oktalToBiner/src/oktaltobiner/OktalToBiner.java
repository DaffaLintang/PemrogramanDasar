/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oktaltobiner;
import java.util.Scanner;

public class OktalToBiner {

    
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner scan;
    int oktalNumber;
    scan = new Scanner(System.in);
        System.out.println("Masukkan bilangan oktal :");
        oktalNumber = Integer.parseInt(scan.nextLine(), 8);
        
     String oktal = Integer.toBinaryString(oktalNumber);
        System.out.println("hasil konversi bilangan oktal ke biner :"+oktal);
    }
}
