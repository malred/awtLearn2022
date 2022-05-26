package componet;

import javafx.scene.control.CheckBox;

import javax.swing.*;
import java.awt.*;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class t1 {
    Frame frame = new Frame();
    //文本框
    TextArea ta = new TextArea(5,20);
    //下拉选择框
    Choice colorChoice = new Choice();
    //选择框组
    CheckboxGroup cg = new CheckboxGroup();
    Checkbox male = new Checkbox("男",cg,true);//bool值指定是不是默认值
    Checkbox female = new Checkbox("女",cg,false);
    //选择框
    Checkbox married = new Checkbox("已婚?",true);
    //单行文本框
    TextField tf = new TextField(20);//20列
    //按钮
    Button b = new Button("ok");
    //列表
    List colorList = new java.awt.List(6,true);//true多选
    public void init(){
        //组装界面
        //底部
        Box hb = Box.createHorizontalBox();
        hb.add(tf);
        hb.add(b);
        frame.add(hb,BorderLayout.SOUTH);
        //组装选择部分
        colorChoice.add("红色");
        colorChoice.add("绿色");
        colorChoice.add("蓝色");
        Box hb1 = Box.createHorizontalBox();
        hb1.add(colorChoice);
        hb1.add(male);
        hb1.add(female);
        hb1.add(married);
        //文本域和选择部分组装
        Box vb = Box.createVerticalBox();
        vb.add(ta);
        vb.add(hb1);
        //组装顶部的左边和列表框
        Box top = Box.createHorizontalBox();
        top.add(vb);
        colorList.add("红色");
        colorList.add("绿色");
        colorList.add("蓝色");
        top.add(colorList);
        frame.add(top);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new t1().init();//初始化
    }
}
