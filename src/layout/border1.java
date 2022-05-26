package layout;

import java.awt.*;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class border1 {
    public static void main(String[] args) {
        Frame frame = new Frame("borderLayout");
        //设置布局管理器
        frame.setLayout(new BorderLayout(20,20));
        //添加多个按钮
        frame.add(new Button("按钮"),BorderLayout.NORTH);
        frame.add(new Button("按钮"),BorderLayout.SOUTH);
        Panel panel = new Panel();
        panel.add(new Button("按钮"));
        panel.add(new TextField("文本区"));
        frame.add(panel);
        //设置最佳大小,pack
        frame.pack();
        frame.setLocation(650,350);
        frame.setVisible(true);
    }
}
