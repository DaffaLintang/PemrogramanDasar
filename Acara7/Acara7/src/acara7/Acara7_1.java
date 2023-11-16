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
public class Acara7_1 extends Frame implements MouseListener, MouseMotionListener {
    TextField tf;
    public Acara7_1(String title){
        super(title);
        tf = new TextField(60);
        addMouseListener(this);
    }
    public void launchFrame(){
//        Menambah komponen pada frame
        add(tf, BorderLayout.SOUTH);
        setSize(300,300);
        setVisible(true);
    }
    public void mouseClicked(MouseEvent me){
        String msg = "Mouse entered component.";
        tf.setText(msg);
    }
    public void mouseEntered(MouseEvent me){
        String msg = "Mouse entered component.";
        tf.setText(msg);
    }
    public void mouseExited(MouseEvent me){
        String msg = "Mouse exited component.";
        tf.setText(msg);
    }
    public void mousePressed(MouseEvent me){
        String msg = "Mouse pressed.";
        tf.setText(msg);
    }
    public void mouseReleased(MouseEvent me){
        String msg = "Mouse released";
        tf.setText(msg);
    }
    public void mouseDragged(MouseEvent me){
        String msg = "Mouse dragged at " + me.getX() + "," + me.getY();
        tf.setText(msg);    
    }
    public void mouseMoved(MouseEvent me){
        String msg = "Mouse moved at "+ me.getX() + "," + me.getY();
        tf.setText(msg);
    }
    public static void main(String args[]){
        Acara7_1 med = new Acara7_1("Mouse Events Demo");
        med.launchFrame();
    }
    }
