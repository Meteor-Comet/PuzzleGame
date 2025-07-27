package com.puzzle.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame implements ActionListener {

    // 用户名输入框
    JTextField usernameField = new JTextField();
    // 密码输入框
    JPasswordField passwordField = new JPasswordField();
    // 确认密码输入框
    JPasswordField confirmPasswordField = new JPasswordField();
    // 注册按钮
    JButton registerButton = new JButton();
    // 重置按钮
    JButton resetButton = new JButton();

    public RegisterFrame() {
        // 初始化界面
        initJFrame();
        // 初始化组件
        initView();
        // 设置可见
        this.setVisible(true);
    }

    private void initJFrame() {
        this.setTitle("拼图游戏注册");
        this.setSize(488, 500);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
    }

    private void initView() {
        // 用户名标签
        JLabel usernameLabel = new JLabel(new ImageIcon("src\\main\\resources\\image\\register\\注册用户名.png"));
        usernameLabel.setBounds(100, 108, 70, 30);
        this.getContentPane().add(usernameLabel);

        // 用户名输入框
        usernameField.setBounds(175, 108, 200, 30);
        usernameField.setBorder(null);
        usernameField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        this.getContentPane().add(usernameField);

        // 密码标签
        JLabel passwordLabel = new JLabel(new ImageIcon("src\\main\\resources\\image\\register\\注册密码.png"));
        passwordLabel.setBounds(100, 145, 70, 30);
        this.getContentPane().add(passwordLabel);

        // 密码输入框
        passwordField.setBounds(175, 145, 200, 30);
        passwordField.setBorder(null);
        passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        this.getContentPane().add(passwordField);

        // 确认密码标签
        JLabel confirmPasswordLabel = new JLabel(new ImageIcon("src\\main\\resources\\image\\register\\再次输入密码.png"));
        confirmPasswordLabel.setBounds(100, 182, 70, 30);
        this.getContentPane().add(confirmPasswordLabel);

        // 确认密码输入框
        confirmPasswordField.setBounds(175, 182, 200, 30);
        confirmPasswordField.setBorder(null);
        confirmPasswordField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        this.getContentPane().add(confirmPasswordField);

        // 注册按钮
        registerButton.setBounds(123, 250, 128, 47);
        registerButton.setIcon(new ImageIcon("src\\main\\resources\\image\\register\\注册按钮.png"));
        registerButton.setBorder(null);
        registerButton.setContentAreaFilled(false);
        registerButton.addActionListener(this);
        this.getContentPane().add(registerButton);

        // 重置按钮
        resetButton.setBounds(256, 250, 128, 47);
        resetButton.setIcon(new ImageIcon("src\\main\\resources\\image\\register\\重置按钮.png"));
        resetButton.setBorder(null);
        resetButton.setContentAreaFilled(false);
        resetButton.addActionListener(this);
        this.getContentPane().add(resetButton);

        // 添加背景图片 - 最后添加，确保在最底层
        JLabel background = new JLabel(new ImageIcon("src\\main\\resources\\image\\register\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == registerButton) {
            // 注册逻辑
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            // 验证输入
            if (username.length() == 0 || password.length() == 0 || confirmPassword.length() == 0) {
                JOptionPane.showMessageDialog(this, "所有字段都不能为空");
                return;
            }

            if (username.length() < 3) {
                JOptionPane.showMessageDialog(this, "用户名长度不能少于3个字符");
                return;
            }

            if (password.length() < 6) {
                JOptionPane.showMessageDialog(this, "密码长度不能少于6个字符");
                return;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "两次输入的密码不一致");
                confirmPasswordField.setText("");
                return;
            }

            // 检查用户名是否已存在
            if (UserManager.userExists(username)) {
                JOptionPane.showMessageDialog(this, "用户名已存在，请选择其他用户名");
                usernameField.setText("");
                return;
            }

            // 使用UserManager注册用户
            if (UserManager.registerUser(username, password)) {
                JOptionPane.showMessageDialog(this, "注册成功！\n用户名：" + username + "\n请返回登录界面进行登录");
                this.dispose();
                new LoginFrame();
            } else {
                JOptionPane.showMessageDialog(this, "注册失败，请重试");
            }
        } else if (obj == resetButton) {
            // 重置所有输入框
            usernameField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
        }
    }
}
