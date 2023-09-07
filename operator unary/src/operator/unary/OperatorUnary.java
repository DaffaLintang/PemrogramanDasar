/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operator.unary;

/**
 *
 * @author daffa
 */
public class OperatorUnary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 12, b = 12;
        int result1, result2;
        
        System.out.println("a = " +a);
        
//        increment operator
        result1 = ++a;
        System.out.println("After increment: " + result1);
        
        System.out.println("b = " +b);
        
//        decrement operator
        result2 = --b;
        System.out.println("After decrement: " +result2);
    }
    
}
