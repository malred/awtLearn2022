package componet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class dialog2 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //创建两个对话框,一个模式,一个非模式
        Dialog d1 = new Dialog(frame,"模式对话框",true);
        //创建垂直box容器,把一个文本框和按钮添加到box
        Box vb = Box.createVerticalBox();
        vb.add(new Button("按钮"));
        vb.add(new TextField(20)); 
        //添加到dialog
        d1.add(vb);
        //setbounds方法设置位置和大小
        d1.setBounds(20,30,300,200);
        //创建两个按钮
        Button b1 = new Button("模式对话框");
        //按钮添加行为
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1.setVisible(true);
            }
        });
        //按钮添加到frame
        frame.add(b1,BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }
}
