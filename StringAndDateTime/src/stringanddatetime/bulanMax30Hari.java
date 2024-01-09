/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stringanddatetime;

import java.util.Calendar;

/**
 *
 * @author Daffa Lintang
 */
public class bulanMax30Hari {
    public static void main(String[] args){
        Calendar bulan = Calendar.getInstance();
        System.out.println(bulan.getActualMaximum(Calendar.DAY_OF_MONTH));
    }
}
