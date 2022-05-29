package draw;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class d1 {
    private final String RECT_SHAPE = "rect";
    private final String OVAL_SHAPE = "oval";
    private Frame f = new Frame();
    Button rectB = new Button("绘制矩形");
    Button ovalB = new Button("绘制椭圆");
    //一个变量,记录当前要绘制的图形
    private String shape = "";
    //自定义类,继承canvas,重写paint方法
    private class myCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            //绘制不同图形
            if(shape.equals(RECT_SHAPE)){
                g.setColor(Color.yellow);//设置画笔颜色为黄
                g.drawRect(100,100,150,100);
            }else if (shape.equals(OVAL_SHAPE)){
                g.setColor(Color.RED);//设置画笔颜色为红
                g.drawOval(100,100,150,100);
            }
        }
    }
    //创建自定义画布对象
    myCanvas drawArea = new myCanvas();
    public void init(){
        //组装
        rectB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape=RECT_SHAPE;//修改标记值
                drawArea.repaint();//重新绘制
            }
        });
        ovalB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape=OVAL_SHAPE;//修改标记值
                drawArea.repaint();//重新绘制
            }
        });
        //创建panel,放按钮
        Panel p = new Panel();
        p.add(rectB);
        p.add(ovalB);
        f.add(p,BorderLayout.SOUTH);
        drawArea.setPreferredSize(new Dimension(300,300));
        f.add(drawArea);
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
        new d1().init();
    }
}
