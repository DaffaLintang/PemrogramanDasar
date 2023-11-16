/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hardCode;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author daffa
 */
public class JOptionDEmo {
   JOptionPane JOptionDEmo;
   
   public JOptionDEmo(){
       
   }
   void launchFrame(){
       JOptionDEmo = new JOptionPane();
       String name = JOptionDEmo.showInputDialog("Hi, what's yourname?");
       JOptionDEmo.showMessageDialog(null,"Nice to meet you, "+ name +".", "Greeting...", JOptionDEmo.PLAIN_MESSAGE);
       System.exit(0);
   }
   public static void main(String args[]){
new JOptionDEmo().launchFrame();
}

}
