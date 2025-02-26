package com.example.word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RefreshWindowExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createWindow());
    }

    public static void createWindow() {
        // 創建初始視窗
        JFrame frame = new JFrame("Refresh Window Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // 視窗居中顯示

        // 設置佈局和按鈕
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Click 'Refresh' to reload the content.");
        panel.add(label);

        JButton refreshButton = new JButton("Refresh");
        panel.add(refreshButton);

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshWindow(frame);  // 重新刷新視窗
            }
        });

        frame.setVisible(true);
    }

    // 刷新視窗的方法
    public static void refreshWindow(JFrame frame) {
        // 清除當前視窗內容
        frame.getContentPane().removeAll();  // 移除所有元件
       
        
        // 重新設置視窗的內容
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Content has been reloaded!");
        panel.add(label);

     
        JButton closeButton = new JButton("Close");
        panel.add(closeButton);
        // 按下 'Close' 按鈕，關閉視窗
        closeButton.addActionListener(e -> frame.dispose());
        
        
        // 重新繪製界面
        frame.revalidate();  // 重新驗證界面佈局
        frame.repaint();     // 重新繪製界面
        
        
        
   
    }
}
