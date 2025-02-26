package com.example.word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FadeInWindow extends JFrame {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 300;
    private float opacity = 0.0f;  // 初始透明度为 0
    private Timer fadeTimer;  // 用来控制渐变效果的定时器

    public FadeInWindow() {
        setUndecorated(true);  // 移除窗口的边框和标题栏
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);  // 居中显示窗口
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建渐变定时器，每隔 30 毫秒更新一次透明度
        fadeTimer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (opacity < 1.0f) {
                    opacity += 0.05f;  // 渐变增量
                    if (opacity > 1.0f) {
                        opacity = 1.0f;  // 确保透明度不超过 1.0f
                    }
                    setOpacity(opacity);  // 更新窗口透明度
                    repaint();  // 重绘窗口
                } else {
                    fadeTimer.stop();  // 渐变完成，停止定时器
                    showMainWindow();  // 渐变结束后显示主窗口内容
                }
            }
        });

        fadeTimer.start();  // 启动渐变效果
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 渐变期间可以绘制一些简单的文本或图形
        if (opacity < 1.0f) {
            g.setColor(Color.BLACK);
            g.drawString("Fading In...", 150, 150);  // 渐变过程中显示的文字
        }
    }

    private void showMainWindow() {
        // 当渐变完成后，创建并显示主窗口
        JFrame mainWindow = new JFrame("Main Window");
        mainWindow.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);  // 居中显示
        mainWindow.setVisible(true);  // 显示主窗口

        // 在主窗口中添加标签或者其他组件
        JLabel label = new JLabel("Welcome to the Main Window", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        mainWindow.add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FadeInWindow().setVisible(true);  // 显示渐变的透明窗口
            }
        });
    }
}
