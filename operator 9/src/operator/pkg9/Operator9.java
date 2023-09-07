/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operator.pkg9;

/**
 *
 * @author daffa
 */
public class Operator9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean a = true;
        boolean b = false;
        boolean c;
        
        c = a && b;
        System.out.println("true && false = " +c);
        
        c = a || b;
        System.out.println("true || false = " +c);
        
        System.out.println("Negasi, !true = " +!a); 
    }
    
}
