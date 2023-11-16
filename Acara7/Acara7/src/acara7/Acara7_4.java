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
public class Acara7_4 extends Frame{
    Label label;
    Acara7_4(String title){
        super(title);
        label = new Label("Close the frame");
        this.addWindowListener(new CFListener());
    }
    void launchFrame(){
        setSize(300,300);
        setVisible(true);
    }
    class CFListener extends WindowAdapter {
        public void windowClosing(WindowEvent e){
            dispose();
            System.exit(1);
        }
    }
    public static void main(String args[]){
        Acara7_4 cf = new Acara7_4("Close Window Example");
        cf.launchFrame();
    }
}
