package com.example.word;

public class ArrayConversion {
    public static void main(String[] args) {
        // 假設這是原始的 String[] path
        String[] path = {
            "path1", "path2", "path3", "path4", "path5", "path6", "path7", "path8", 
            "path9", "path10", "path11", "path12", "path13", "path14", "path15", "path16",
            "path17", "path18", "path19", "path20"
        };

        // 假設每列的長度為 12
        int rowLength = 12;
        
        // 計算需要的行數
        int rows = (int) Math.ceil((double) path.length / rowLength);

        // 創建二維陣列 String[][]
        String[][] newPath = new String[rows][];

        // 把一維陣列轉換成二維陣列，每行包含最多 12 個元素
        for (int i = 0; i < rows; i++) {
            // 計算每行的起始索引和結束索引
            int start = i * rowLength;
            int end = Math.min(start + rowLength, path.length);
            
            // 創建每行的子陣列並複製相應的元素
            newPath[i] = new String[end - start];
            System.arraycopy(path, start, newPath[i], 0, end - start);
        }

        // 輸出結果
        for (int i = 0; i < newPath.length; i++) {
            System.out.print("Row " + (i + 1) + ": ");
            for (String p : newPath[i]) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }
}
