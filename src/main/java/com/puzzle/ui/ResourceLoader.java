package com.puzzle.ui;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import javax.swing.ImageIcon;

public class ResourceLoader {
    
    /**
     * 获取资源文件的URL
     * @param resourcePath 资源文件路径
     * @return 资源文件的URL，如果找不到返回null
     */
    public static URL getResourceURL(String resourcePath) {
        return ResourceLoader.class.getClassLoader().getResource(resourcePath);
    }
    
    /**
     * 获取资源文件的输入流
     * @param resourcePath 资源文件路径
     * @return 资源文件的输入流，如果找不到返回null
     */
    public static InputStream getResourceStream(String resourcePath) {
        return ResourceLoader.class.getClassLoader().getResourceAsStream(resourcePath);
    }
    
    /**
     * 创建ImageIcon，支持从JAR包和文件系统加载
     * @param imagePath 图片路径
     * @return ImageIcon对象
     */
    public static ImageIcon createImageIcon(String imagePath) {
        // 首先尝试从JAR包中加载
        URL url = getResourceURL("image/" + imagePath);
        if (url != null) {
            return new ImageIcon(url);
        }
        
        // 如果不在JAR包中，尝试从文件系统加载
        File file = new File("src/main/resources/image/" + imagePath);
        if (file.exists()) {
            return new ImageIcon(file.getAbsolutePath());
        }
        
        // 最后尝试从当前目录加载
        file = new File("resources/image/" + imagePath);
        if (file.exists()) {
            return new ImageIcon(file.getAbsolutePath());
        }
        
        // 如果都找不到，返回null
        System.err.println("无法找到图片资源: " + imagePath);
        return null;
    }
    
    /**
     * 获取图片资源路径（兼容旧代码）
     * @param imagePath 图片路径
     * @return 完整的图片路径
     */
    public static String getImagePath(String imagePath) {
        // 首先尝试从JAR包中加载
        URL url = getResourceURL("image/" + imagePath);
        if (url != null) {
            return url.getPath();
        }
        
        // 如果不在JAR包中，尝试从文件系统加载
        File file = new File("src/main/resources/image/" + imagePath);
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        
        // 最后尝试从当前目录加载
        file = new File("resources/image/" + imagePath);
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        
        // 如果都找不到，返回原始路径
        return "src/main/resources/image/" + imagePath;
    }
} 