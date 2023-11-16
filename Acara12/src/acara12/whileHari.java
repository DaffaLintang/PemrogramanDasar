/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acara12;
import java.util.Scanner;
/**
 *
 * @author Daffa Lintang
 */
public class whileHari {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        int x = input.nextInt();
        
        int i = 1;
        while(i<=x){
            switch(i){
                case 1: System.out.println(i+" Monday");
                break;
                case 2: System.out.println(i+" Tuesday");
                break;
                case 3: System.out.println(i+" Wednesday");
                break;
                case 4: System.out.println(i+" Thursday");
                break;
                case 5: System.out.println(i+" Friday");
                break;
                case 6: System.out.println(i+" Saturday");
                break;
                case 7: System.out.println(i+" Sunday");
                break;
                default: System.out.println(i+" Error");
                break;
        }
            i++;
    }
    }
}
