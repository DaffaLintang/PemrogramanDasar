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
public class menampilkanGridLayoutDemo extends Frame{
    public menampilkanGridLayoutDemo() {
}
    public static void main (String args[]){
        menampilkanGridLayoutDemo gld = new menampilkanGridLayoutDemo();
        gld.setLayout(new GridLayout(2,3,4,4));
        gld.add(new Button("ONE"));
        gld.add(new Button("TWO"));
        gld.add(new Button("THREE"));
        gld.add(new Button("FOUR"));
        gld.add(new Button("FIVE"));
        gld.setSize(200, 200);
        gld.setVisible(true);
    }
}
