package com.puzzle.ui;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame()
    {
        this.setTitle("拼图游戏");
        this.setSize(603,680);

        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //初始化菜单
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


        this.setVisible(true);
    }
}
