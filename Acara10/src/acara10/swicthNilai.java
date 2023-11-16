/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acara10;
import java.util.Scanner;
/**
 *
 * @author Daffa Lintang
 */
public class swicthNilai {
    public static void main(String[] args){
        Scanner  input = new Scanner(System.in);

        System.out.println("Tahun : 1 - 3");
        System.out.println("Pelajaran : A - C");
        
        System.out.print("Pilih Tahun: ");
        int tahun = input.nextInt();
        System.out.print("Pilih Pelajaran: ");
        String pelajaran = input.next();
        
        switch(tahun){
            case 1: switch(pelajaran){
                case "A": System.out.println("Fisika 1");
                break;
                case "B": System.out.println("Biologi 1");
                break;
                case "C": System.out.println("Kimia 1");
                break;
                default: System.out.println("Pelajaran tidak ditemukan");
                break;
            }
            break;
            case 2: switch(pelajaran){
                case "A": System.out.println("Fisika 2");
                break;
                case "B": System.out.println("Biologi 2");
                break;
                case "C": System.out.println("Kimia 2");
                break;
                default: System.out.println("Pelajaran tidak ditemukan");
                break;
            }
            break;
            case 3: switch(pelajaran){
                case "A": System.out.println("Fisika 3");
                break;
                case "B": System.out.println("Biologi 3");
                break;
                case "C": System.out.println("Kimia 3");
                break;
                default: System.out.println("Pelajaran tidak ditemukan");
                break;
            }
            break;
            default: System.out.println("Tahun tidak ditemukan");
            break;
    }
       
    }
}
