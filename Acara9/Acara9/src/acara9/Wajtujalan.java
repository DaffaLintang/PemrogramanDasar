/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acara9;
import java.util.Scanner;
/**
 *
 * @author daffa
 */
public class Wajtujalan {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama jalan: ");
        String jalan = input.next();
       
        if("Riau".equals(jalan)){
            System.out.println("Waktu tempuh 10 menit");
        } else if("Kalimantan".equals(jalan)){
            System.out.println("Waktu tempuh 15 menit");
        } else {
            System.out.println("Jalan tidak ditemukan");
        }
    }
}
