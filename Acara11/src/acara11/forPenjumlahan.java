/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acara11;
import java.util.Scanner;
/**
 *
 * @author Daffa Lintang
 */
public class forPenjumlahan {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        int j = input.nextInt();
        int jumlah = 0;
        for(int i = 1; i <= j; i++){
            jumlah = jumlah + i;
        }
        System.out.println("Hasil: "+ jumlah);
    }
}
