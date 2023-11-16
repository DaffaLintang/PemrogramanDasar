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
public class Acara7_3 extends Frame{
        Label label;
        CFListener w = new CFListener(this);
        Acara7_3(String title){
            super(title);
            label = new Label("Close the frame");
            this.addWindowListener(w);
        }
        void launchFrame(){
            setSize(300,300);
            setVisible(true);
        }
        public static void main(String args[]){
            Acara7_3 cf = new Acara7_3("Close window Example");
            cf.launchFrame();
        }
        class CFListener extends WindowAdapter{
            Acara7_3 ref;
            CFListener(Acara7_3 ref){
                this.ref = ref;
            }
            public void windowClosing(WindowEvent e){
                ref.dispose();
                System.exit(1);
            }
        }
}
