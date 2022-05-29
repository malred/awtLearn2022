package menus;

import java.awt.*;
import java.awt.event.*;

/**
 * @author malguy-wang sir
 * @create -\--
 */
public class pm {
    private Frame f = new Frame();
    TextArea ta = new TextArea("请输入", 5, 20);
    //创建panel容器
    Panel p = new Panel();
    //创建右键菜单
    PopupMenu pp = new PopupMenu();
    //创建菜单项
    MenuItem comment = new MenuItem("注释");
    MenuItem cancelComment = new MenuItem("取消注释");
    MenuItem copy = new MenuItem("复制");
    MenuItem save = new MenuItem("保存");
    public void init() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取事件名称
                String actionCommand = e.getActionCommand();
                ta.append("点击了"+actionCommand+"\n");
            }
        };
        comment.addActionListener(al);
        cancelComment.addActionListener(al);
        copy.addActionListener(al);
        save.addActionListener(al);
        pp.add(comment);
        pp.add(cancelComment);
        pp.add(copy);
        pp.add(save);
        p.add(pp);
        //设置panel大小
        p.setPreferredSize(new Dimension(400,300));
        //给panel注册鼠标事件
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //右键事件
                boolean popupTrigger = e.isPopupTrigger();
                if (popupTrigger){
                    //显示 show(显示在哪个组件上,x坐标,y坐标
                    pp.show(p,e.getX(),e.getY());
                }
            }
        });
        f.add(ta);
        f.add(p,BorderLayout.SOUTH);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.pack();
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new pm().init();
    }
}
