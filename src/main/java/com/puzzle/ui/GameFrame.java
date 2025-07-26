package com.puzzle.ui;

import javax.swing.*;
import java.util.Random;

public class GameFrame extends JFrame {
    public GameFrame()
    {
        //初始化界面
        initJFrame();
        //初始化菜单
        initJMenuBar();
        //初始化数据
        initData();
        //初始化图片
        initImage(initData());

        this.setVisible(true);
    }

    private int[][] initData() {
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random random = new Random();
        for(int i = 0; i < tempArr.length; i++){
            int temp = tempArr[i];
            int randomIndex = random.nextInt(tempArr.length);
            tempArr[i] = tempArr[randomIndex];
            tempArr[randomIndex] = temp;
        }
        int[][] tempArr2 = new int[4][4];
        for(int i = 0; i < tempArr.length; i++){
            tempArr2[i / 4][i % 4] = tempArr[i];
        }
        return tempArr2;
    }

    private void initImage(int[][] ints) {
        // 使用循环添加拼图图片
        for (int i = 1; i <= 16; i++) {
            // 计算行和列
            int row = (i - 1) / 4;
            int col = (i - 1) % 4;
            
            // 创建图片标签
            ImageIcon icon = new ImageIcon("F:\\JavaProjects\\PuzzleGame\\src\\main\\resources\\image\\animal\\animal3\\" + ints[row][col] + ".jpg");
            JLabel jLabel = new JLabel(icon);
            
            // 设置位置和大小
            jLabel.setBounds(col * 105, row * 105, 105, 105);
            
            // 添加到窗体中
            this.getContentPane().add(jLabel);
        }
    }

    private void initJFrame() {
        this.setTitle("拼图游戏");
        this.setSize(603,680);

        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //取消居中默认放置
        this.setLayout(null);
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
}
