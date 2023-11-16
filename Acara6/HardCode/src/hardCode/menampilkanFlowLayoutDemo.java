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
public class menampilkanFlowLayoutDemo extends Frame {
    public menampilkanFlowLayoutDemo(){
    }
    public static void main(String args[]){
        menampilkanFlowLayoutDemo fld = new menampilkanFlowLayoutDemo();
        fld.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        fld.add(new Button("ONE"));
        fld.add(new Button("TWO"));
        fld.add(new Button("THREE"));
        fld.setSize(100, 100);
        fld.setVisible(true);
    }
}
