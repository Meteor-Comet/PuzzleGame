package com.puzzle.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameFrame extends JFrame implements KeyListener {
    int[][] data =new int[4][4];
    public GameFrame()
    {
        //初始化界面
        initJFrame();
        //初始化菜单
        initJMenuBar();
        //初始化数据
        initData();
        //初始化图片
        initImage();

        this.setVisible(true);
    }
    int x = 0;
    int y = 0;
    private void initData() {
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random random = new Random();
        for(int i = 0; i < tempArr.length; i++){
            int temp = tempArr[i];
            int randomIndex = random.nextInt(tempArr.length);
            tempArr[i] = tempArr[randomIndex];
            tempArr[randomIndex] = temp;
        }
        for(int i = 0; i < tempArr.length; i++){
            data[i / 4][i % 4] = tempArr[i];
            if(tempArr[i] == 0){
                x = i / 4;
                y = i % 4;
            }
        }
    }

    private void initImage() {
        //清空
        this.getContentPane().removeAll();

        // 使用循环添加拼图图片
        for (int i = 1; i <= 16; i++) {
            // 计算行和列
            int row = (i - 1) / 4;
            int col = (i - 1) % 4;
            
            // 创建图片标签
            ImageIcon icon = new ImageIcon("src\\main\\resources\\image\\animal\\animal3\\" + data[row][col] + ".jpg");
            JLabel jLabel = new JLabel(icon);
            
            // 设置位置和大小
            jLabel.setBounds(col * 105+ 83, row * 105 +134, 105, 105);
            //给图片添加边框
            jLabel.setBorder(new BevelBorder(1));
            // 添加到窗体中
            this.getContentPane().add(jLabel);
        }
        //添加背景图片
        ImageIcon bg = new ImageIcon("src\\main\\resources\\image\\background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);
        //刷新页面
        this.getContentPane().repaint();
    }

    private void initJFrame() {
        this.setTitle("拼图游戏");
        this.setSize(603,680);

        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //取消居中默认放置
        this.setLayout(null);
        this.addKeyListener(this);
    }

    private void initJMenuBar() {
        JMenuBar jmenuBar = new JMenuBar();
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于");

        JMenuItem replayItem = new JMenuItem("重新开始");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        jmenuBar.add(functionJMenu);
        jmenuBar.add(aboutJMenu);

        this.setJMenuBar(jmenuBar);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //根据用户按下的按键(上下左右)调整图片位置
        int keyCode = e.getKeyCode();
        if(keyCode == 37){
            //按下的是左键
            if(y == 3){
                return;
            }
            data[x][y] = data[x][y+1];
            data[x][y+1] = 0;
            y++;
            this.initImage();
        }else if(keyCode == 38){
            //按下的是上键
            if(x == 3){
                return;
            }
            data[x][y] = data[x+1][y];
            data[x+1][y] = 0;
            x++;
            this.initImage();
        }else if(keyCode == 39){
            //按下的是右键
            if(y == 0){
                return;
            }
            data[x][y] = data[x][y-1];
            data[x][y-1] = 0;
            y--;
            this.initImage();
        }else if(keyCode == 40){
            //按下的是下键
            if(x == 0){
                return;
            }
            data[x][y] = data[x-1][y];
            data[x-1][y] = 0;
            x--;
            this.initImage();
        }
    }
}
