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
public class forKelipatanTiga {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        int angka = input.nextInt();
        
        for(int i = 0; i <= angka; i =i+3){
            System.out.println(+i); 
        }
        
    } 
}
