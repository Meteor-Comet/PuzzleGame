package test;

import com.puzzle.ui.ResourceLoader;
import javax.swing.ImageIcon;

public class ResourceTest {
    public static void main(String[] args) {
        System.out.println("=== 资源加载测试 ===");
        
        // 测试图片资源
        String[] testImages = {
            "login/background.png",
            "login/用户名.png",
            "login/密码.png",
            "login/验证码.png",
            "login/登录按钮.png",
            "register/background.png",
            "animal/animal3/1.jpg",
            "animal/animal3/all.jpg",
            "background.png",
            "win.png"
        };
        
        for (String imagePath : testImages) {
            System.out.print("测试图片: " + imagePath + " - ");
            ImageIcon icon = ResourceLoader.createImageIcon(imagePath);
            if (icon != null && icon.getImage() != null) {
                System.out.println("✓ 加载成功 (" + icon.getIconWidth() + "x" + icon.getIconHeight() + ")");
            } else {
                System.out.println("✗ 加载失败");
            }
        }
        
        System.out.println("\n=== 测试完成 ===");
    }
} 