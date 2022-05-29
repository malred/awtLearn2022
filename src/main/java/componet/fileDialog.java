package componet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class fileDialog {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //创建两个filedialog对象
        FileDialog fd1 = new FileDialog(frame,"要打开的文件",FileDialog.LOAD);
        FileDialog fd2 = new FileDialog(frame,"要保存的文件",FileDialog.SAVE);
        //创建两个按钮
        Button b1 = new Button("打开文件");
        Button b2 = new Button("保存文件");
        //绑定按钮的事件
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fd1.setVisible(true);//会阻塞到这
                //获取路径和文件
                String directory = fd1.getDirectory();
                String file = fd1.getFile();
                System.out.println("打开的文件路径为:"+directory);
                System.out.println("打开的文件为:"+file);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fd2.setVisible(true);//会阻塞到这
                //获取路径和文件
                String directory = fd2.getDirectory();
                String file = fd2.getFile();
                System.out.println("保存的文件路径为:"+directory);
                System.out.println("保存的文件为:"+file);
            }
        });
        frame.add(b1,BorderLayout.NORTH);
        frame.add(b2);
        frame.pack();
        frame.setVisible(true);
    }
}
