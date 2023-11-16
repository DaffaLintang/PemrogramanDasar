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
public class Acara5_14 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Input six non-negative digits: ");
        int digit = input.nextInt();
        int n1 = digit / 100000 % 10;
        int n2 = digit / 10000 % 10;
        int n3 = digit / 1000 % 10;
        int n4 = digit / 100 % 10;
        int n5 = digit / 10 % 10;
        int n6 = digit % 10;
        System.out.println(n1+ " "+ n2+ " "+ n3+ " "+ n4+ " "+ n5+ " "+ n6 );
    }
}
