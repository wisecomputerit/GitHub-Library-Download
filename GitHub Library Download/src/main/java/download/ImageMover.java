package download;

import java.io.*;
import java.nio.file.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class ImageMover {
    public static void main(String readname,String filename) {
        // 输入文件路径和目标文件路径
        String sourcePath = readname; // 源图片路径
        String destinationPath = filename; // 目标路径
        // 获取文件扩展名
        String fileExtension = getFileExtension(sourcePath);
        
        System.out.print(fileExtension);
        try {
            // 读取图片
            File sourceFile = new File(sourcePath);
            BufferedImage image = ImageIO.read(sourceFile);

            // 复制到新位置
            File destinationFile = new File(destinationPath);
            ImageIO.write(image, fileExtension, destinationFile);  // 保存为新的图片文件

            // 打印消息
            System.out.println("图片已成功转移到: " + destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getFileExtension(String filePath) {
        int lastIndexOf = filePath.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return null;  // 没有扩展名
        }
        return filePath.substring(lastIndexOf + 1).toLowerCase();
    }
}
