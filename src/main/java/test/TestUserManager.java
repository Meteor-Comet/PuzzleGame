package test;

import com.puzzle.ui.UserManager;

public class TestUserManager {
    public static void main(String[] args) {
        System.out.println("=== 用户管理系统测试 ===");
        
        // 测试默认用户
        System.out.println("\n1. 测试默认用户登录：");
        boolean adminLogin = UserManager.loginUser("admin", "123456");
        System.out.println("admin/123456 登录结果: " + adminLogin);
        
        // 测试注册新用户
        System.out.println("\n2. 测试注册新用户：");
        boolean register1 = UserManager.registerUser("testuser", "password123");
        System.out.println("注册 testuser/password123: " + register1);
        
        // 测试重复注册
        System.out.println("\n3. 测试重复注册：");
        boolean register2 = UserManager.registerUser("testuser", "password456");
        System.out.println("重复注册 testuser: " + register2);
        
        // 测试新用户登录
        System.out.println("\n4. 测试新用户登录：");
        boolean testLogin = UserManager.loginUser("testuser", "password123");
        System.out.println("testuser/password123 登录结果: " + testLogin);
        
        // 测试错误密码
        System.out.println("\n5. 测试错误密码：");
        boolean wrongPassword = UserManager.loginUser("testuser", "wrongpassword");
        System.out.println("testuser/wrongpassword 登录结果: " + wrongPassword);
        
        // 显示所有用户
        System.out.println("\n6. 当前所有用户：");
        System.out.println(UserManager.getAllUsers());
        
        System.out.println("\n=== 测试完成 ===");
    }
} 