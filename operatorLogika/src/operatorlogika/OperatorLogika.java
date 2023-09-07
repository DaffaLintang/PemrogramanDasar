/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operatorlogika;

/**
 *
 * @author daffa
 */
public class OperatorLogika {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        && operator
        System.out.println((5 > 3) && (8 > 3));
        System.out.println((5 > 3) && (8 < 5));
        
//        || operator
        System.out.println((5 < 3) || (8 > 5));        
        System.out.println((5 > 3) || (8 < 5));        
        System.out.println((5 < 3) || (8 < 5));        
        
//        ! operator
        System.out.println(!(5 == 3));
        System.out.println(!(5 > 3));
    }
    
}
