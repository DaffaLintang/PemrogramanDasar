/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hardCode;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
/**
 *
 * @author daffa
 */
public class menampilkanPanel extends Panel{
    public menampilkanPanel(){
        setBackground(Color.black);
    }

    public void paint(Graphics g){
        g.setColor(new Color(0,255,0));
        g.setFont(new Font("Helvetica", Font.PLAIN,16));
        g.drawString("Hello GUI World!", 30, 100);
       g.setColor(new Color(1.0f,0,0)); 
        g.fillRect(30, 100, 150, 10); 
    }
    
    public static void main(String args[]){
        Frame f = new Frame("Testing Graphics Panel");
        menampilkanPanel gp = new menampilkanPanel();
        f.add(gp);
        f.setSize(600, 300);
        f.setVisible(true);
    }
}
