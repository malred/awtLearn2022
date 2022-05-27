package jccT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class t {
    JFrame jf = new JFrame();
    JTextArea jta = new JTextArea("选择颜色",6,30);
    //按钮
    JButton btn = new JButton(new AbstractAction("改变文本框背景颜色") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //弹出颜色选择器
            Color cc = JColorChooser.showDialog(jf, "颜色选择器", Color.white);
            //修改背景
            jta.setBackground(cc);
        }
    });
    public void init(){
        jf.add(jta);
        jf.add(btn,BorderLayout.SOUTH);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        new t().init();
    }
}
