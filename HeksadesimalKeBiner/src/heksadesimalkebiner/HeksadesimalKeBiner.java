/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package heksadesimalkebiner;
import java.util.Scanner;

public class HeksadesimalKeBiner {

    
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner scan;
    int heksadesimalNumber;
    scan = new Scanner(System.in);
        System.out.println("Masukkan bilangan oktal :");
        heksadesimalNumber = Integer.parseInt(scan.nextLine(), 16);
        
     String heksa = Integer.toBinaryString(heksadesimalNumber);
        System.out.println("hasil konversi bilangan oktal ke biner :"+heksa);
       
    }
   }

