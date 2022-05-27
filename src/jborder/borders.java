package jborder;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class borders {
    JFrame jf = new JFrame("测试边框");
    private void init(){
        //两行四列的网格布局
        jf.setLayout(new GridLayout(2,4));
        //网格里填充不同jpanel组件,并设置边框和内容
        //创建bavelborder,突起,外边红色,突起颜色绿,阴影部分外颜色蓝,突起阴影白
        Border bevel = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.RED, Color.GREEN, Color.BLUE, Color.GREEN);
        jf.add(getJPanelWithBorder(bevel,"BevelBorder"));
        //创建lineborder
        Border lineBorder = BorderFactory.createLineBorder(Color.ORANGE, 10);
        jf.add(getJPanelWithBorder(lineBorder,"lineBorder"));
        //创建emptyborder
        Border emptyBorder = BorderFactory.createEmptyBorder(10, 5, 20, 10);
        jf.add(getJPanelWithBorder(emptyBorder,"emptyBorder"));
        //创建echtedborder
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.RED, Color.GREEN);
        jf.add(getJPanelWithBorder(etchedBorder,"EtchedBorder"));
        //创建titleborder
        TitledBorder tb = new TitledBorder(new LineBorder(Color.ORANGE,10),"测试标题",TitledBorder.LEFT,TitledBorder.BOTTOM,new Font("StSong",Font.BOLD,18));
        jf.add(getJPanelWithBorder(tb,"TitleBorder"));
        //创建matteborder
        MatteBorder matteBorder = new MatteBorder(10, 5, 20, 10, Color.GREEN);
        jf.add(getJPanelWithBorder(matteBorder,"MatteBorder"));
        //创建compoundBorder
        CompoundBorder compoundBorder = new CompoundBorder(new LineBorder(Color.RED, 10),tb);
        jf.add(getJPanelWithBorder(compoundBorder,"CompoundBorder"));
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public JPanel getJPanelWithBorder(Border b,String content){
        JPanel j = new JPanel();
        j.add(new JLabel(content));//添加内容
        //设置边框
        j.setBorder(b);
        return j;
    }
    public static void main(String[] args) {
        new borders().init();
    }
}
