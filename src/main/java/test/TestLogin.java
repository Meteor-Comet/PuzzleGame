package test;

import com.puzzle.ui.LoginFrame;
import com.puzzle.ui.RegisterFrame;
import com.puzzle.ui.GameFrame;

public class TestLogin {
    public static void main(String[] args) {
        // 测试登录界面
        System.out.println("启动登录界面...");
        new LoginFrame();
        
        // 如果需要直接测试注册界面，取消下面的注释
        // System.out.println("启动注册界面...");
        // new RegisterFrame();
        
        // 如果需要直接测试游戏界面，取消下面的注释
        // System.out.println("启动游戏界面...");
        // new GameFrame();
    }
} 