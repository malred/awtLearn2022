package layout;

import javax.swing.*;
import java.awt.*;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class box3 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //创建水平排列的box
        Box hb = Box.createHorizontalBox();
        hb.add(new Button("水平按钮1"));
        hb.add(Box.createHorizontalGlue());//两个方向上都可以拉伸的分割
        hb.add(new Button("水平按钮2"));
        hb.add(Box.createHorizontalStrut(30));//固定大小的分割
        hb.add(new Button("水平按钮3"));
        //创建垂直排列的box
        Box vb = Box.createVerticalBox();
        vb.add(new Button("垂直按钮1"));
        vb.add(Box.createVerticalGlue());//两个方向上都可以拉伸的分割
        vb.add(new Button("垂直按钮2"));
        vb.add(Box.createVerticalStrut(30));//固定大小的分割
        vb.add(new Button("垂直按钮3"));
        frame.add(hb,BorderLayout.NORTH);
        frame.add(vb);
        frame.pack();
        frame.setLocation(650,350);
        frame.setVisible(true);
    }
}
