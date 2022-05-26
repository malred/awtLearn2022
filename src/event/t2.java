package event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class t2 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        TextField tf = new TextField(30);
        Choice names = new Choice();
        names.add("a");
        names.add("b");
        names.add("c");
        //给文本域添加监听器
        tf.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                String text = tf.getText();
                System.out.println(text);
            }
        });
        //给下拉选择框添加监听器
        names.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object item = e.getItem();
                System.out.println("当前选项:"+item);
            }
        });
        //给frame注册监听器,监听组件添加
        frame.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
                Component child = e.getChild();
                System.out.println("添加了:"+child);
            }
            @Override
            public void componentRemoved(ContainerEvent e) { }
        });
        //添加到frame
        Box hb = Box.createHorizontalBox();
        hb.add(names);
        hb.add(tf);
        frame.add(hb,BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }
}
