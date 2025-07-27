package com.puzzle.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameFrame extends JFrame implements KeyListener, ActionListener {
    int[][] data =new int[4][4];
    public GameFrame()
    {
        //初始化界面
        initJFrame();
        //初始化菜单
        initJMenuBar();
        //初始化数据
        initData();
        //初始化图片
        initImage();

        this.setVisible(true);
    }
    int x = 0;
    int y = 0;
    int[][] win ={
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,16}
    };
    String path = "animal/animal3/";
    String currentTheme = "动物3";

    int step = 0;
    JMenuItem replayItem = new JMenuItem("重新开始");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("公众号");
    JMenuItem themeItem = new JMenuItem("切换主题");
    private void initData() {
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random random = new Random();
        for(int i = 0; i < tempArr.length; i++){
            int temp = tempArr[i];
            int randomIndex = random.nextInt(tempArr.length);
            tempArr[i] = tempArr[randomIndex];
            tempArr[randomIndex] = temp;
        }
        for(int i = 0; i < tempArr.length; i++){
            data[i / 4][i % 4] = tempArr[i];
            if(tempArr[i] == 0){
                x = i / 4;
                y = i % 4;
            }
        }
    }

    private void initImage() {
        //清空
        this.getContentPane().removeAll();

        if(victory()){
            JLabel winJLabel = new JLabel(ResourceLoader.createImageIcon("win.png"));
            winJLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winJLabel);
        }

        JLabel stepCount = new JLabel("步数：" + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);
        // 使用循环添加拼图图片
        for (int i = 1; i <= 16; i++) {
            // 计算行和列
            int row = (i - 1) / 4;
            int col = (i - 1) % 4;
            
            // 创建图片标签
            String imageName = data[row][col] + ".jpg";
            ImageIcon icon = ResourceLoader.createImageIcon(path + imageName);
            JLabel jLabel = new JLabel(icon);
            
            // 设置位置和大小
            jLabel.setBounds(col * 105+ 83, row * 105 +134, 105, 105);
            //给图片添加边框
            jLabel.setBorder(new BevelBorder(1));
            // 添加到窗体中
            this.getContentPane().add(jLabel);
        }
        //添加背景图片
        ImageIcon bg = ResourceLoader.createImageIcon("background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);
        //刷新页面
        this.getContentPane().repaint();
    }

    private void initJFrame() {
        this.setTitle("拼图游戏");
        this.setSize(603,680);

        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //取消居中默认放置
        this.setLayout(null);
        this.addKeyListener(this);
    }

    private void initJMenuBar() {
        JMenuBar jmenuBar = new JMenuBar();
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于");

        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);
        functionJMenu.add(themeItem);

        aboutJMenu.add(accountItem);
        //给条目绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        themeItem.addActionListener(this);

        jmenuBar.add(functionJMenu);
        jmenuBar.add(aboutJMenu);

        this.setJMenuBar(jmenuBar);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(victory()){
            return;
        }
        //如果按下A显示完整图片
        int code = e.getKeyCode();
        if (code==65) {
            this.getContentPane().removeAll();
            // 显示完整图片
            JLabel all = new JLabel(ResourceLoader.createImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);

            // 添加背景图片
            ImageIcon bg = ResourceLoader.createImageIcon("background.png");
            JLabel background = new JLabel(bg);
            background.setBounds(40,40,508,560);
            this.getContentPane().add(background);

            // 刷新页面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //根据用户按下的按键(上下左右)调整图片位置
        if(victory()){
            return;
        }
        int code = e.getKeyCode();
        if(code == 37){
            //按下的是左键
            if(y == 3){
                return;
            }
            data[x][y] = data[x][y+1];
            data[x][y+1] = 0;
            y++;
            step++;
            this.initImage();
        }else if(code == 38){
            //按下的是上键
            if(x == 3){
                return;
            }
            data[x][y] = data[x+1][y];
            data[x+1][y] = 0;
            x++;
            step++;
            this.initImage();
        }else if(code == 39){
            //按下的是右键
            if(y == 0){
                return;
            }
            data[x][y] = data[x][y-1];
            data[x][y-1] = 0;
            y--;
            step++;
            this.initImage();
        }else if(code == 40){
            //按下的是下键
            if(x == 0){
                return;
            }
            data[x][y] = data[x-1][y];
            data[x-1][y] = 0;
            x--;
            step++;
            this.initImage();
        } else if (code == 65){
            initImage();
        }else if (code == 87){
            data = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}
            };
            initImage();
        }
    }

    public boolean victory(){
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                if(data[i][j] != win[i][j]){
                    return false;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "胜利");
        x=y=3;
        step = 0;
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == replayItem){
            JOptionPane.showMessageDialog(this, "重新开始");
            step = 0;
            initData();
            initImage();
        }
        if(obj == reLoginItem){
            JOptionPane.showMessageDialog(this, "重新登录");
            this.dispose();
            new LoginFrame();
        }
        if(obj == closeItem){
            JOptionPane.showMessageDialog(this, "关闭游戏");
            System.exit(0);
        }
        if(obj == themeItem){
            // 打开主题选择对话框
            ThemeDialog themeDialog = new ThemeDialog(this);
            themeDialog.setVisible(true);
            
            if(themeDialog.isConfirmed()){
                String newTheme = themeDialog.getSelectedTheme();
                if(!newTheme.equals(currentTheme)){
                    currentTheme = newTheme;
                    path = ThemeManager.getThemePath(newTheme);
                    step = 0;
                    initData();
                    initImage();
                    JOptionPane.showMessageDialog(this, "主题已切换到：" + newTheme);
                }
            }
        }else if(obj == accountItem){
            ImageIcon icon = ResourceLoader.createImageIcon("about/wx.jpg");
            //JOptionPane.showMessageDialog(this, "", "公众号", JOptionPane.INFORMATION_MESSAGE, icon);
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(icon);
            jLabel.setBounds(0, 0, 258, 258);
            //jDialog.add(jLabel);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(344,344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        }
    }
}
