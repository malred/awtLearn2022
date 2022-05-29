package layout;

import java.awt.*;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class flow {
    public static void main(String[] args) {
        Frame frame = new Frame("flowLayout");
        //设置布局管理器
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
        //添加多个按钮
        for (int i = 0; i < 100; i++) {
            frame.add(new Button("按钮"));
        }
        //设置最佳大小,pack
        frame.pack();
        frame.setVisible(true);
    }
}
