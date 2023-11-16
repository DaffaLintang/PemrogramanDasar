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
public class menampilkanFrameControl extends Frame {
    public menampilkanFrameControl() {
}
    public static void main(String args[]){
        menampilkanFrameControl fwc = new menampilkanFrameControl();
        fwc.setLayout(new FlowLayout());
        fwc.setSize(600, 600);
        fwc.add(new Button("Test Me!"));
        fwc.add(new Label("Label"));
        fwc.add(new TextField());
        CheckboxGroup cbg = new CheckboxGroup();
        fwc.add(new Checkbox("chk1", cbg,true));
        fwc.add(new Checkbox("chk2", cbg,true));
        fwc.add(new Checkbox("chk3", cbg,true));
        List list = new List(3, false);
        list.add("MTV");
        list.add("V");
        fwc.add(list);
        Choice chooser = new Choice();
        chooser.add("Avril");
        chooser.add("Monica");
        chooser.add("Adit");
        fwc.add(chooser);
        fwc.add(new Scrollbar());
        fwc.setVisible(true);
    }
}
