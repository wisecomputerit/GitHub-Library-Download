package download;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class MoveFolder {
    public static void main(String name) {
  

        // 取得用戶提供的源文件夾路徑
        String sourcePath = name;
        
        // 目標桌面路徑
        String desktopPath = System.getProperty("user.home") + "/OneDrive/Desktop";  // 使用環境變數取得桌面路徑
        
        Path sourceFolderPath = Paths.get(sourcePath);
        Path destinationFolderPath = Paths.get(desktopPath, sourceFolderPath.getFileName().toString());

        // 檢查源文件夾是否存在
        if (!Files.exists(sourceFolderPath) || !Files.isDirectory(sourceFolderPath)) {
            System.out.println("源文件夾不存在或不是一個有效的文件夾！");
            return;
        }

        try {
            // 如果目標位置已經有同名文件夾，刪除它
            if (Files.exists(destinationFolderPath)) {
                System.out.println("目標文件夾已經存在，正在刪除...");
                deleteFolder(destinationFolderPath.toFile());
            }

            // 移動文件夾
            Files.move(sourceFolderPath, destinationFolderPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("文件夾成功移動到桌面！");
        } catch (IOException e) {
            System.out.println("文件夾移動失敗！" + e.getMessage());
        }
    }

    // 刪除文件夾及其內容
    private static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolder(file); // 遞歸刪除子文件夾
                } else {
                    if (file.delete()) {
                        System.out.println("已刪除文件：" + file.getAbsolutePath());
                    } else {
                        System.out.println("無法刪除文件：" + file.getAbsolutePath());
                    }
                }
            }
        }
        if (folder.delete()) {
            System.out.println("已刪除文件夾：" + folder.getAbsolutePath());
        } else {
            System.out.println("無法刪除文件夾：" + folder.getAbsolutePath());
        }
    }
}
