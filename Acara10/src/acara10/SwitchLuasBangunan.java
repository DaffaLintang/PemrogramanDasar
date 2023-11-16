/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acara10;
import java.util.Scanner;
/**
 *
 * @author Daffa Lintang
 */
public class SwitchLuasBangunan {
    public static void main(String[] args){
        System.out.println("Pilihan: \n 1. Mengjitung luas persegi panjang \n 2. Mengjitung luas segitiga \n 1. Mengjitung luas lingkaran \n");
        
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan pilihan: ");
        int pilihan = input.nextInt();
        switch(pilihan){
            case 1:
                System.out.print("Masukkan Panjang: ");
                int p =  input.nextInt();
                System.out.print("Masukkan Lebar: ");
                int l =  input.nextInt();
                System.out.println("Luas persegi panjang tersebut adalah " + p*l);
                break;
            case 2:
                System.out.print("Masukkan alas: ");
                int a =  input.nextInt();
                System.out.print("Masukkan tinggi: ");
                int t =  input.nextInt();
                System.out.println("Luas segitiga tersebut adalah " + 0.5*a*t);
                break;
             case 3:
                System.out.print("Masukkan jari-jari: ");
                int r =  input.nextInt();
                System.out.println("Luas lingkaran tersebut adalah " + Math.PI*r*r);
                break;  
            default: System.out.println("Pilihan yang anda massukan salah");
        }
    }
}
