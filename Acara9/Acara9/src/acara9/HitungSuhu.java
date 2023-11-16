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
public class HitungSuhu {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan suhu badan: ");
        int suhu = input.nextInt();
        if(suhu > 38){
            System.out.println("Suhu "+ suhu +" Panas");
        } else if(suhu >= 36 ){
            System.out.println("Suhu "+ suhu +" Normal");
        } else {
            System.out.println("Suhu "+ suhu +" Dingin");
        }
    }
}
