/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stringanddatetime;

import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author Daffa Lintang
 */
public class TimeZoneDubai {
    public static void main(String[] args){
        Calendar calDubai = Calendar.getInstance();
        calDubai.setTimeZone(TimeZone.getTimeZone("Dubai"));
        System.out.println("Waktu di dubai: "+ calDubai.get(Calendar.HOUR_OF_DAY)+":"
                +calDubai.get(Calendar.MINUTE)+":"+calDubai.get(Calendar.SECOND));
    }
}
