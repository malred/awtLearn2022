package draw;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class handdraw {
    Frame f = new Frame("简单绘图程序");
    //定义画图区的宽高
    private final int AREA_WIDTH = 500;
    private final int AREA_HEIGHT = 400;
    //定义右键菜单,用于设置画笔颜色
    private PopupMenu colorMenu = new PopupMenu();
    private MenuItem redItem = new MenuItem("红色");
    private MenuItem blueItem = new MenuItem("蓝色");
    private MenuItem greenItem = new MenuItem("绿色");
    //记录当前画笔颜色
    private Color nowColor = Color.BLACK;
    //创建bufferimage位图对象
    BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);
    //获取关联的graphic对象
    Graphics g = image.getGraphics();

    //自定义类,继承canvas
    private class myCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, null);
        }
    }

    myCanvas drawArea = new myCanvas();
    //记录鼠标上次所属的坐标
    private int preX = -1;
    private int preY = -1;

    public void init() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                switch (actionCommand){
                    case "红色":
                        nowColor = Color.RED;
                        break;
                    case "蓝色":
                        nowColor = Color.BLUE;
                        break;
                    case "绿色":
                        nowColor = Color.GREEN;
                        break;
                }
            }
        };
        redItem.addActionListener(listener);
        blueItem.addActionListener(listener);
        greenItem.addActionListener(listener);
        colorMenu.add(redItem);
        colorMenu.add(blueItem);
        colorMenu.add(greenItem);
        drawArea.add(colorMenu);
        drawArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //鼠标抬起
                boolean popupTrigger = e.isPopupTrigger();
                if (popupTrigger) {
                    //右键显示
                    colorMenu.show(drawArea, e.getX(), e.getY());
                }
                //重置prex和prey
                preX=-1;
                preY=-1;
            }
        });
        //位图背景设置为白
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
        //监听鼠标移动,完成绘制
        drawArea.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //鼠标左键拖动时会调用
                //画线条 需要两组坐标,分别代表线条的起点和终点
                if (preX > 0 && preY > 0) {
                    g.setColor(nowColor);
                    g.drawLine(preX, preY, e.getX(), e.getY());
                }
                //修正prex和prey的值
                preX=e.getX();
                preY=e.getY();
                //重绘
                drawArea.repaint();
            }
        });
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
        new handdraw().init();
    }
}
