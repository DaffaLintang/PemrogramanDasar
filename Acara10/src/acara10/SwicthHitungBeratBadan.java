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
public class SwicthHitungBeratBadan {
  public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      System.out.print("Massukan nilai berat badan: ");
      int x = input.nextInt();
      
      System.out.print("Masukkan pilihan: ");
      int pilihan = input.nextInt();
      
      switch(pilihan){
          case 1: if(x < 100 && x > 70){
              System.out.println("Obesitas 2");
          } else if (x <= 70){
              System.out.println("Obesitas 1");
          }
          break;
          case 2:
              if(x < 50 && x > 30){
              System.out.println("Ideal");
          } else if(x <= 30) {
              System.out.println("kurus");
          }
          break;
          default: System.out.println("Error");
      }
  }  
}
