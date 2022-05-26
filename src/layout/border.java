package layout;

import java.awt.*;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class border {
    public static void main(String[] args) {
        Frame frame = new Frame("borderLayout");
        //设置布局管理器
        frame.setLayout(new BorderLayout(20,20));
        //添加多个按钮
        frame.add(new Button("按钮"),BorderLayout.NORTH);
        frame.add(new Button("按钮"),BorderLayout.CENTER);
        frame.add(new Button("按钮"),BorderLayout.SOUTH);
        frame.add(new Button("按钮"),BorderLayout.WEST);
        frame.add(new Button("按钮"),BorderLayout.EAST);
        //设置最佳大小,pack
        frame.pack();
        frame.setVisible(true);
    }
}
