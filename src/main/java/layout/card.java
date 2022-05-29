package layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class card {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //创建存多张卡片的panel
        Panel p1 = new Panel();
        //创建cardlayout
        CardLayout cl = new CardLayout();
        p1.setLayout(cl);
        String[] names = {"第1张","第2张","第3张","第4张","第5张"};
        //panel放入多张卡片
        for (int i = 0; i < names.length; i++) {
            p1.add(names[i],new Button(names[i]));
        }
        //panel放入frame中间区域
        frame.add(p1);//默认添加到中间区
        //创建p2,存放多个组件
        Panel p2 = new Panel();
        Button b1 = new Button("上一张");
        Button b2 = new Button("下一张");
        Button b3 = new Button("第一张");
        Button b4 = new Button("最后一张");
        Button b5 = new Button("第三张");
        //创建事件监听器,监听按钮事件
        ActionListener listener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();//获取按钮上的文字
                switch (actionCommand){
                    case "上一张":
                        //p1的上一张
                        cl.previous(p1);
                        break;
                    case "下一张":
                        cl.next(p1);
                        break;
                    case "第一张":
                        cl.first(p1);
                        break;
                    case "最后一张":
                        cl.last(p1);
                        break;
                    case "第三张":
                        cl.show(p1,"第3张");
                        break;
                }
            }
        };
        //事件和按钮绑定
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);
        //按钮添加到p2
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        //p2放入南部区域
        frame.add(p2,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}
