package event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class t {
    Frame f = new Frame();
    TextField tf = new TextField(30);
    Button b = new Button("hello");
    public void init(){
        //监听器
//        MyListener ml = new MyListener();
        //注册监听器
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("hello world");
            }
        });
        f.add(tf,BorderLayout.NORTH);
        f.add(b);
        f.pack();
        f.setVisible(true);
    }
//    private class MyListener implexments ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            tf.setText("hello world");
//        }
//    }
    public static void main(String[] args) {
        new t().init();
    }
}
