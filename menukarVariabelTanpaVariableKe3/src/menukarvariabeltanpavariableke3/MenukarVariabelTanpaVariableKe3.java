/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package menukarvariabeltanpavariableke3;

public class MenukarVariabelTanpaVariableKe3 {

 
    public static void main(String[] args) {
        // TODO code application logic here
        int a,b;
        a = 15;
        b = 27;
        
        System.out.println("Before swapping : a, b = "+a+"," + +b);
        
        a = a + b;
        b = a - b;
        a = a - b;
        
        System.out.println("After swapping : a, b = "+a+"," + +b);
    }
    
}
