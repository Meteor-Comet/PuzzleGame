package com.puzzle.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class LoginFrame extends JFrame implements ActionListener, MouseListener {

    // 用户名输入框
    JTextField usernameField = new JTextField();
    // 密码输入框
    JPasswordField passwordField = new JPasswordField();
    // 验证码输入框
    JTextField codeField = new JTextField();
    // 验证码显示标签
    JLabel codeLabel = new JLabel();
    // 登录按钮
    JButton loginButton = new JButton();
    // 注册按钮
    JButton registerButton = new JButton();
    // 显示密码按钮
    JButton showPasswordButton = new JButton();
    
    // 验证码
    String code = "";
    // 是否显示密码
    boolean isShowPassword = false;

    public LoginFrame() {
        // 初始化界面
        initJFrame();
        // 初始化组件
        initView();
        // 初始化验证码
        initCode();
        // 设置可见
        this.setVisible(true);
    }

    private void initJFrame() {
        this.setTitle("拼图游戏登录");
        this.setSize(488, 430);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
    }

    private void initView() {
        // 用户名标签
        JLabel usernameLabel = new JLabel(new ImageIcon("src\\main\\resources\\image\\login\\用户名.png"));
        usernameLabel.setBounds(100, 108, 70, 30);
        this.getContentPane().add(usernameLabel);

        // 用户名输入框
        usernameField.setBounds(175, 108, 200, 30);
        usernameField.setBorder(null);
        usernameField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        this.getContentPane().add(usernameField);

        // 密码标签
        JLabel passwordLabel = new JLabel(new ImageIcon("src\\main\\resources\\image\\login\\密码.png"));
        passwordLabel.setBounds(100, 145, 70, 30);
        this.getContentPane().add(passwordLabel);

        // 密码输入框
        passwordField.setBounds(175, 145, 200, 30);
        passwordField.setBorder(null);
        passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        this.getContentPane().add(passwordField);

        // 验证码标签
        JLabel codeLabelTitle = new JLabel(new ImageIcon("src\\main\\resources\\image\\login\\验证码.png"));
        codeLabelTitle.setBounds(100, 182, 70, 30);
        this.getContentPane().add(codeLabelTitle);

        // 验证码输入框
        codeField.setBounds(175, 182, 100, 30);
        codeField.setBorder(null);
        codeField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        this.getContentPane().add(codeField);

        // 验证码显示标签
        codeLabel.setBounds(285, 182, 50, 30);
        codeLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        codeLabel.setForeground(Color.RED);
        codeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        codeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        codeLabel.addMouseListener(this);
        this.getContentPane().add(codeLabel);

        // 显示密码按钮
        showPasswordButton.setBounds(375, 145, 30, 30);
        showPasswordButton.setIcon(new ImageIcon("src\\main\\resources\\image\\login\\显示密码.png"));
        showPasswordButton.setBorder(null);
        showPasswordButton.setContentAreaFilled(false);
        showPasswordButton.addActionListener(this);
        this.getContentPane().add(showPasswordButton);

        // 登录按钮
        loginButton.setBounds(123, 250, 128, 47);
        loginButton.setIcon(new ImageIcon("src\\main\\resources\\image\\login\\登录按钮.png"));
        loginButton.setBorder(null);
        loginButton.setContentAreaFilled(false);
        loginButton.addActionListener(this);
        this.getContentPane().add(loginButton);

        // 注册按钮
        registerButton.setBounds(256, 250, 128, 47);
        registerButton.setIcon(new ImageIcon("src\\main\\resources\\image\\login\\注册按钮.png"));
        registerButton.setBorder(null);
        registerButton.setContentAreaFilled(false);
        registerButton.addActionListener(this);
        this.getContentPane().add(registerButton);

        // 添加背景图片 - 最后添加，确保在最底层
        JLabel background = new JLabel(new ImageIcon("src\\main\\resources\\image\\login\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }

    private void initCode() {
        // 生成随机验证码
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(random.nextInt(10));
        }
        code = sb.toString();
        codeLabel.setText(code);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == loginButton) {
            // 登录逻辑
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String inputCode = codeField.getText();

            // 验证输入
            if (username.length() == 0 || password.length() == 0) {
                JOptionPane.showMessageDialog(this, "用户名和密码不能为空");
                return;
            }

            if (inputCode.length() == 0) {
                JOptionPane.showMessageDialog(this, "请输入验证码");
                return;
            }

            if (!inputCode.equals(code)) {
                JOptionPane.showMessageDialog(this, "验证码错误");
                initCode();
                codeField.setText("");
                return;
            }

            // 使用UserManager进行验证
            if (UserManager.loginUser(username, password)) {
                JOptionPane.showMessageDialog(this, "登录成功，欢迎 " + username + "！");
                this.dispose();
                new GameFrame();
            } else {
                JOptionPane.showMessageDialog(this, "用户名或密码错误");
                passwordField.setText("");
                initCode();
                codeField.setText("");
            }
        } else if (obj == registerButton) {
            // 打开注册界面
            this.dispose();
            new RegisterFrame();
        } else if (obj == showPasswordButton) {
            // 切换密码显示
            if (isShowPassword) {
                passwordField.setEchoChar('*');
                showPasswordButton.setIcon(new ImageIcon("src\\main\\resources\\image\\login\\显示密码.png"));
            } else {
                passwordField.setEchoChar((char) 0);
                showPasswordButton.setIcon(new ImageIcon("src\\main\\resources\\image\\login\\显示密码按下.png"));
            }
            isShowPassword = !isShowPassword;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == codeLabel) {
            initCode();
            codeField.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
