package container;

import java.awt.*;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class scrollPane {
    public static void main(String[] args) {
        Frame frame = new Frame("scrollPane");
        //创建scrollpanel对象,设置总是显示滚动条
        ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        //添加组件到scrollpane
        sp.add(new TextArea("文本框"));
        sp.add(new Button("按钮"));
        //把scrollpanel添加到frame
        frame.add(sp);
        frame.setBounds(650,350,600,400);
        frame.setVisible(true);
    }
}
