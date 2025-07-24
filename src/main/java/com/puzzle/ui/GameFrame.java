package com.puzzle.ui;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame()
    {
        this.setTitle("拼图游戏");
        this.setSize(603,680);
        this.setVisible(true);

        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
