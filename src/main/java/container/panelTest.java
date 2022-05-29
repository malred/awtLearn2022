package container;

import java.awt.*;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class panelTest {
    public static void main(String[] args) {
        //1,创建window窗口
        Frame frame = new Frame("test");
        //2,创建panel
        Panel panel = new Panel();
        //3,创建文本框和按钮,放入panel
        panel.add(new TextArea("文本框"));
        panel.add(new Button("按钮"));
        //4,panel放入窗口,设置窗口位置和大小
        frame.add(panel);
        frame.setBounds(650,350,600,400);
//        frame.setLocation(650,350);
//        frame.setSize(600,400);
        //5,设置窗口可见
        frame.setVisible(true);
    }
}
