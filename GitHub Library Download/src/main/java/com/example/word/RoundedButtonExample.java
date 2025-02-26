package com.example.word;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RoundedButtonExample {

    static boolean myVar = false;

    public static void main(String[] args) {
        // 正確呼叫並啟動視窗
        SwingUtilities.invokeLater(() -> new RoundedButtonExample().createAndShowGUI());
    }

    public void createAndShowGUI() {
        // 設定視窗標題和基本配置
        JFrame fFrame = new JFrame();
        fFrame.setTitle("圓角按鈕範例");
        fFrame.setSize(900, 700);
        fFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fFrame.setLocationRelativeTo(null); // 讓視窗出現在螢幕中央
        // 設定佈局並將按鈕添加到視窗
        fFrame.setLayout(null);  // 使用 null 布局
        // 創建圓角按鈕
    
        // 讀取圖片並創建 ImageIcon 物件
      //  ImageIcon icon = new ImageIcon("image.wise.🗂️//螢幕擷取畫面_2025-02-01_205041-removebg-preview.png"); // 替換為你自己的圖片路徑


        int sizew = 100;
        int sizeh = 50;
        JPanel panel = txt("A", sizew, sizeh,Color.BLACK,2);
        JPanel panel2 = txt("B", sizew, sizeh,Color.BLACK,2);
        // 創建一個ScheduledExecutorService對象，設置線程池大小為1
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // 定義每隔500毫秒執行一次的任務
        Runnable task = () -> {
            System.out.println("Checking condition... " + System.currentTimeMillis());
            System.out.println("myVar value: " + myVar);

            // 使用 SwingUtilities.invokeLater 來確保 UI 更新在 EDT 執行
            SwingUtilities.invokeLater(() -> {
            	

                
                RoundedButton button = new RoundedButton();

                // 需要給按鈕設置明確的大小和位置
                button.setBounds(50, 222, 200, 50); // 設定按鈕的位置和大小 (x, y, width, height)
                fFrame.getContentPane().add(button);  // 把按鈕加到視窗
                
                
                
                
                if (myVar==true) {
                    panel.setBounds(0, 0, 100, 50); // 顯示面板
                    
                    panel2.setBounds(100, 0, 100, 50); // 顯示面板
                    
                    
                    
                    
                    
                } else {
                    panel.setBounds(0, 0, 0, 0); // 隱藏面板
                    panel2.setBounds(0, 0, 0, 0); // 顯示面板
                }
                
                
                
                
                
            });
        };

        fFrame.add(panel);  // 將自訂面板加入視窗
        fFrame.add(panel2);  // 將自訂面板加入視窗
        // 啟動任務，延遲0毫秒後開始，每隔100毫秒執行一次
        scheduler.scheduleAtFixedRate(task, 0, 100, TimeUnit.MILLISECONDS);

        ImageIcon Settingsicon = new ImageIcon("image.wise.🗂️//螢幕擷取畫面_2025-02-01_205041-removebg-preview.png");
        Image Settingsimg = Settingsicon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
    //    button.setIcon(new ImageIcon(Settingsimg));

        

       
        // 顯示視窗
        fFrame.setVisible(true);
    }
    public static JPanel txt(String exe_name, int w, int h, Color borderColor, int borderThickness) {
        // 自訂 JPanel 顯示圓角邊框與文字
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // 取得 Graphics2D 以進行更多自定義
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 開啟抗鋸齒

                // 設定背景顏色為白色並繪製背景，讓背景的區域小於面板的大小
                int backgroundWidth = w - borderThickness * 2; // 背景的寬度
                int backgroundHeight = h - borderThickness * 2; // 背景的高度
                int backgroundX = borderThickness; // 背景的X位置
                int backgroundY = borderThickness; // 背景的Y位置

                g2d.setColor(Color.WHITE); // 設置背景顏色
                g2d.fillRect(backgroundX, backgroundY, backgroundWidth, backgroundHeight); // 填充背景

                // 設置圓角矩形邊框的顏色與大小
                int radius = 20;
                g2d.setColor(borderColor); // 邊框顏色
                g2d.setStroke(new BasicStroke(borderThickness));  // 設定邊框寬度

                // 繪製圓角邊框
                g2d.drawRoundRect(borderThickness / 2, borderThickness / 2, w - borderThickness, h - borderThickness, radius, radius);

                // 設置文字顏色為黑色
                g2d.setColor(Color.BLACK);  // 文字顏色
                g2d.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20)); // 設置文字字體與大小

                // 計算文字的寬度與高度，使其居中
                String text = exe_name;
                FontMetrics fm = g2d.getFontMetrics();
                int x = (w - fm.stringWidth(text)) / 2;  // 文字水平置中
                int y = (h + fm.getAscent()) / 2; // 文字垂直置中

                // 畫文字
                g2d.drawString(text, x, y);
            }
        };

        // 設置 JPanel 的大小，保證其不會超出邊界
        panel.setPreferredSize(new Dimension(w, h));

        // 不需要額外的空白間隙，使用 null layout 管理元件
        panel.setLayout(null);

        return panel;
    }

    // 自定義圓角按鈕類
    class RoundedButton extends JButton {
    	
    	
        public RoundedButton() {
           
            setFocusPainted(false);  // 去掉按鈕的焦點效果
            setContentAreaFilled(false);  // 去掉按鈕的背景
            setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));  // 設置按鈕邊距
        }

        @Override
        protected void paintComponent(Graphics g) {
            // 設置按鈕的背景顏色
            if (getModel().isPressed()) {
                g.setColor(new Color(200, 200, 255));  // 按下時的顏色
            } else if (getModel().isRollover()) {
                g.setColor(new Color(255, 255, 255));  // 滑鼠懸停時的顏色
            } else {
                g.setColor(new Color(255, 255, 255));  // 默認背景顏色
            }

            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();

            // 畫圓角矩形背景
            g2d.fillRoundRect(0, 0, width, height, 30, 30);  // 這裡控制圓角半徑

            // 僅在滑鼠懸停時畫圓角邊框
            if (getModel().isRollover()) {
                g2d.setColor(Color.DARK_GRAY);  // 邊框顏色
                g2d.setStroke(new BasicStroke(2));  // 邊框線條粗細
                g2d.drawRoundRect(0, 0, width, height, 30, 30);  // 畫圓角邊框

                myVar = true;  // 當滑鼠懸停時設置 myVar 為 true
            } else {
                myVar = false;  // 當滑鼠不懸停時設置 myVar 為 false
            }

        
        }
    }
}


