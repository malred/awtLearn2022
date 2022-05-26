package menus;

import java.awt.*;
import java.awt.event.*;
import java.security.PrivateKey;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class m {
    private Frame f = new Frame();
    //创建菜单条
    MenuBar mb = new MenuBar();
    //创建菜单组件
    Menu fileMenu = new Menu("文件");
    Menu editMenu = new Menu("编辑");
    Menu formatMenu = new Menu("格式");
    //菜单项组件
    MenuItem auto = new MenuItem("自动换行");
    MenuItem copy = new MenuItem("复制");
    MenuItem paste = new MenuItem("黏贴");
    MenuItem comment =
            new MenuItem("注释 Ctrl+Shift+Q",new MenuShortcut(KeyEvent.VK_Q,true));
    MenuItem cancelComment = new MenuItem("取消注释");
    TextArea ta = new TextArea(5,20);
    public void init(){
        //组装
        comment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("点击了菜单项:" + e.getActionCommand());
            }
        });
        formatMenu.add(comment);
        formatMenu.add(cancelComment);
        //组装编辑菜单栏
        editMenu.add(auto);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add(formatMenu);
        //组装菜单栏
        mb.add(fileMenu);
        mb.add(editMenu);
        //放入frame
        f.setMenuBar(mb);
        f.add(ta);
        //加上关闭监听器
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
        new m().init();
    }
}
