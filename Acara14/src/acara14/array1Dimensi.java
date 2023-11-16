/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acara14;

/**
 *
 * @author Daffa Lintang
 */
public class array1Dimensi {
    public static void main(String[] args){
        String makanan[] ={
         "Nasi Goreng", "Mie Ayam", "Pecel", "Lalapan Lele", "Telur Balado", "Indomie", "Nasi Padang","Bubur Ayam", "Siomay","Batagor"  
        };  
        int nomor = 1;
        for(int i = 0; i<5;i++, nomor++){
           
            System.out.println("Makanan "+nomor+". "+makanan[i]);
        }
    }
}
