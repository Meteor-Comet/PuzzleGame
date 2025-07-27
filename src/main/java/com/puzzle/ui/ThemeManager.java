package com.puzzle.ui;

import java.util.HashMap;
import java.util.Map;

public class ThemeManager {
    
    // 主题类型枚举
    public enum ThemeType {
        ANIMAL("动物"),
        GIRL("女孩"),
        SPORT("运动");
        
        private final String displayName;
        
        ThemeType(String displayName) {
            this.displayName = displayName;
        }
        
        public String getDisplayName() {
            return displayName;
        }
    }
    
    // 主题路径映射
    private static final Map<String, String> themePaths = new HashMap<>();
    
    static {
        // 动物主题
        for (int i = 1; i <= 8; i++) {
            themePaths.put("动物" + i, "src\\main\\resources\\image\\animal\\animal" + i + "\\");
        }
        
        // 女孩主题
        for (int i = 1; i <= 13; i++) {
            themePaths.put("女孩" + i, "src\\main\\resources\\image\\girl\\girl" + i + "\\");
        }
        
        // 运动主题
        for (int i = 1; i <= 10; i++) {
            themePaths.put("运动" + i, "src\\main\\resources\\image\\sport\\sport" + i + "\\");
        }
    }
    
    /**
     * 获取主题路径
     * @param themeName 主题名称
     * @return 主题路径
     */
    public static String getThemePath(String themeName) {
        return themePaths.getOrDefault(themeName, "src\\main\\resources\\image\\animal\\animal3\\");
    }
    
    /**
     * 获取所有主题名称
     * @return 主题名称数组
     */
    public static String[] getAllThemeNames() {
        return themePaths.keySet().toArray(new String[0]);
    }
    
    /**
     * 根据主题类型获取主题名称
     * @param type 主题类型
     * @return 主题名称数组
     */
    public static String[] getThemeNamesByType(ThemeType type) {
        return themePaths.keySet().stream()
                .filter(name -> name.startsWith(type.getDisplayName()))
                .toArray(String[]::new);
    }
    
    /**
     * 检查主题是否存在
     * @param themeName 主题名称
     * @return 是否存在
     */
    public static boolean themeExists(String themeName) {
        return themePaths.containsKey(themeName);
    }
} 