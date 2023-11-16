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
public class Acara7_2 extends Frame implements WindowListener{
    Label label;
    Acara7_2(String title){
        super(title);
        label = new Label("Close the frame");
        this.addWindowListener(this);
    }
    void lauchFrame(){
        setSize(300,300);
        setVisible(true);
    }
    public void windowActivated(WindowEvent e){
    }
    public void windowClosed(WindowEvent e){
    }
    public void windowClosing(WindowEvent e){
        setVisible(false);
        System.exit(0);
    }
    public void windowDeactivated(WindowEvent e){
    }
    public void windowDeiconified(WindowEvent e){
    }
    public void windowIconified(WindowEvent e){
    }
    public void windowOpened(WindowEvent e){
    }
    public static void main(String args[]){
        Acara7_2 cf = new Acara7_2("Close Window Example");
        cf.lauchFrame();
    }
}
