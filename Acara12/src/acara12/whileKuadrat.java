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
public class whileKuadrat {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        int x = input.nextInt();
        
        int i = 1;
        while(i<=x){
            System.out.println(i+". "+ i*5);
            i++;
        }
    }
}
