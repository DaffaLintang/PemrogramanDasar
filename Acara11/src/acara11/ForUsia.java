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
public class ForUsia {
    public static void main(String[] args){    
        Scanner input = new Scanner(System.in);
        System.out.print("Mau input umur: ");
        int inputan = input.nextInt();
        
          for(int i = 1; i <= inputan; i++){
            if (i <= 20) {
                System.out.println(i+" Remaja");
            } else if (i <= 40) {
                System.out.println(i+" Dewasa");
            } else if (i <= 60) {
                System.out.println(i+" Orang Tua");
            } else if (i <= 80) {
                System.out.println(i+" Manula");
            } else if (i <= 100) {
                System.out.println(i+" Sepuh");
            } else {
                System.out.println(i+" Imortal");
            }
          }
        }
}
