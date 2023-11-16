/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acara12;
import java.util.Scanner;
/**
 *
 * @author Daffa Lintang
 */
public class whilePengurangan {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        int x = input.nextInt();
        
        int i = -10;
        if(x>=i){
         while(x>=i){
            System.out.println(x);
            x--;   
        }
        }else {
            System.out.println("Error");
        }
    }
}
