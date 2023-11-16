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
public class forNama {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Mau input sampai berapa  kali: ");
        int inputan = input.nextInt();
        
        for(int i = 1; i <= inputan; i++){
            System.out.println("Hafizhsyah Daffa Lintang Sarodi ke-"+i);
        }
    }
}
