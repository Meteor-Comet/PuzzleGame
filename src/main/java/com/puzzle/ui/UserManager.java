package com.puzzle.ui;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    
    // 使用静态Map来存储用户信息（实际项目中应该使用数据库）
    private static final Map<String, String> users = new HashMap<>();
    
    // 初始化默认用户
    static {
        users.put("admin", "123456");
    }
    
    /**
     * 注册新用户
     * @param username 用户名
     * @param password 密码
     * @return 注册是否成功
     */
    public static boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // 用户名已存在
        }
        users.put(username, password);
        return true;
    }
    
    /**
     * 验证用户登录
     * @param username 用户名
     * @param password 密码
     * @return 登录是否成功
     */
    public static boolean loginUser(String username, String password) {
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
    
    /**
     * 检查用户名是否存在
     * @param username 用户名
     * @return 是否存在
     */
    public static boolean userExists(String username) {
        return users.containsKey(username);
    }
    
    /**
     * 获取所有用户（用于调试）
     * @return 用户Map的副本
     */
    public static Map<String, String> getAllUsers() {
        return new HashMap<>(users);
    }
} 