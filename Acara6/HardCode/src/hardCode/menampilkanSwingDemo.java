/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hardCode;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author daffa
 */
public class menampilkanSwingDemo {
   JFrame frame;
   JPanel panel;
   JTextField textField;
   JButton button;
   Container contentPane;
   public menampilkanSwingDemo(){
       
   }
   void launchFrame(){
       frame = new JFrame("My First Swing Application");
       panel = new JPanel();
       textField = new JTextField("Default text");
       button = new JButton("Click Me!");
       contentPane = frame.getContentPane();
       panel.add(textField);
       panel.add(button);
       contentPane.add(panel, BorderLayout.CENTER);
       frame.pack();
       frame.setVisible(true);
   }
   public static void main(String args[]){
       menampilkanSwingDemo sd = new menampilkanSwingDemo();
       sd.launchFrame();
   }
}
