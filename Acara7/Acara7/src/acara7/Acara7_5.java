/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acara7;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author daffa
 */
public class Acara7_5 extends Frame{
    Label label;
    Acara7_5(String title){    
    super(title);
    label = new Label("Close the frame");
    this.addWindowListener(new WindowAdapter(){
       public void windowClosing(WindowEvent e){
           dispose();
           System.exit(1);
       } 
    });
    }
    void launchFrame(){
        setSize(300,300);
        setVisible(true);
    }
    public static void main(String args[]){
        Acara7_5 cf = new Acara7_5("Close Window Example");
        cf.launchFrame();
    }
}
