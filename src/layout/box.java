package layout;

import javax.swing.*;
import java.awt.*;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class box {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //创建垂直存放的box布局
        BoxLayout boxLayout = new BoxLayout(frame, BoxLayout.Y_AXIS);
        //box布局设置给frame
        frame.setLayout(boxLayout);
        //frame添加两个按钮
        frame.add(new Button("按钮1"));
        frame.add(new Button("按钮2"));
        frame.pack();
        frame.setVisible(true);
    }
}
