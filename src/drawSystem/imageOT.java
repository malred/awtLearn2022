package drawSystem;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class imageOT {
    private Frame f = new Frame("图片查看器");
    MenuBar mb = new MenuBar();
    Menu fm = new Menu("文件");
    MenuItem open = new MenuItem("打开");
    MenuItem save = new MenuItem("另存为");
    //声明bufferedImage对象,记录本地存到内存的图片
    BufferedImage image;
    private class myCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            g.drawImage(image,0,0,null);
        }
    }
    myCanvas drawArea = new myCanvas();
    private void init() throws Exception{
        open.addActionListener(e->{
            //打开一个文件对话框
            FileDialog fd = new FileDialog(f,"打开图片",FileDialog.LOAD);
            fd.setVisible(true);
            //获取用户选择的图片名称和路径
            String directory = fd.getDirectory();
            String file = fd.getFile();
            //读取
            try {
                image = ImageIO.read(new File(directory,file));
                drawArea.repaint();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        save.addActionListener(e->{
            //展示一个文件对话框
            FileDialog fd1 = new FileDialog(f,"保存文件",FileDialog.SAVE);
            fd1.setVisible(true);
            String directory = fd1.getDirectory();
            String file = fd1.getFile();
            try {
                ImageIO.write(image,"JPG",new File(directory,file));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        fm.add(open);
        fm.add(save);
        mb.add(fm);
        f.setMenuBar(mb);
        f.add(drawArea);
        f.setBounds(650,450,740,508);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) {
        try {
            new imageOT().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
