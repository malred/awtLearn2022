package jtbT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class t {
    JFrame jf = new JFrame("测试工具条");
    JTextArea jta = new JTextArea(6,20);
    //工具条相关
    JToolBar jtb = new JToolBar("播放工具条",SwingConstants.HORIZONTAL);//水平排列
    //3个action对象
    Action pre = new AbstractAction("上一曲",new ImageIcon("jtbT/img/component/pre.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("上一曲\n");
        }
    };
    Action pause = new AbstractAction("暂停",new ImageIcon("jtbT/img/component/pause.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("暂停\n");
        }
    };
    Action next = new AbstractAction("下一曲",new ImageIcon("jtbT/img/component/next.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("下一曲\n");
        }
    };
    public void init(){
        //action对象创建jbutton
        JButton preB = new JButton(pre);
        JButton pauseB = new JButton(pause);
        JButton nextB = new JButton(next);
        jtb.add(preB);
        jtb.addSeparator();//分割线
        jtb.add(pauseB);
        jtb.addSeparator();//分割线
        jtb.add(nextB);
        //工具条可以拖动
        jtb.setFloatable(true);
        //文本框默认不支持滚动条,放进jscrollpanel就行
        JScrollPane jsp = new JScrollPane(jta);
        jf.add(jtb, BorderLayout.NORTH);
        jf.add(jsp);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        new t().init();
    }
}
