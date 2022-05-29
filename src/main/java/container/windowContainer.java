package container;

import java.awt.*;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class windowContainer {
    public static void main(String[] args) {
        //1,创建窗口对象
        Frame frame = new Frame("测试用windows窗口");
        //2,指定窗口位置
        frame.setLocation(200,200);
        frame.setSize(500,300);
        //3,设置窗口可见
        frame.setVisible(true);
    }
}
