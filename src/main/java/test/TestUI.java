package test;

import com.puzzle.ui.LoginFrame;
import com.puzzle.ui.RegisterFrame;

import javax.swing.*;

public class TestUI {
    public static void main(String[] args) {
        // 测试登录界面
        System.out.println("启动登录界面...");
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });
        
        // 延迟2秒后启动注册界面
        Timer timer = new Timer(2000, e -> {
            System.out.println("启动注册界面...");
            RegisterFrame registerFrame = new RegisterFrame();
            registerFrame.setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }
} 