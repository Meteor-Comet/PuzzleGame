package com.puzzle.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemeDialog extends JDialog implements ActionListener {
    
    private JComboBox<String> themeComboBox;
    private JButton confirmButton;
    private JButton cancelButton;
    private String selectedTheme;
    private boolean confirmed = false;
    
    public ThemeDialog(JFrame parent) {
        super(parent, "选择主题", true);
        initComponents();
        pack();
        setLocationRelativeTo(parent);
    }
    
    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        
        // 创建主面板
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // 标题标签
        JLabel titleLabel = new JLabel("请选择拼图主题：");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        
        mainPanel.add(Box.createVerticalStrut(20));
        
        // 主题选择下拉框
        String[] themes = ThemeManager.getAllThemeNames();
        themeComboBox = new JComboBox<>(themes);
        themeComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        themeComboBox.setMaximumSize(new Dimension(200, 30));
        themeComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        themeComboBox.setSelectedItem("动物3"); // 默认选择
        mainPanel.add(themeComboBox);
        
        mainPanel.add(Box.createVerticalStrut(30));
        
        // 按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        
        confirmButton = new JButton("确定");
        confirmButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        confirmButton.addActionListener(this);
        
        cancelButton = new JButton("取消");
        cancelButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        cancelButton.addActionListener(this);
        
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        
        mainPanel.add(buttonPanel);
        
        add(mainPanel, BorderLayout.CENTER);
        
        // 设置对话框属性
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            selectedTheme = (String) themeComboBox.getSelectedItem();
            confirmed = true;
            dispose();
        } else if (e.getSource() == cancelButton) {
            confirmed = false;
            dispose();
        }
    }
    
    /**
     * 获取选择的主题
     * @return 主题名称
     */
    public String getSelectedTheme() {
        return selectedTheme;
    }
    
    /**
     * 是否确认选择
     * @return 是否确认
     */
    public boolean isConfirmed() {
        return confirmed;
    }
} 