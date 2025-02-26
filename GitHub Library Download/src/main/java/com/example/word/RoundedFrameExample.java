package com.example.word;

import javax.swing.*;
import java.awt.*;

public class RoundedFrameExample {
    public static void main(String[] args) {
        // 创建自定义的 JFrame 类来处理圆角绘制
        JFrame frame = new JFrame("Rounded JFrame Example");

        // 设置窗口大小
        frame.setSize(400, 300);

        // 设置窗口关闭操作
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 移除标题栏
        frame.setUndecorated(true); // 移除标题栏

        // 设置窗口背景色
        frame.setBackground(new Color(0, 0, 0, 0)); // 设置透明背景

        // 自定义的 JPanel，重写 paintComponent 方法来绘制圆角
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // 设置抗锯齿
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // 设置圆角半径
                int arcSize = 30;

                // 绘制圆角矩形
                g2d.setColor(Color.WHITE);  // 设置填充颜色为白色
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arcSize, arcSize);

                // 绘制边框
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(4)); // 设置边框线宽
                g2d.drawRoundRect(0, 0, getWidth(), getHeight(), arcSize, arcSize);
            }
        };

        // 设置面板的布局为 null，允许自由定位组件
        panel.setLayout(null);
        frame.add(panel);

        // 创建一个 JLabel，用于显示文本
        JLabel label = new JLabel("Rounded JFrame with Text", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 20));

        // 设置标签的位置和大小，居中显示
        label.setBounds(50, 130, 300, 40);  // (x, y, width, height)

        // 将标签添加到面板中
        panel.add(label);

        // 设置窗口居中显示
        frame.setLocationRelativeTo(null);

        // 显示窗口
        frame.setVisible(true);
    }
}
