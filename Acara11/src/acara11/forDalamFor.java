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
public class forDalamFor {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan batasan: ");
        int batas = input.nextInt();
        for(int  i = 1; i<=batas;i++){
            for (int j = 1; j <=batas; j++) {
                System.out.print("("+i+" , "+j+")");
            }
            System.out.println("");
        }
    }
}
