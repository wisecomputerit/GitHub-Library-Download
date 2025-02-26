package com.example.word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationExample {
    public static void main(String[] args) {
        // 创建 JFrame
        JFrame frame = new JFrame("Animation Example");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个面板，用于绘制动画
        AnimationPanel panel = new AnimationPanel();
        frame.add(panel);

        // 设置窗口居中显示
        frame.setLocationRelativeTo(null);

        // 显示窗口
        frame.setVisible(true);

        // 开始动画
        panel.startAnimation();
    }
}

class AnimationPanel extends JPanel {
    private int x = 0;  // 圆形的初始X坐标
    private int y = 100; // 圆形的Y坐标
    private static final int DIAMETER = 50; // 圆形的直径
    private Timer timer;  // 定时器，用于触发动画帧

    public AnimationPanel() {
        setBackground(Color.WHITE); // 设置背景颜色
    }

    public void startAnimation() {
        // 定时器每隔 10 毫秒更新一次位置
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x += 2; // 每次更新时增加X坐标
                if (x > getWidth()) {
                    x = 0;  // 如果圆形移出屏幕，重置X坐标
                }
                repaint(); // 重绘面板，触发动画
            }
        });
        timer.start();  // 启动定时器
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // 调用父类方法以清除之前的绘制内容
        g.setColor(Color.RED);  // 设置圆形颜色
        g.fillOval(x, y, DIAMETER, DIAMETER);  // 绘制一个红色圆形
    }
}
