package event;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class t3 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setBounds(650,350,400,200);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);//退出程序
            }
        });
        frame.setVisible(true);
    }
}
