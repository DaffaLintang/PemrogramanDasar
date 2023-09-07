/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operator.pkg10;

/**
 *
 * @author daffa
 */
public class Operator10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String binary [] = {
            " 0000 " ,
            " 0001 " ,
            " 0010 " ,
            " 0011 " ,
            " 0100 " ,
            " 0101 " ,
            " 0110 " ,
            "0111 ",
            " 1000 " ,
            " 1001 " ,
            " 1010 " ,
            " 1011 " ,
            " 1100 " ,
            " 1101 " ,
            " 1110 " ,
            " 1111 "
        };
        
        int a = 3; // 0011 dalam biner
        int b = 5; // 0101 dalam biner
        int c = a | b;
        int d = a & b;
        int e = a ^ b;
        int f = (~ a & b) | (a & ~b);
        int g = ~ a & 0x0f;
        System.out.println("a = " + binary[a]);
        System.out.println("b = " + binary[b]);
        System.out.println();
        System.out.println("OR: a | b = " +binary[c]);
        System.out.println("AND: a & b = " +binary[d]);
        System.out.println("XOR: a ^ b = " +binary[e]);
        System.out.println();
        System.out.println("~ a & b | a & b = " +binary[f]);
        System.out.println("~ a  & 0x0f = " +binary[g]);
        
    }
    
}
