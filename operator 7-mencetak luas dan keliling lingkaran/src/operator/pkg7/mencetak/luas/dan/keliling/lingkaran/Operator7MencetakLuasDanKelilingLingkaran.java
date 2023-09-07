    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operator.pkg7.mencetak.luas.dan.keliling.lingkaran;

/**
 *
 * @author daffa
 */
public class Operator7MencetakLuasDanKelilingLingkaran {

    /**
     * @param args the command line arguments
     */
    
    private static final double radius = 7;
    public static void main(String[] args) {
        // TODO code application logic here
        double keliling = 2 * Math.PI * radius;
        double luas = Math.PI * radius * radius;
        
        System.out.println("Jari-jari = " +radius);
        System.out.println("Keliling = " +keliling);
        System.out.println("Luas = " +luas);
    }
    
}
