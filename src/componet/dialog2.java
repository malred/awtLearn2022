package componet;

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
        Dialog d2 = new Dialog(frame,"非模式对话框",false);
        //setbounds方法设置位置和大小
        d1.setBounds(20,30,300,200);
        d2.setBounds(20,30,300,200);
        //创建两个按钮
        Button b1 = new Button("模式对话框");
        Button b2 = new Button("非模式对话框");
        //按钮添加行为
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1.setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d2.setVisible(true);
            }
        });
        //按钮添加到frame
        frame.add(b1,BorderLayout.NORTH);
        frame.add(b2);
        frame.pack();
        frame.setVisible(true);
    }
}
