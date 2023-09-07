/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package program.java.untuk.menampilkan.kecepatan.dalam.meter.per.detik;
import java.util.Scanner;
/**
 *
 * @author daffa
 */
public class ProgramJavaUntukMenampilkanKecepatanDalamMeterPerDetik {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan;
        double meters;
        double hour;
        double minutes;
        double seconds;
        
        
        
        scan = new Scanner(System.in);
        System.out.println("Input distance in meters: ");
        meters = scan.nextDouble();
        
        scan = new Scanner(System.in);
        System.out.println("Input hour: ");
        hour = scan.nextDouble();
        
        scan = new Scanner(System.in);
        System.out.println("Input minutes: ");
        minutes = scan.nextDouble();
        
        scan = new Scanner(System.in);
        System.out.println("Input seconds: ");
        seconds = scan.nextDouble();
        
        double totalWaktu = (hour*3600) + (minutes*60) + seconds;
        
        double mPerSec = meters/totalWaktu ;
        double kmPerH = (meters * 3600) / (totalWaktu * 1000) ;
        double milesPerH = (meters * 3600 * 1) / (totalWaktu * 1000 * 1.609);
        
        System.out.println("Your speed in meters/second is " +mPerSec);
        System.out.println("Your speed in km/h is " +kmPerH);
        System.out.println("Your speed in miles/h is " +milesPerH);

    } 
    
}
