/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hardCode;
import java.awt.*;
/**
 *
 * @author daffa
 */
public class menampilkanComplexLayout extends Frame {
    public menampilkanComplexLayout(){
        
    }
    public static void main(String args[]){
        menampilkanComplexLayout cl = new menampilkanComplexLayout();
        Panel panelNorth = new Panel();
        Panel panelCenter = new Panel();
        Panel panelSouth = new Panel();
        panelNorth.add(new Button("ONE"));
        panelNorth.add(new Button("TWO"));
        panelNorth.add(new Button("THREE"));
        panelCenter.setLayout(new GridLayout(4,4));
        panelCenter.add(new TextField("1st"));
        panelCenter.add(new TextField("2nd"));
        panelCenter.add(new TextField("3rd"));
        panelCenter.add(new TextField("4th"));
        panelSouth.setLayout(new BorderLayout());
        panelSouth.add(new Checkbox("Choose me!"), BorderLayout.CENTER);
        panelSouth.add(new Checkbox("I'm here!"), BorderLayout.EAST);
        panelSouth.add(new Checkbox("Pick me!"), BorderLayout.WEST);
        cl.add(panelNorth, BorderLayout.NORTH);
        cl.add(panelCenter, BorderLayout.CENTER);
        cl.add(panelSouth, BorderLayout.SOUTH);
        cl.setSize(300,300);
        cl.setVisible(true);
    }
}
