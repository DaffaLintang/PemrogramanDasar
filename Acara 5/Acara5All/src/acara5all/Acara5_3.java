/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acara5all;
import java.util.Scanner;
/**
 *
 * @author daffa
 */
public class Acara5_3 {
    public static void main(String[] string){
      Scanner input = new Scanner(System.in);
        System.out.print("Input nummber of minutes: ");
        double min = input.nextDouble();
        
        int hari =(int)(min / 60 / 60 / 24) % 365;
        int jam = (int) (min /60 /60) % 24;
        int menit = (int) (min / 60) % 60;
        int detik = (int) (min) % 60;
        System.out.println(hari + " hari "+jam+" jam "+menit+" menit "+detik+" detik");
    }
}
