/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package acara5all;
import java.util.Scanner;
/**
 *
 * @author daffa
 */
public class Acara510 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan jumlah angka (n):");
        int jumlahAngka = input.nextInt();
        float total = 0;
        for(int i=1; i <= jumlahAngka; i++){
            System.out.println("Masukkan angka ("+i+"):");
            int angka = input.nextInt();
            total += angka;
        }
      
        
        float rataRata = total / jumlahAngka;
        
        System.out.println("Rata-rata: "+ rataRata);
        
        
    }
    
}
