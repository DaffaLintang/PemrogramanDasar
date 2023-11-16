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
public class Acara5_16 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan jari-jari lingkaran: ");
        double jariJari = input.nextDouble();
        System.out.println("Keliling = "+ (2 * jariJari * Math.PI));
        System.out.println("Luas = "+ (Math.PI* jariJari * jariJari));
    }
}
