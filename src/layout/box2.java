package layout;

import javax.swing.*;
import java.awt.*;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class box2 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //创建水平排列的box容器
        Box hb = Box.createHorizontalBox();
        //添加按钮
        for (int i = 0; i < 2; i++) {
            hb.add(new Button("水平按钮"+i));
        }
        //创建垂直排列的box容器
        Box vb = Box.createVerticalBox();
        for (int i = 0; i < 2; i++) {
            vb.add(new Button("垂直按钮"+i));
        }
        frame.add(hb,BorderLayout.NORTH);
        frame.add(vb);
        frame.pack();
        frame.setVisible(true);
    }
}
