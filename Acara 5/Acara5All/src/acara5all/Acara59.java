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
public class Acara59 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka pertama: ");
        int angkaPertama = input.nextInt();

        System.out.print("Masukkan angka kedua: ");
        int angkaKedua = input.nextInt();

        System.out.print("Masukkan angka ketiga: ");
        int angkaKetiga = input.nextInt();

        System.out.print("Masukkan angka keempat: ");
        int angkaKeempat = input.nextInt();

        System.out.print("Masukkan angka kelima: ");
        int angkaKelima = input.nextInt();
        
        int rataRata = (angkaPertama + angkaKedua + angkaKetiga + angkaKeempat + angkaKelima) / 5;
        System.out.println("rata-rata dari kelima angka: " + rataRata);
    }
    
}
