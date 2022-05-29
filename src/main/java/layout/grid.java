package layout;

import javax.swing.border.Border;
import java.awt.*;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class grid {
    public static void main(String[] args) {
        //frame默认布局是border
        Frame frame = new Frame("计算器");
        //创建panel,添加文本框,添加到北边
        Panel panel = new Panel();
        panel.add(new TextField(30));
        frame.add(panel, BorderLayout.NORTH);
        //创建p,布局为grid
        Panel p = new Panel();
        p.setLayout(new GridLayout(3,5,4,4));
        //p添加内容
        for (int i = 0; i < 10; i++) {
            p.add(new Button(i+""));
        }
        p.add(new Button("+"));
        p.add(new Button("-"));
        p.add(new Button("*"));
        p.add(new Button("/"));
        p.add(new Button("."));
        //p添加到frame的center区
        frame.add(p,BorderLayout.CENTER);
        frame.pack();
        frame.setLocation(650,350);
//        frame.setBounds(650,350,600,400);
        frame.setVisible(true);
    }
}
