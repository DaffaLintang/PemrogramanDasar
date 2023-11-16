/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acara14;

/**
 *
 * @author Daffa Lintang
 */
public class Array2Dimensi {
    public static void main (String[] args){
        int nilai[][]= {
            {90,10,44},{30,75,12},{89,55,77}  
        };
        for(int i = 0; i<=2;i++){
            for (int j = 0; j <= 2; j++) {
                System.out.println("Nilai["+i+"]["+j+"] = "+nilai[i][j]);
            }
        }
    }
}
