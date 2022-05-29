package game1;

import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.util.concurrent.Callable;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class tq {
    Frame f = new Frame();
    //桌面宽度
    private final int TABLE_WIDTH = 300;
    //桌面高度
    private final int TABLE_HEIGHT = 400;
    //球拍高度和宽度
    private final int RACKET_WIDTH = 60;
    private final int RACKET_HEIGHT = 20;
    //球的大小
    private final int BALL_SIZE = 16;
    //记录小球坐标
    private int ballX = 120;
    private int ballY = 20;
    //记录小球在不同方向上的移动速度
    private int speedX = 10;
    private int speedY = 5;
    //记录球拍位置
    private int racketX = 120;
    private int racketY = 340;
    //当前游戏是否结束
    private boolean isOver = false;
    //定时器
    private Timer timer;
    //继承canvas,当画布
    private class myCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            if(isOver){
                g.setColor(Color.BLUE);
                g.setFont(new Font("Times",Font.BOLD,30));
                g.drawString("游戏结束",50,200);
            }else {
                //绘制小球
                g.setColor(Color.RED);
                g.fillOval(ballX,ballY,BALL_SIZE,BALL_SIZE);
                //绘制球拍
                g.setColor(Color.PINK);
                g.fillRect(racketX,racketY,RACKET_WIDTH,RACKET_HEIGHT);
            }
        }
    }
    //绘画区域
    myCanvas drawArea = new myCanvas();
    public void init(){
        //组装和游戏控制
        //球拍坐标变化
        KeyListener kl = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();//获取当前按下的按键
                if(keyCode== KeyEvent.VK_LEFT){
                    if(racketX>0){
                        racketX-=10;//左移10
                    }
                }
                if(keyCode==KeyEvent.VK_RIGHT){
                    if(racketX<(TABLE_WIDTH-RACKET_WIDTH)){
                        racketX+=10;//右移10
                    }
                }
            }
        };
        //给frame和drawarea同时设置监听器
        f.addKeyListener(kl);
        drawArea.addKeyListener(kl);
        //小球坐标的控制
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //根据边界修正速度
                if(ballX<=0||ballX>=(TABLE_WIDTH-BALL_SIZE)) speedX = -speedX;
                if(ballY<=0||(ballY>racketY-BALL_SIZE && ballX>racketX && ballX<racketX+RACKET_WIDTH))
                    speedY = -speedY;
                if(ballY>racketY-BALL_SIZE && (ballX<racketX || ballX>racketX+RACKET_WIDTH)){
                    //游戏结束
                    //停止定时器
                    timer.stop();
                    //isover
                    isOver=true;
                    drawArea.repaint();
                }
                //更新小球坐标,重绘
                ballX+=speedX;
                ballY+=speedY;
                drawArea.repaint();
            }
        };
        timer = new javax.swing.Timer(75,task);
        timer.start();
        drawArea.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));
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
        new tq().init();
    }
}
