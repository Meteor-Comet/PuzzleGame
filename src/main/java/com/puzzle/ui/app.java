package com.puzzle.ui;

import javax.swing.*;

public class app {
    public static void main(String[] args) {
        JFrame gameJframe = new JFrame("Puzzle");
        gameJframe.setSize(603,680);
        gameJframe.setVisible(true);

        JFrame loginFrame = new JFrame();
        loginFrame.setSize(488,430);
        loginFrame.setVisible(true);

        JFrame registerFrame = new JFrame();
        registerFrame.setSize(488,500);
        registerFrame.setVisible(true);
    }
}
